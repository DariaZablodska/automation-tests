package com.cucumber.tests.homework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Simple properties based config for test user.
 */
public class UserConfig {

    public void init(InputStream inputStream) {
        Properties p = new Properties();
        try {
            p.load(inputStream);
            username = p.getProperty("username");
            password = p.getProperty("password");
        } catch (IOException e) {
            System.err.println("An error has been occured while open properties." + e.getMessage());
        }
    }

    static String username = "";
    static String password = "";
}
