import Items.StationForJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class EntryStationsInJson {

    public String writerPath = "src/main/resources/Stations.json";

    public void entryData() throws IOException, InterruptedException {
        JSONObject obj = new JSONObject();
        obj.put("stations", initialisedLines());


        try (FileWriter file = new FileWriter(writerPath)) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONArray initialisedLines() throws IOException, InterruptedException {
        JSONArray result = new JSONArray();
        InitialisedStation ini = new InitialisedStation();
        ArrayList<StationForJson> stations = ini.fullStations();
        for (int i = 0; i < stations.size(); i++) {
            JSONObject objStation = new JSONObject();
            objStation.put("name", stations.get(i).getName());
           objStation.put("line", stations.get(i).getLine());
           if (!stations.get(i).getDate().equals(""))
           objStation.put("date", stations.get(i).getDate());
           if (!Objects.equals(stations.get(i).getDepth(), -100.0)){
               objStation.put("depth", stations.get(i).getDepth());
           }
           if (stations.get(i).isHasConnection()){
               objStation.put("hasConnection", stations.get(i).isHasConnection());
           }
            result.add(objStation);
        }
        return result;
    }
}
