package ParseHtml;

import Items.StationForJson;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParseConnection {
    Elements element;

    public ParseConnection(Document doc) {
        this.element = doc.select("span");
    }

    public void setElement(Elements element) {
        this.element = element;
    }

    public List<String[]> splitForLine(Elements element) {
        ArrayList<String[]> result = new ArrayList<>();
        String bigString = "";
        for (int i = 0; i < element.size(); i++) {
            String it = String.valueOf(element.get(i));
            bigString += it;
        }
        String[] splitFirst = bigString.split("<span class=\"js-metro-line");
        for (String it : splitFirst) {
            String[] splitSecond = it.split("<span class=\"num\">[0-9]+\\.[&nbsp;]+</span>");
            String[] separator = separatorStringConnection(splitSecond);
            if (separator.length > 1) {
                result.add(separator);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<ArrayList<StationForJson>>> extractConnections(List<String[]> entrance) {
        ArrayList<ArrayList<ArrayList<StationForJson>>> connections = new ArrayList<>();
        for (int i = 0; i < entrance.size(); i++) {
            String numberLine = "";
            String[] strings = entrance.get(i);
            ArrayList<ArrayList<StationForJson>> connectionsForLines = new ArrayList<>();
            for (int j = 0; j < strings.length; j++) {
                ArrayList<StationForJson> connectionsForStation = new ArrayList<>();
                if (j == 0) {
                    String[] numberLineSplit = strings[j].split("\"");
                    numberLine = numberLineSplit[2].replaceAll("\"", "");
                } else {
                    String[] connectionsStrings = strings[j].split("<span class=");
                    int step = 0;
                    int countStep = 0;
                    for (int k = 1; k < connectionsStrings.length; k++) {
                        step = k;
                        if (k == 1) {
                            String text = connectionsStrings[k];
                            String nameToConnection = text.substring(text.indexOf('>') + 1, text.indexOf('<'));
                            StationForJson connectionOnLineAndStation = new StationForJson(nameToConnection, numberLine);
                            connectionsForStation.add(connectionOnLineAndStation);
                            countStep++;
                        } else {
                            String name = connectionsStrings[k];
                            String nameToConnection = name.substring(name.indexOf('«') + 1, name.indexOf('»'));
                            String[] numberSplit = connectionsStrings[k].split("\"t-icon-metroln ln-");
                            String[] numberSplitFinal = numberSplit[1].split("\"");
                            String numberLineToConnection = numberSplitFinal[0];
                            StationForJson connectionOnLineAndStation2 = new StationForJson(nameToConnection, numberLineToConnection);
                            connectionsForStation.add(connectionOnLineAndStation2);
                            countStep++;
                        }
                    }
                    if (step == countStep) {
                        connectionsForLines.add(connectionsForStation);
                    }
                }
            }
            connections.add(connectionsForLines);
        }
        return connections;
    }

    private String[] separatorStringConnection(String[] strings) {
        ArrayList<String> separator = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("")) {
                continue;
            }
            if (!strings[i].matches("^<span class=\"name\">[а-яА-я]+\\s?\\S?[а-яА-я]*[0-9]*\\s?[а-яА-я]*ё?[а-яА-я]*</span>$")) {
                separator.add(strings[i]);
            }
        }
        String[] array = separator.toArray(new String[0]);
        return array;
    }

    public Elements getElement() {
        return element;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < element.size(); i++) {
            result += element.get(i) + "\n";
        }
        return result;
    }
}
