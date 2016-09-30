package com.biblioteca;

import com.biblioteca.Shelves.Bookshelf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 25/09/2016.
 */
public class OptionSelector{


    public void optionOne(Bookshelf bookshelf){
        System.out.print("\nHere are the books available: \n");
        bookshelf.printCheckedInItemsInfo();
    }
    public void optionTwo(Bookshelf bookshelf) {
        UserInput userInput = new UserInput();
        userInput.showPrompt("\nEnter the book you wish to return:");
        String selection = userInput.returnString();
        bookshelf.checkIn(selection);
    }

    public void optionThree(Bookshelf bookshelf){
        UserInput userInput = new UserInput();
        userInput.showPrompt("\nEnter the book you wish to checkout:");
        String selection = userInput.returnString();
        bookshelf.checkOut(selection);
    }

    public void select(Integer input, Bookshelf bookshelf) {
        RunOption commandOne = new RunOption() {@Override public void run() { optionOne(bookshelf); }};
        RunOption commandTwo = new RunOption() {@Override public void run() { optionTwo(bookshelf); }};
        RunOption commandThree = new RunOption() {@Override public void run() { optionThree(bookshelf);}};
        Map<Integer, RunOption> methodMap = new HashMap<>();
        methodMap.put(1, commandOne);
        methodMap.put(2, commandTwo);
        methodMap.put(3, commandThree);
        try {
            RunOption option = methodMap.get(input);
            option.run();;
        } catch (NullPointerException e){
            System.out.print("Invalid menu option. Please try again.\n");
        }
    }

    /**
     * Created by Robin on 25/09/2016.
     */
    public static class RunOption {

            void run() {}
    }
}

