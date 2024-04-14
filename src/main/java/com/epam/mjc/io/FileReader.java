package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                String key = parts[0];
                String value = parts[1];
                switch (key) {
                    case "Name":
                        profile.setName(value);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        profile.setEmail(value);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(value));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return profile;
    }
}
class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File("C:\\Users\\2RS\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");
        Profile profile = fileReader.getDataFromFile(file);
        System.out.println(profile);
    }
}