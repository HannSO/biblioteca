package com.biblioteca.Shelves;
import com.biblioteca.Items.Item;
import java.util.ArrayList;
import java.util.Objects;

public class Shelf {
    public ArrayList<Item> items = new ArrayList();
    public ArrayList<Item> checkedInItems;
    public ShelfMessagePrinter message;


    public Shelf(ShelfMessagePrinter m) {
        message = m;
    }

    public Shelf(){
        message = new ShelfMessagePrinter();
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public void checkIn(String string) {
        Item item = identifyItemFromTitle(string);
        if (item != null) {
            item.checkIn();
            message.printCheckInSuccess();
        } else {
            message.printInvalidReturn();
        }
    }

    // THIS METHOD IS WRONG BECAUSE: COPY AND PASTED FROM CHECK IN
    public void checkOut(String string){
        Item thisItem;
        thisItem = identifyItemFromTitle(string);
        if (thisItem != null) {
            thisItem.checkOut();
            message.printCheckOutSuccess();}else{
            message.printUnavailable();
        }
    }

    public void printCheckedInItemsInfo() {
        checkedInItems = listCheckedInItems();
        System.out.printf("%-30s %-30s %-30s %n","AUTHOR","TITLE","PUBLICATION DATE");
        for (int i = 0; i < checkedInItems.size(); i++) {
            System.out.printf("%-30s %-30s %-30s %n", items.get(i).getCreator(), items.get(i).getTitle(), items.get(i).getDateCirculatedString());
        }
    }

    private ArrayList<Item> listCheckedInItems(){
        checkedInItems = new ArrayList();
        for (int i = 0; i <items.size(); i++){
            if (items.get(i).isCheckedIn()){
               checkedInItems.add(items.get(i));
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

