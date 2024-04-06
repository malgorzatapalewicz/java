package com.ocado.json;

//Gson
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//FileReader
import java.io.FileReader;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.*;

public class Json {
    public static Map<String, List<String>> jsonToMap(String filePath){
        //reading data from a file
        try(FileReader reader = new FileReader(filePath)){
            Gson gson = new Gson();
            Type mapType = new TypeToken<HashMap<String, List<String>>>() {}.getType();
            return gson.fromJson(reader, mapType);

        } catch (IOException e) {
            throw new RuntimeException("Error while reading JSON file", e);
        }
    }
}