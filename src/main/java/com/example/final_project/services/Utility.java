package com.example.final_project.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        String emailReg = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern emailPattern = Pattern.compile(emailReg);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public String[] loadDBInfo(String filePath) {
        Properties props = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            System.out.println("File not found");
            return null;
        }
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                props.load(reader);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String[] dbInfo = new String[6];
        dbInfo[0] = props.getProperty("db");
        dbInfo[1] = props.getProperty("name");
        dbInfo[2] = props.getProperty("host");
        dbInfo[3] = props.getProperty("pass");
        dbInfo[4] = props.getProperty("port");
        dbInfo[5] = props.getProperty("user");
        return dbInfo;
    }

    public static String md5Encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            // Handle exception
        }
        return null;
    }
}
