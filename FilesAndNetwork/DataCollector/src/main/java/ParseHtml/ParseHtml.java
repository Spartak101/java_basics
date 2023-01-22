package ParseHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ParseHtml {
    String htmlFile;
    ParseLine parseLine;
    ParseStation parseStation;
    ParseConnection parseConnection;
    public ParseHtml(String pathHtml) throws IOException {
        this.htmlFile = pathHtml;
        this.parseLine = new ParseLine(initialiseDoc());
        this.parseStation = new ParseStation(initialiseDoc());
        this.parseConnection = new ParseConnection(initialiseDoc());
    }

    public Document initialiseDoc() throws IOException {
        Document doc = Jsoup.connect(htmlFile).get();
        return doc;
    }

    public ParseLine getParseLine() {
        return parseLine;
    }

    public ParseStation getParseStation() {
        return parseStation;
    }

    public ParseConnection getParseConnection() {
        return parseConnection;
    }


    public String toString(){
        return parseLine.toString() + "\n" +
                parseStation.toString() + "\n" +
                parseConnection.toString();
    }

}
