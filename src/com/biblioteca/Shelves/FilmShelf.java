package com.biblioteca.Shelves;

public class FilmShelf extends Shelf{

    public FilmShelf(ShelfMessagePrinter m) {
        super(m);
    }

    public FilmShelf() {
    }

    @Override
    public void printCheckedInItemsInfo() {
        checkedInItems = listCheckedInItems();
        System.out.printf("%-30s %-30s %-30s %n", "DIRECTOR", "TITLE", "RELEASE DATE");
        for (int i = 0; i < checkedInItems.size(); i++) {
            System.out.printf("%-30s %-30s %-30s %n", items.get(i).getCreator(), items.get(i).getTitle(), items.get(i).getDateCirculatedString());
        }
    }
}
