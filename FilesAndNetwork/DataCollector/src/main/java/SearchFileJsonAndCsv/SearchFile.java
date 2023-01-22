package SearchFileJsonAndCsv;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchFile {

    public String result = "";
    public Set<String> allFiles = new TreeSet<>();
    public ArrayList<String> requiredFiles = new ArrayList<>();
    public ArrayList<String> jsonFiles = new ArrayList<>();
    public ArrayList<String> csvFiles = new ArrayList<>();

    public File folder;

    public SearchFile(String path) {
        this.folder = new File(path);
    }

    public Set<String> allFiles(File folder) {
        try {
            Stream<Path> path = Files.walk(Paths.get(String.valueOf(folder)));
            path.filter(Files::isRegularFile).forEach(f -> {
                allFiles.add(String.valueOf(f));
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return allFiles;
    }

    public ArrayList<String> parseRequiredFiles(Set<String> set){
        Iterator<String> itr = set.iterator();
        List<String> array = new ArrayList<>();
        while (itr.hasNext()){
            array.add(itr.next());
        }
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).matches("[\\S]+[\\.json$]")){
                requiredFiles.add(array.get(i));
                jsonFiles.add(array.get(i));
            }
            if (array.get(i).matches("[\\S]+[\\.csv$]")){
                requiredFiles.add(array.get(i));
                csvFiles.add(array.get(i));
            }
        }
        return requiredFiles;
    }

    public File getFolder() {
        return folder;
    }

    public String getResult() {
        return result;
    }

    public Set<String> getAllFiles() {
        return allFiles;
    }

    public ArrayList<String> getRequiredFiles() {
        return requiredFiles;
    }

    public ArrayList<String> getJsonFiles() {
        return jsonFiles;
    }

    public ArrayList<String> getCsvFiles() {
        return csvFiles;
    }

    public String toString() {
        parseRequiredFiles(allFiles(folder)).forEach(s -> result += s + "\n");
        return result;
    }




}
