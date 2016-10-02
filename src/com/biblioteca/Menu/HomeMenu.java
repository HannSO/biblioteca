package com.biblioteca.Menu;

import com.biblioteca.Shelves.Shelf;
import com.biblioteca.UserInput;

import java.util.ArrayList;

import static java.awt.SystemColor.menu;

/**
 * Created by hannahsmyth-osbourne on 02/10/2016.
 */
public class HomeMenu {

    private  Message message = new Message();
    private  Menu menu;
    private  OptionSelector optionSelector;
    private  UserInput userInput = new UserInput();
    private  Integer integerInput;
    private  Boolean quit;

    public HomeMenu(){
        quit = false;
    }

    public Object go (ArrayList<Shelf> shelves){
        message.printHome();
        userInput.showPrompt("Enter selection: ");
        integerInput = userInput.returnInteger();
        if (integerInput == 99) {quit();message.printGoodbye(); return null;}
        showAndExecuteMenu(shelves.get(integerInput-1));
        return null;
    }

    public Boolean  isQuit(){
        return quit;
    }

    public  void quit(){
        quit = true;
    }

    public void showAndExecuteMenu(Shelf shelf){
        optionSelector = new OptionSelector();
        userInput = new UserInput();
        menu.displayOptions();
        userInput.showPrompt("Enter selection: ");
        integerInput = userInput.returnInteger();
        while (integerInput != 99) {
            optionSelector.select(integerInput, shelf);
            menu.displayOptions();
            userInput.showPrompt("Enter selection:");
            integerInput = userInput.returnInteger();
        }
        System.out.print("\nYou are going back to the homepage.\n");
    }


    public void createSpecificItemMenu(){
        menu = new Menu();
        menu.addMenuItem(1, "Display Items");
        menu.addMenuItem(2, "CheckIn Items");
        menu.addMenuItem(3, "CheckOut Items");
        menu.addMenuItem(99, "Return Home");
    }
}
