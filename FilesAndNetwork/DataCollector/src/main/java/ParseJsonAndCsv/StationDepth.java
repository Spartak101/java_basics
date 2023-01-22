package ParseJsonAndCsv;

public class StationDepth {

    public String stationName;
    public String depth;

    public StationDepth(String station_name, String depth) {
        this.stationName = station_name;
        this.depth = depth;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String toString(){
        return "station_name: " + stationName + "\n" +
                "depth: " + depth;
    }
}
