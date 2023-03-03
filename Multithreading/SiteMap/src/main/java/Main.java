import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String path = "https://skillbox.ru";
        PathParent pathParent = new PathParent(path);
        AllLink allLink = new AllLink();
        ParseHtml parseHtml = new ParseHtml(pathParent.getPathParent(), allLink.getLink());
        ArrayList<String> url = new ForkJoinPool().invoke(parseHtml);
        WriterFile writerFile = new WriterFile(url);
        System.out.println(url.size());

        Toolkit.getDefaultToolkit().beep();

        /*parseHtml.getElement().stream().map(element -> element.absUrl("href")).forEach(System.out::println);*/
    }

}