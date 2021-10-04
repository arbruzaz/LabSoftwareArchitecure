package com.solid.book;

import java.util.List;

public class PrintToScreen extends Book implements InterfaceReader{
    public PrintToScreen(String title, List<String> pages) {
        super(title, pages);
        //TODO Auto-generated constructor stub
    }

    public static void printToScreen(Book book) {
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }
}
