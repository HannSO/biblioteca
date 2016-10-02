package com.biblioteca.Menu;
//
//import com.biblioteca.PrettyPrintingMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by Robin on 24/09/2016.
 */
public class Menu {

    public Hashtable<Integer, String> options = new Hashtable<>();

    public void addMenuItem(Integer integer, String command) {
        options.put(integer, command);
    }

    public void displayOptions() {
        System.out.println("\nSelect an option:");
        System.out.println((Arrays.toString(options.entrySet().toArray()))+"\n");
    }

}

