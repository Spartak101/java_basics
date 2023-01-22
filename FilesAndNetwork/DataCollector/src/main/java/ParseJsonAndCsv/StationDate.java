package ParseJsonAndCsv;

import javax.xml.crypto.Data;

public class StationDate {
    public String name;
    public String date;

/*    public StationDate(String name, String date) {
        this.name = name;
        this.date = date;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return "station_name: " + name + "\n" +
                "date: " + date;
    }
}
