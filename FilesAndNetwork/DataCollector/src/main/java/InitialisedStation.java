import Items.StationForJson;
import ParseHtml.ParseConnection;
import ParseHtml.ParseStation;
import ParseJsonAndCsv.ParseCsv;
import ParseJsonAndCsv.ParseJson;
import ParseJsonAndCsv.StationDate;
import ParseJsonAndCsv.StationDepth;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitialisedStation {

    ParseJson parseJson = new ParseJson();
    ParseCsv parseCsv = new ParseCsv();
    ParseStation parseStation = new ParseStation(Jsoup.connect("https://skillbox-java.github.io/").get());
    ParseConnection parseConnection = new ParseConnection(Jsoup.connect("https://skillbox-java.github.io/").get());
    public ArrayList<String[]> parseNameStation = parseStation.parseNameStation(parseStation.getElement());
    public ArrayList<String> parseNumberLine = parseStation.parseNumberLine(parseStation.getElement());
    public ArrayList<ArrayList<ArrayList<StationForJson>>> allConnection = parseConnection.extractConnections(parseConnection.splitForLine(parseConnection.getElement()));

    public InitialisedStation() throws IOException {
    }

    public ArrayList<StationForJson> allStations() {
        ArrayList<StationForJson> stations = new ArrayList<>();
        for (int i = 0; i < parseNumberLine.size(); i++) {
            String numberLine = parseNumberLine.get(i);
            String[] stationsOfLine = parseNameStation.get(i);
            for (int j = 0; j < stationsOfLine.length; j++) {
                StationForJson station = new StationForJson(stationsOfLine[j], numberLine);
                stations.add(station);
            }
        }
        return stations;
    }

    public ArrayList<StationForJson> fullStations() throws InterruptedException {
        ArrayList<StationForJson> stationsAll = allStations();
        parseJson.parseJsonFile();
        for (int i = 0; i < stationsAll.size(); i++) {
            StationForJson st = stationsAll.get(i);
            List<StationDepth> stationDepthList = parseJson.getDepthsStation();
            for (int j = 0; j < stationDepthList.size(); j++) {
                if ((stationDepthList.get(j)).getStationName().equals(st.getName())){
                    st.setDepth(Double.parseDouble(stationDepthList.get(j).getDepth()));
                    stationDepthList.remove(j);
                }
            }
            parseCsv.parseCsvFile();
            List<StationDate> dateStation = parseCsv.getDateStation();
            for (int k = 0; k < dateStation.size(); k++) {
                if ((dateStation.get(k).getName().equals(st.getName()))){
                    st.setDate(dateStation.get(k).getDate());
                    dateStation.remove(k);
                }
            }

            ArrayList<ArrayList<ArrayList<StationForJson>>> allConnection = parseConnection.extractConnections(parseConnection.splitForLine(parseConnection.getElement()));
            for (int s = 0; s < allConnection.size(); s++) {
                for (int f = 0; f < allConnection.get(s).size(); f++) {
                    for (int d = 0; d < allConnection.get(s).get(f).size(); d++) {
                        StationForJson stationForJson = allConnection.get(s).get(f).get(d);
                        if (stationForJson.getName().equals(st.getName()) && stationForJson.getLine().equals(st.getLine())){
                            st.setHasConnection(true);
                        }
                    }
                }
            }
        }
        return stationsAll;
    }
}
