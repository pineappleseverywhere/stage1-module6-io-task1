package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public Profile getDataFromFile(File file) throws FileNotFoundException {
        Profile profile = new Profile();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                parseLine(line, profile);
            }
        }
        return profile;
    }

    private void parseLine(String line, Profile profile) {
        String[] parts = line.split(": ");
        if (parts.length == 2) {
            String key = parts[0].trim();
            String value = parts[1].trim();
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
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File("C:\\Users\\2RS\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");
        try {
            Profile profile = fileReader.getDataFromFile(file);
            System.out.println(profile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
