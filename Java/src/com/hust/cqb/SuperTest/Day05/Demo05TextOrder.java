package com.hust.cqb.SuperTest.Day05;

import java.io.*;
import java.util.HashMap;

public class Demo05TextOrder {
    public static void main(String[] args) {
        try {
            HashMap<String, String> map = new HashMap<>();
            BufferedReader br = new BufferedReader(new FileReader("FileTest/in.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("FileTest/out.txt"));
            String line;
            while ((line=br.readLine())!=null) {
                String[] arr = line.split("\\.");
                map.put(arr[0], arr[1]);
            }
            for (String key:map.keySet()) {
                String value = map.get(key);
                line = key+"."+value+"\r\n";
                bw.write(line);
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
