package com.biblioteca;

import java.util.Hashtable;
import java.util.Set;

/**
 * Created by Robin on 24/09/2016.
 */
public class Menu {

    public Hashtable<String, String> options = new Hashtable<>();

    public void addMenuItem(String name, String command) {
        options.put(name, command);
    }

    public void displayMenu() {

        Set<String> keys = options.keySet();
        for (String key : keys) {
            System.out.printf("Key : %s and Value %s %n", options.get(key), key);
        }
    }
}

