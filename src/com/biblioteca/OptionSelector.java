package com.biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 25/09/2016.
 */
public class OptionSelector{


    public void optionOne(Bookshelf bookshelf){
        System.out.print("Here are the books available: \n");
        bookshelf.printCheckedInBookInfo();
    }


    public void select(Integer input, Bookshelf bookshelf) {
        RunOption commandOne = new RunOption() {@Override public void run() { optionOne(bookshelf); } };
        Map<Integer, RunOption> methodMap = new HashMap<>();
        methodMap.put(1, commandOne);
        try {
            RunOption option = methodMap.get(input);
            option.run();
        } catch (NullPointerException e){
            System.out.print("Invalid menu option. Please select again.");
        }
    }
}

