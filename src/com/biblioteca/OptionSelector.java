package com.biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 25/09/2016.
 */
public class OptionSelector{


    public void optionOne(Bookshelf bookshelf){
        System.out.print("in optionOne");
        bookshelf.printBookInfoInColumns();
    }


    public void select(Integer input, Bookshelf bookshelf) {

        RunOption commandOne = new RunOption() { @Override public void run() { optionOne( bookshelf); } };

        Map<Integer, RunOption> methodMap = new HashMap<>();
        methodMap.put(1, commandOne);

        RunOption option = methodMap.get(input);
        option.run();
        System.out.print("Into main Option selector method");

    }
}

