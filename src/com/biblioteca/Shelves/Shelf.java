package com.biblioteca.Shelves;

import com.biblioteca.Items.Book;
import com.biblioteca.Items.Item;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Robin on 29/09/2016.
 */
public class Shelf {
    public ArrayList<Item> items = new ArrayList();
    public ArrayList<Item> checkedInItems = new ArrayList();
    public ShelfMessagePrinter message;

    public Shelf(){
        message = new ShelfMessagePrinter();
    }

    public void addBooks(Item item) {items.add(item);}

    public void updateCheckedInItems(){
        for (int i = 0; i items.size(); i++){
            if (items.get(i).isCheckedIn()){
                checkedInItems.add(items.get(i));
            }
        }
    }

    public void addItem(Item item) {items.add(item);}

    public void checkIn(String string){
        Item item = identifyItemFromTitle(string);
        if (item != null){item.checkIn(); message.printCheckinSuccess(); }
        message.printInvalidReturn();
    }

    public void checkOut(String string){
        Item item = identifyItemFromTitle(string);
        if (item != null){item.checkIn(); message.printCheckinSuccess(); }
        message.printUnavailable();
    }


    public void printCheckedInItemInfo() {
        checkedInItems = listCheckedInItems();
        System.out.printf("%-30s %-30s %-30s %n","AUTHOR","TITLE","PUBLICATION DATE");
        for (int i = 0; i < checkedInItems.size(); i++) {
            System.out.printf("%-30s %-30s %-30s %n", items.get(i).getCreator(), items.get(i).getTitle(), items.get(i).getDatePublishedString());
        }
    }


    private ArrayList<Item> listCheckedInItems(){
        checkedInItems = new ArrayList();
        for (int i = 0; i <items.size(); i++){
            if (items.get(i).isCheckedIn()){
               items.add(items.get(i));
            }
        }
        return checkedInItems;
    }

    private Item identifyItemFromTitle(String bookTitle) {
        Boolean found = false;
        Integer foundIndex = 0;
        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(items.get(i).getTitle(),bookTitle)) {
                found = true;
                foundIndex = i;
            }
        }
        if (found) {
            return items.get(foundIndex);
        }   else {
            return null;
        }
    }

}

