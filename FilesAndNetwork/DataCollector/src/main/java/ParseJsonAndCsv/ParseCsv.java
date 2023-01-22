package ParseJsonAndCsv;

import SearchFileJsonAndCsv.SearchFile;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.ArrayList;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParseCsv {

    private final List<StationDate> dateStation;


    public ParseCsv() {
        this.dateStation = new ArrayList<>();

    }

    public List<StationDate> getDateStation() {
        return dateStation;
    }

    public void parseCsvFile() throws InterruptedException {
        SearchFile searchFile = new SearchFile("data");
        searchFile.parseRequiredFiles(searchFile.allFiles(searchFile.getFolder()));
        ArrayList<String> path = searchFile.getCsvFiles();
        for (int i = 0; i < path.size(); i++) {
            parseCsvData(path.get(i));
        }
    }

    public void parseCsvData(String path) throws InterruptedException {
        try {
            ICsvBeanReader csvBeanReader = new CsvBeanReader(new FileReader(path), CsvPreference.STANDARD_PREFERENCE);

            String[] mapping = csvBeanReader.getHeader(true);

            CellProcessor[] procs = getProcessors();
            StationDate stationDate;
            while ((stationDate = csvBeanReader.read(StationDate.class, mapping, procs)) != null) {
                addStation(stationDate);
            }
            csvBeanReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Collections.sort(dateStation, new Comparator<StationDate>() {
            @Override
            public int compare(StationDate o1, StationDate o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    protected CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(), // name не должно быть null
                new NotNull() // date также не должно быть null
        };
    }

    public boolean equals(StationDate o1, StationDate o2) {
        if (!o1.getName().equals(o2.getName())) {
            return false;
        } else if (!o1.getDate().equals(o2.getDate())) {
            return false;
        }
        return true;
    }

    private void addStation(StationDate stationDate) {
        if (dateStation.isEmpty()) {
            dateStation.add(stationDate);
        }
        int trueCount = 0;
        for (int i = 0; i < dateStation.size(); i++) {
            StationDate stationGet = dateStation.get(i);
            if (!equals(stationDate, stationGet)) {
                trueCount++;
            }
        }
        if (!(trueCount == dateStation.size() - 1)) {
            dateStation.add(stationDate);
        }
    }
}
