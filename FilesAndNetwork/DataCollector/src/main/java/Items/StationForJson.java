package Items;

public class StationForJson {

    public String name;
    public String line;
    public String date = "";
    public double depth = -100.0;
    public boolean hasConnection = false;

    public StationForJson(String name, String line) {
        this.name = name;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    public String toString() {
        String result = "name: " + name + "\n" +
                "line: " + line + "\n" +
                "date: " + date + "\n" +
                "depth: " + depth + "\n" +
                "hasConnection: " + hasConnection;
        return result;
    }
}

