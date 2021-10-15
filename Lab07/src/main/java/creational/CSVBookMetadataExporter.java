package creational;

import java.io.IOException;
import java.io.PrintStream;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    CSVBookMetadataFormatter booksCollection = new CSVBookMetadataFormatter();

    public CSVBookMetadataExporter() throws IOException {
        booksCollection.reset();
    }

    @Override
    public void export(PrintStream stream) {
        // Please implement this method. You may create additional methods as you see fit.
        stream.println(booksCollection.getMetadataString());
    }

    @Override
    public void add(Book b){
        booksCollection.append(b);
    }
}
