package com.biblioteca;

import java.util.Hashtable;

/**
 * Created by Robin on 24/09/2016.
 */
public class Menu {

    public Hashtable<String, String> options = new Hashtable<>();

    public void addMenuItem(String name, String command){
        options.put(name,command);
    }

    public String StringCommandfromOption(String optionName){
       return options.get(optionName);
    }

}
