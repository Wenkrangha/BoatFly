package com.wenkrang.boatfly.lib.PlugmanX;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BukkitCommandWrap {

    private String nmsVersion;

    private Field bField;
    private Method removeCommandMethod;
    private Class minecraftServerClass;
    private Method aMethod;
    private Method getServerMethod;
    private Field vanillaCommandDispatcherField;
    private Method getCommandDispatcherMethod;
    private Method registerMethod;
    private Method syncCommandsMethod;
    private Constructor bukkitcommandWrapperConstructor;

    private static @NotNull String cbPrefix() {
        return Bukkit.getServer().getClass().getPackage().getName();
    }

    public static @NotNull String cbPrefix(String cbClassName) {
        return cbPrefix() + "." + cbClassName;
    }

    private boolean resolveRemoveCommandMethod() {
        if (this.removeCommandMethod == null) try {
            try {
                this.removeCommandMethod = RootCommandNode.class.getDeclaredMethod("removeCommand", String.class);
            } catch (NoSuchMethodException | NoSuchMethodError ex) {
                this.removeCommandMethod = CommandNode.class.getDeclaredMethod("removeCommand", String.class);
            }
            return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private boolean resolveRegisterCmdMethod() {
        if (this.registerMethod == null) try {
            this.registerMethod = Class.forName(cbPrefix("command.BukkitCommandWrapper"))
                    .getMethod("register", CommandDispatcher.class, String.class);
            this.registerMethod.setAccessible(true);
            return true;
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void wrap(Command command, String alias) {
        if (this.nmsVersion == null) return;

        if (!resolveGetServerMethod()) return;
        Object minecraftServer = getServerInstance();

        if (!resolveVanillaCommandDispatcherField()) return;
        Object commandDispatcher = getCommandDispatcher(minecraftServer);
        if (commandDispatcher == null) return;


        if (!resolveAMethod(commandDispatcher)) return;

        if (!resolveBukkitCmdWrapperConstructor()) return;
        Object commandWrapper = getCommandWrapper(command);
        if (commandWrapper == null) return;

        Object aInstance = getAInstance(commandDispatcher);
        if (aInstance == null) return;

        if (!resolveRegisterCmdMethod()) return;

        try {
            this.registerMethod.invoke(commandWrapper, aInstance, alias);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void sync() {
        if (this.syncCommandsMethod == null) try {
            this.syncCommandsMethod = Class.forName(cbPrefix("CraftServer")).getDeclaredMethod("syncCommands");
            this.syncCommandsMethod.setAccessible(true);

            if (Bukkit.getOnlinePlayers().size() >= 1)
                for (Player player : Bukkit.getOnlinePlayers())
                    player.updateCommands();
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            this.syncCommandsMethod.invoke(Bukkit.getServer());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void unwrap(String command) {
        if (this.nmsVersion == null) return;


        if (!resolveGetServerMethod()) return;
        Object server = getServerInstance();

        if (!resolveVanillaCommandDispatcherField()) return;
        Object commandDispatcher = getCommandDispatcher(server);


        CommandDispatcher b = getDispatcher(commandDispatcher);
        if (b == null) return;

        if (!resolveRemoveCommandMethod()) return;

        try {
            this.removeCommandMethod.invoke(b.getRoot(), command);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }



    private @Nullable CommandDispatcher getDispatcher(Object commandDispatcher) {
        try {
            return (CommandDispatcher) this.bField.get(commandDispatcher);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private @Nullable Object getCommandDispatcher(Object server) {
        try {
            return this.vanillaCommandDispatcherField.get(server);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object getServerInstance() {
        try {
            return this.getServerMethod.invoke(this.minecraftServerClass);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean resolveGetServerMethod() {
        if (this.getServerMethod == null) {
            try {
                this.getServerMethod = this.minecraftServerClass.getMethod("getServer");
                this.getServerMethod.setAccessible(true);
                return true;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean resolveVanillaCommandDispatcherField() {
        if (this.vanillaCommandDispatcherField == null) {
            try {
                this.vanillaCommandDispatcherField = this.minecraftServerClass.getDeclaredField("vanillaCommandDispatcher");
                this.vanillaCommandDispatcherField.setAccessible(true);
                return true;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private Object getAInstance(Object commandDispatcher) {
        try {
            return this.aMethod.invoke(commandDispatcher);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private @Nullable Object getCommandWrapper(Command command) {
        try {
            return this.bukkitcommandWrapperConstructor.newInstance(Bukkit.getServer(), command);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean resolveBukkitCmdWrapperConstructor() {
        if (this.bukkitcommandWrapperConstructor == null) {
            try {
                this.bukkitcommandWrapperConstructor = Class.forName(cbPrefix("command.BukkitCommandWrapper")).getDeclaredConstructor(Class.forName("org.bukkit.craftbukkit." + this.nmsVersion + ".CraftServer"), Command.class);
                this.bukkitcommandWrapperConstructor.setAccessible(true);
                return true;
            } catch (NoSuchMethodException | ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean resolveAMethod(Object commandDispatcher) {
        if (this.aMethod == null) try {
            this.aMethod = commandDispatcher.getClass().getDeclaredMethod("a");
            this.aMethod.setAccessible(true);
            return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
