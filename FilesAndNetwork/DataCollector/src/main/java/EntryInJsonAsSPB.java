import Items.LineForJson;
import Items.StationForJson;
import ParseHtml.ParseHtml;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class EntryInJsonAsSPB {

    ParseHtml parseHtml;
    String path = "https://skillbox-java.github.io/";
    String writerPath = "src/main/resources/jsonAsSPB.json";

    {
        try {
            parseHtml = new ParseHtml(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void entryData() {
        JSONObject obj = new JSONObject();
        obj.put("stations", initialisedStation());
        obj.put("lines", initialisedLines());
        obj.put("connections", initialisedConnections());

        try (FileWriter file = new FileWriter(writerPath)) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONArray initialisedLines() {
        JSONArray result = new JSONArray();
        ArrayList<String> nameLine = parseHtml.getParseLine().parseNameLine(parseHtml.getParseLine().getElement());
        ArrayList<String> numberLine = parseHtml.getParseLine().parseNumberLine(parseHtml.getParseLine().getElement());
        for (int i = 0; i < nameLine.size(); i++) {
            JSONObject objLine = new JSONObject();
            objLine.put("number", numberLine.get(i));
            objLine.put("name", nameLine.get(i));
            result.add(objLine);
        }
        return result;
    }

    public JSONObject initialisedStation() {
        JSONObject stations = new JSONObject();
        ArrayList<String[]> arrayName = parseHtml.getParseStation().parseNameStation(parseHtml.getParseStation().getElement());
        ArrayList<String> arrayLine = parseHtml.getParseStation().parseNumberLine(parseHtml.getParseStation().getElement());
        for (int i = 0; i < arrayName.size(); i++) {
            JSONArray list = new JSONArray();
            list.addAll(List.of(arrayName.get(i)));
            stations.put(arrayLine.get(i), list);
        }
        return stations;
    }

    public JSONArray initialisedConnections() {
        JSONArray result = new JSONArray();
        ArrayList<ArrayList<ArrayList<StationForJson>>> connections =
                parseHtml.getParseConnection().extractConnections
                        (parseHtml.getParseConnection().splitForLine
                                (parseHtml.getParseConnection().getElement()));
        for (int i = 0; i < connections.size(); i++) {
            ArrayList<ArrayList<StationForJson>> connectionsByLines = connections.get(i);
            for (int j = 0; j < connectionsByLines.size(); j++) {
                ArrayList<StationForJson> stationConnections = connectionsByLines.get(j);
                JSONArray lines = new JSONArray();
                for (int k = 0; k < stationConnections.size(); k++) {
                    JSONObject connectionGroup = new JSONObject();
                    connectionGroup.put("line", stationConnections.get(k).getLine());
                    connectionGroup.put("station", stationConnections.get(k).getName());
                    lines.add(connectionGroup);
                }
                result.add(lines);
            }
        }
        return result;
    }

}
