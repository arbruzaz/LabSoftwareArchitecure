package creational;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private JSONObject bookCollection;
    private JSONArray book;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        bookCollection = new JSONObject();
        book = new JSONArray();
        bookCollection.put("Books", book);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject newBook = new JSONObject();
        JSONArray authors = new JSONArray();
        for (int i = 0; i < b.getAuthors().length; i++){
            authors.add(b.getAuthors()[i]);
        }
        newBook.put("ISBN", b.getISBN());
        newBook.put("Authors", authors);
        newBook.put("Title", b.getTitle());
        newBook.put("Publisher", b.getPublisher());

        book.add(newBook);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return bookCollection.toJSONString();
    }
}
