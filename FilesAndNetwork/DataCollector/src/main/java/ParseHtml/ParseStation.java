package ParseHtml;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;

public class ParseStation {

    Elements element;

    public ParseStation(Document doc) {
        this.element = doc.select(".js-depend");
    }

    public ArrayList<String[]> parseNameStation(Elements element) {
        ArrayList<String[]> name = new ArrayList<>();
        for (int i = 0; i < element.size(); i++) {
            String firstString = element.get(i).text();
            String[] split =firstString.split("[0-9]+\\.");
            ArrayList<String> reSplit = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                if (!split[j].equals("")){
                    reSplit.add(split[j].trim());
                }
            }
            String[] result = reSplit.toArray(new String[0]);
            name.add(result);
        }
        return name;
    }

    public ArrayList<String> parseNumberLine(Elements element) {
        ArrayList<String> number = new ArrayList<>();
        String regex = "[^.D?[0-9][0-9]?[A].>$]";
        for (int i = 0; i < element.size(); i++) {
            String string = String.valueOf(element.get(i));
            String resultFirst= string.replaceAll(regex, "");
            String result;
            if (!(resultFirst.charAt(2) == 'A')) {
                result = Character.isDigit(resultFirst.charAt(2)) ? resultFirst.substring(0, 1) : resultFirst.substring(0, 2);
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
    public String toString(){
        String result = "";
        for (int i = 0; i < parseNameStation(element).size(); i++) {
            String numberLine = parseNumberLine(element).get(i);
            String[] array = parseNameStation(element).get(i);
            for (int j = 0; j < array.length; j++) {
                if (!array[j].equals("")){
                    result += "\n" + "\t" + array[j];
                } else {
                    result += "\n" + numberLine;
                }
            }
        }
        return result;
    }
}
