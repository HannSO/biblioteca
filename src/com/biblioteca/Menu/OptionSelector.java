package com.biblioteca.Menu;

import com.biblioteca.Shelves.Bookshelf;
import com.biblioteca.Shelves.Shelf;
import com.biblioteca.UserInput;

import java.util.HashMap;
import java.util.Map;


public class OptionSelector{


    public void optionOne(Shelf shelf){
        UserInput userInput = new UserInput();
        userInput.showPrompt("Here are the items available in this category:");
        shelf.printCheckedInItemsInfo();
    }
    public void optionTwo(Shelf shelf) {
        UserInput userInput = new UserInput();
        userInput.showPrompt("Enter the item title you wish to return:");
        String selection = userInput.returnString();
        shelf.checkIn(selection);
    }

    public void optionThree(Shelf shelf){
        UserInput userInput = new UserInput();
        userInput.showPrompt("Enter the item you wish to checkout:");
        String selection = userInput.returnString();
        shelf.checkOut(selection);
    }

    public void select(Integer input, final Shelf shelf) {
        RunOption commandOne = new RunOption() {@Override public void run() { optionOne(shelf); }};
        RunOption commandTwo = new RunOption() {@Override public void run() { optionTwo(shelf); }};
        RunOption commandThree = new RunOption() {@Override public void run() { optionThree(shelf);}};
        Map<Integer, RunOption> methodMap = new HashMap<>();
        methodMap.put(1, commandOne);
        methodMap.put(2, commandTwo);
        methodMap.put(3, commandThree);
        try {
            RunOption option = methodMap.get(input);
            option.run();;
        } catch (NullPointerException e){
            System.out.println("Invalid menu option. Please try again.");
        }
    }


    public static class RunOption {
            void run() {}
    }
}

