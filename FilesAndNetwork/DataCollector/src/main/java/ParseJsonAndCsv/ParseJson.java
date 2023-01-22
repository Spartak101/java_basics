package ParseJsonAndCsv;

import SearchFileJsonAndCsv.SearchFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParseJson {

    private final List<StationDepth> depthsStation;


    public ParseJson() {
        this.depthsStation = new ArrayList<>();

    }

    public List<StationDepth> getDepthsStation() {
        return depthsStation;
    }

    public void parseJsonFile() throws InterruptedException {
        SearchFile searchFile = new SearchFile("data");
        searchFile.parseRequiredFiles(searchFile.allFiles(searchFile.getFolder()));
        ArrayList<String> path = searchFile.getJsonFiles();
        for (int i = 0; i < path.size(); i++) {
            parseJsonData(path.get(i));
        }
        Collections.sort(depthsStation, new Comparator<StationDepth>() {
            @Override
            public int compare(StationDepth o1, StationDepth o2) {
                return o1.getStationName().compareTo(o2.getStationName());
            }
        });
    }

    public void parseJsonData(String path) throws InterruptedException {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            JSONArray stationList = (JSONArray) obj;
            for (Object it : stationList) {
                JSONObject stationJsonObject = (JSONObject) it;
                String station_name = (String) stationJsonObject.get("station_name");
                String depth = (String) stationJsonObject.get("depth");
                String depthRegex = normaliseDepth(depth);
                StationDepth stationDepth = new StationDepth(station_name, depthRegex);
                addStation(stationDepth);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String normaliseDepth(String depth){
        if (depth.equals("?")) {
            depth = "-100";
        }
        String depthRegex = depth.replaceAll("[\\,]", ".");
        if (Double.valueOf(depthRegex) > 0) {
            depthRegex = "-" + depthRegex;
        }
        return depthRegex;
    }

    public boolean equals(StationDepth o1, StationDepth o2) {
        if (!o1.getStationName().equals(o2.getStationName())) {
            return false;
        } else if (!o1.getDepth().equals(o2.getDepth())) {
            return false;
        }
        return true;
    }

    public StationDepth equalsDepth(StationDepth o1, StationDepth o2) {
        if (Double.valueOf(o1.getDepth()) >= Double.valueOf(o2.getDepth())) {
            return o2;
        }
        return o1;
    }

    private void addStation(StationDepth stationDepth) {
        if (depthsStation.isEmpty()) {
            depthsStation.add(stationDepth);
        }
        int trueCount = 0;
        for (int i = 0; i < depthsStation.size(); i++) {
            StationDepth stationGet = depthsStation.get(i);
            if (stationDepth.getStationName().equals(stationGet.getStationName())) {
                StationDepth station = equalsDepth(stationDepth, stationGet);
                depthsStation.set(i, station);
            } else if (!equals(stationDepth, stationGet)) {
                trueCount++;
            }
        }
        if (!(trueCount == depthsStation.size() - 1)) {
            depthsStation.add(stationDepth);
        }
    }
}
