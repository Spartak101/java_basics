import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ParseHtml extends RecursiveTask<ArrayList<String>> {
    String htmlFile;
    HashSet<String> allLink;
    Elements element;
    ArrayList<String> absUrl;

    public ParseHtml(String pathHtml, HashSet<String> allLink) throws IOException {
        this.htmlFile = pathHtml;
        this.allLink = allLink;
        Document doc = Jsoup.connect(htmlFile).get();
        this.element = doc.select("a");
        absUrl = (ArrayList<String>) element.stream().map(element1 -> element1.absUrl("href")).collect(Collectors.toList());
    }

    @Override
    protected ArrayList<String> compute() {
        HashSet<String> name = allLink;
        HashSet<String> backName = allLink;
        ArrayList<String> name2 = new ArrayList<>();
        ArrayList<ParseHtml> tasks = new ArrayList<>();
        try {
            for (int i = 0; i < absUrl.size(); i++) {
                if (absUrl.get(i).matches(PathParent.getPathParent() + "([\\/[a-z0-9-]+]+\\/?\"?)")) {
                    if (!name.contains(absUrl.get(i))) {
                        name.add(absUrl.get(i));
                        Thread.sleep(150);
                        System.out.println("2 " + absUrl.get(i));
                        ParseHtml html = null;
                        try {
                            html = new ParseHtml(absUrl.get(i), allLink);
                            html.fork();
                            tasks.add(html);
                        } catch (HttpStatusException h) {
                            h.printStackTrace();
                            name.remove(absUrl.get(i));
                            backName.add(absUrl.get(i));
                            System.out.println(absUrl.get(i) + " - не существует!");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
           for (ParseHtml url : tasks){
               name.addAll(url.join());
           }
    } catch(
    Exception ex)

    {
        ex.printStackTrace();
    }
        for (String s : name){
            name2.add(s);
        }
        return name2;
}

    public Elements getElement() {
        return element;
    }
}