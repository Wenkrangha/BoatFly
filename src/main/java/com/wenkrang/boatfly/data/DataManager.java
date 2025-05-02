package com.wenkrang.boatfly.data;

import com.google.gson.reflect.TypeToken;

import java.io.*;

@Deprecated
@SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
public class DataManager {
    public File getDataBasePath() {
        return dataBasePath;
    }

    public void setDataBasePath(File dataBasePath) {
        this.dataBasePath = dataBasePath;
    }

    private File dataBasePath = null;

    public void set(String name, Object value) throws IOException {
        String json = MainData.gson.toJson(value);
        dataBasePath.mkdirs();
        File file = new File(dataBasePath.getPath() + "/" + name + ".json");
        file.delete();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(json);
        bufferedWriter.close();
        fileWriter.close();
    }

    public <T> T get(String name) throws IOException {
        File file = new File(dataBasePath.getPath() + "/" + name + ".json");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        return MainData.gson.fromJson(line, new TypeToken<>(){});
    }

    public void delete(String name) {
        File file = new File(dataBasePath.getPath() + "/" + name + ".json");
        file.delete();
    }
}
