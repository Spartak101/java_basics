package ParseHtml;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParseLine {

    Elements element;

    public ParseLine(Document doc) {
        this.element = doc.select(".js-metro-line");
    }

    public ArrayList<String> parseNameLine(Elements element) {
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < element.size(); i++) {
            if (!element.get(i).text().equals("")) {
                name.add(element.get(i).text());
            }
        }
        return name;
    }

    public ArrayList<String> parseNumberLine(Elements element) {
        ArrayList<String> number = new ArrayList<>();
        String regex = "[^.D?[0-9][0-9]?[A].>$]";
        for (int i = 0; i < element.size(); i++) {
            String string = String.valueOf(element.get(i));
            String resultFirst = string.replaceAll(regex, "");
            String result;
            if (!(resultFirst.charAt(2) == 'A')) {
                result = resultFirst.length() == 4 ? resultFirst.substring(0, 1) : resultFirst.substring(0, 2);
            } else {
                result = resultFirst.substring(0, 3);
            }
            number.add(result);
        }
        return number;
    }

    public Elements getElement() {
        return element;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < parseNameLine(element).size(); i++) {
            result += parseNumberLine(element).get(i) + " ";
            result += parseNameLine(element).get(i) + "\n";
        }
        return result;
    }
}
