package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public class XMLBookMetadataExporter extends BookMetadataExporter{
    XMLBookMetadataFormatter booksCollection = new XMLBookMetadataFormatter();

    public XMLBookMetadataExporter() throws IOException, ParserConfigurationException {
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
