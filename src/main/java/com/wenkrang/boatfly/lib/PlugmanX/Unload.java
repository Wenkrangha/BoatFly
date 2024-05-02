package com.wenkrang.boatfly.lib.PlugmanX;

import com.wenkrang.boatfly.BoatFly;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/*
 * #%L
 * PlugMan
 * %%
 * Copyright (C) 2010 - 2014 PlugMan
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

/**
 * Utilities for managing plugins.
 *
 * @author rylinaux
 */
public class Unload {
    //TODO: Clean this class up, I don't like how it currently looks
    private final Class<?> pluginClassLoader;
    private final Field pluginClassLoaderPlugin;
    private Field commandMapField;
    private Field knownCommandsField;
    private String nmsVersion = null;

    {
        try {
            this.pluginClassLoader = Class.forName("org.bukkit.plugin.java.PluginClassLoader");
            this.pluginClassLoaderPlugin = this.pluginClassLoader.getDeclaredField("plugin");
            this.pluginClassLoaderPlugin.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    protected void unloadCommands(Plugin plugin) {
        Map<String, Command> knownCommands = this.getKnownCommands();
        List<Map.Entry<String, Command>> commands = knownCommands.entrySet().stream()
                .filter(s -> {
                    if (s.getKey().contains(":"))
                        return s.getKey().split(":")[0].equalsIgnoreCase(plugin.getName());
                    else {
                        ClassLoader cl = s.getValue().getClass().getClassLoader();
                        try {
                            return cl.getClass() == this.pluginClassLoader && this.pluginClassLoaderPlugin.get(cl) == plugin;
                        } catch (IllegalAccessException e) {
                            return false;
                        }
                    }
                })
                .collect(Collectors.toList());

        for (Map.Entry<String, Command> entry : commands) {
            String alias = entry.getKey();
            BoatFly.getInstance().getBukkitCommandWrap().unwrap(alias);
        }

        for (Map.Entry<String, Command> entry : knownCommands.entrySet().stream().filter(stringCommandEntry -> Plugin.class.isAssignableFrom(stringCommandEntry.getValue().getClass())).filter(stringCommandEntry -> {
            Field pluginField = Arrays.stream(stringCommandEntry.getValue().getClass().getDeclaredFields()).filter(field -> Plugin.class.isAssignableFrom(field.getType())).findFirst().orElse(null);
            if (pluginField != null) {
                Plugin owningPlugin;
                try {
                    owningPlugin = (Plugin) pluginField.get(stringCommandEntry.getValue());
                    return owningPlugin.getName().equalsIgnoreCase(plugin.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            return false;
        }).collect(Collectors.toList())) {
            String alias = entry.getKey();
            BoatFly.getInstance().getBukkitCommandWrap().unwrap(alias);
        }

        BoatFly.getInstance().getBukkitCommandWrap().sync();

        if (Bukkit.getOnlinePlayers().size() >= 1)
            for (Player player : Bukkit.getOnlinePlayers()) player.updateCommands();
    }
    public Map<String, Command> getKnownCommands() {
        if (this.commandMapField == null) try {
            this.commandMapField = Class.forName(BukkitCommandWrap.cbPrefix("CraftServer")).getDeclaredField("commandMap");
            this.commandMapField.setAccessible(true);
        } catch (NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        SimpleCommandMap commandMap;
        try {
            commandMap = (SimpleCommandMap) this.commandMapField.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if (this.knownCommandsField == null) try {
            this.knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");
            this.knownCommandsField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }

        Map<String, Command> knownCommands;

        try {
            knownCommands = (Map<String, Command>) this.knownCommandsField.get(commandMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        return knownCommands;
    }

    /**
     * Unload a plugin.
     *
     * @param plugin the plugin to unload
     * @return the message to send to the user.
     */

    public String unload(Plugin plugin) {
        String name = plugin.getName();

        if (!PlugManAPI.getGentleUnloads().containsKey(plugin)) {
            if (!(BoatFly.getInstance().getBukkitCommandWrap() instanceof BukkitCommandWrap_Useless))
                this.unloadCommands(plugin);

            PluginManager pluginManager = Bukkit.getPluginManager();

            SimpleCommandMap commandMap = null;

            List<Plugin> plugins = null;

            Map<String, Plugin> names = null;
            Map<String, Command> commands = null;
            Map<Event, SortedSet<RegisteredListener>> listeners = null;

            boolean reloadlisteners = true;

            if (pluginManager != null) {

                pluginManager.disablePlugin(plugin);

                try {

                    Field pluginsField = Bukkit.getPluginManager().getClass().getDeclaredField("plugins");
                    pluginsField.setAccessible(true);
                    plugins = (List<Plugin>) pluginsField.get(pluginManager);

                    Field lookupNamesField = Bukkit.getPluginManager().getClass().getDeclaredField("lookupNames");
                    lookupNamesField.setAccessible(true);
                    names = (Map<String, Plugin>) lookupNamesField.get(pluginManager);

                    try {
                        Field listenersField = Bukkit.getPluginManager().getClass().getDeclaredField("listeners");
                        listenersField.setAccessible(true);
                        listeners = (Map<Event, SortedSet<RegisteredListener>>) listenersField.get(pluginManager);
                    } catch (Exception e) {
                        reloadlisteners = false;
                    }

                    Field commandMapField = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
                    commandMapField.setAccessible(true);
                    commandMap = (SimpleCommandMap) commandMapField.get(pluginManager);

                    Field knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");
                    knownCommandsField.setAccessible(true);
                    commands = (Map<String, Command>) knownCommandsField.get(commandMap);

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();

                }

            }

            pluginManager.disablePlugin(plugin);

            if (listeners != null && reloadlisteners)
                for (SortedSet<RegisteredListener> set : listeners.values())
                    set.removeIf(value -> value.getPlugin() == plugin);

            if (commandMap != null)
                for (Iterator<Map.Entry<String, Command>> it = commands.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, Command> entry = it.next();
                    if (entry.getValue() instanceof PluginCommand) {
                        PluginCommand c = (PluginCommand) entry.getValue();
                        if (c.getPlugin() == plugin) {
                            c.unregister(commandMap);
                            it.remove();
                        }
                    } else try {
                        Field pluginField = Arrays.stream(entry.getValue().getClass().getDeclaredFields()).filter(field -> Plugin.class.isAssignableFrom(field.getType())).findFirst().orElse(null);
                        if (pluginField != null) {
                            Plugin owningPlugin;
                            try {
                                pluginField.setAccessible(true);
                                owningPlugin = (Plugin) pluginField.get(entry.getValue());
                                if (owningPlugin.getName().equalsIgnoreCase(plugin.getName())) {
                                    entry.getValue().unregister(commandMap);
                                    it.remove();
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IllegalStateException e) {
                        if (e.getMessage().equalsIgnoreCase("zip file closed")) {

                            entry.getValue().unregister(commandMap);
                            it.remove();
                        }
                    }
                }

            if (plugins != null && plugins.contains(plugin))
                plugins.remove(plugin);

            if (names != null && names.containsKey(name))
                names.remove(name);
        } else {
            GentleUnload gentleUnload = PlugManAPI.getGentleUnloads().get(plugin);
            if (!gentleUnload.askingForGentleUnload())
                return name + "did not want to unload";
        }

        // Attempt to close the classloader to unlock any handles on the plugin's jar file.
        ClassLoader cl = plugin.getClass().getClassLoader();
        if (cl instanceof URLClassLoader) {
            try {

                Field pluginField = cl.getClass().getDeclaredField("plugin");
                pluginField.setAccessible(true);
                pluginField.set(cl, null);

                Field pluginInitField = cl.getClass().getDeclaredField("pluginInit");
                pluginInitField.setAccessible(true);
                pluginInitField.set(cl, null);

            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {

            }

            try {

                ((URLClassLoader) cl).close();
            } catch (IOException ex) {

            }

        }

        // Will not work on processes started with the -XX:+DisableExplicitGC flag, but lets try it anyway.
        // This tries to get around the issue where Windows refuses to unlock jar files that were previously loaded into the JVM.
        System.gc();

        return "";

    }
}