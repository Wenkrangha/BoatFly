package com.wenkrang.boatfly.BootLoader;

import com.wenkrang.boatfly.BoatFly;
import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.event.GUI.book.Main;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.bukkit.Bukkit.getServer;


public class Setup {
    public PluginDescriptionFile getPluginDescription(File pluginFile) throws IOException {
        // 创建ZipFile对象来读取jar文件
        try (ZipFile zipFile = new ZipFile(pluginFile)) {
            // 查找plugin.yml文件条目
            ZipEntry pluginYmlEntry = zipFile.getEntry("plugin.yml");

            // 从zip条目中读取内容到Reader
            try (InputStream inputStream = zipFile.getInputStream(pluginYmlEntry);
                 Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

                // 使用PluginDescriptionFile的构造函数从Reader中创建对象
                PluginDescriptionFile pdf = new PluginDescriptionFile(reader);

                return pdf;
            } catch (InvalidDescriptionException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void deleteFile(File file){
        //判断file不是空文件夹
        File [] files = file.listFiles();
        if(files!=null && files.length!=0){
            for(File file1 : files){
                this.deleteFile(file1);
            }
        }
        //删除file (file是个文件或file是一个空文件夹)
        file.delete();
    }
    public void setup () throws IOException, InvalidPluginException, InvalidDescriptionException {
        getServer().getConsoleSender().sendMessage("    ____              __  ________     ");
        getServer().getConsoleSender().sendMessage("   / __ )____  ____ _/ /_/ ____/ /_  __");
        getServer().getConsoleSender().sendMessage("  / __  / __ \\/ __ `/ __/ /_  / / / / /");
        getServer().getConsoleSender().sendMessage(" / /_/ / /_/ / /_/ / /_/ __/ / / /_/ / ");
        getServer().getConsoleSender().sendMessage("/_____/\\____/\\__,_/\\__/_/   /_/\\__, /  ");
        getServer().getConsoleSender().sendMessage("                              /____/   ");
        ConsoleLoger.info("欢迎使用BoatFly,即将进行全新安装");
        ConsoleLoger.info("清空BoatFly文件中.....");
        deleteFile(new File("./plugins/BoatFly"));
        ConsoleLoger.info("正在复制文件...");
        Files.copy(new File("E:\\DevServer - 副本\\plugins\\EssentialsX-2.21.0-dev+42-8a57856.jar").toPath(), new File("./plugins/BoatFly/version/BoatFly-" + MainData.PluginName + ".jar").toPath());

        //安装bootloader
        ClassLoader classLoader = BoatFly.class.getClassLoader();
        URL url = classLoader.getResource("BootLoader/BoatFly-BootLoader-1.0.jar");
        InputStream inputStream = url.openStream();
        if (new File("./plugins/BoatFly-BootLoader-1.0.jar").exists()) {
            new File("./plugins/BoatFly-BootLoader-1.0.jar").delete();
        }
        Files.copy(inputStream, new File("./plugins/BoatFly-BootLoader-1.0.jar").toPath());
        inputStream.close();

        //写入配置信息
        if (true) {
            File file = new File("./plugins/BoatFly/SetupName");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter("./plugins/BoatFly/SetupName");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("BoatFly-" + MainData.PluginName + ".jar");
            bufferedWriter.close();
            fileWriter.close();
        }

        //版本号
        if (true) {
            File file = new File("./plugins/BoatFly/ThisNumber");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter("./plugins/BoatFly/ThisNumber");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(MainData.Number);
            bufferedWriter.close();
            fileWriter.close();
        }

        getServer().getPluginManager().loadPlugin();



    }
}
