package com.wenkrang.boatfly.DataSystem;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;

public class DataManager {
    public File DataBasePath = null;

    public void setDataBasePath(File dataBasePath) {
        DataBasePath = dataBasePath;
    }

    public void set(String name, String value) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        DataBasePath.mkdirs();
        File file = new File(DataBasePath.getPath() + "/" + name + ".json");
        file.delete();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(json);
        bufferedWriter.close();
        fileWriter.close();
    }

    public Object get (String name, Type typeOfT) throws IOException {
        File file = new File(DataBasePath.getPath() + "/" + name + ".json");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        Gson gson = new Gson();
        Object o = gson.fromJson(line, typeOfT);
        return o;
    }

    public void delete(String name) throws IOException {
        File file = new File(DataBasePath.getPath() + "/" + name + ".json");
        file.delete();
    }
}
