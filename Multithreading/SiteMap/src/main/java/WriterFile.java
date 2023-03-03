import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class WriterFile {


    public WriterFile(ArrayList<String> name) {
        Collections.sort(name);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/sitemap.txt"));
            for (String s : name) {
                String filter = s.replaceAll(PathParent.getPathParent(), "");
                String[] countsNames = filter.split("\\/");
                String tabulations = "";
                for (int i = 0; i < countsNames.length; i++) {
                    tabulations += "\t";
                }
                String result = tabulations + s + "\n";
                writer.write(result);
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
