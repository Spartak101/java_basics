package Items;

public class Connections {

    public int line;
    public String station;

    public Connections(int line, String station) {
        this.line = line;
        this.station = station;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
