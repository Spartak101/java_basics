package Items;

import java.util.ArrayList;

public class StationsForJson {

    public String numberLine;
    public ArrayList<String> stations;

    public StationsForJson(String numberLine, ArrayList<String> stations) {
        this.numberLine = numberLine;
        this.stations = stations;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    public ArrayList<String> getStations() {
        return stations;
    }

    public void setStations(ArrayList<String> stations) {
        this.stations = stations;
    }
}
