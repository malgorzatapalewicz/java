package com.ocado;

import java.util.*;
import static com.ocado.json.Json.jsonToMap;

public class Main {
    public static void main(String[] args) {
        //reading JSON file containing delivery information for products
        String filePath = "src/main/resources/config.json";
        Map<String, List<String>> map = jsonToMap(filePath);


        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String product = entry.getKey();
            List<String> methodList = entry.getValue();
            System.out.println("Delivery methods: " + methodList);
            System.out.println("Product: " + product);
        }
    }
}