
public class Main {

    public static void main(String[] args) throws Exception {


        EntryInJsonAsSPB entry = new EntryInJsonAsSPB();
        entry.entryData();

        EntryStationsInJson entryStationsInJson = new EntryStationsInJson();
        entryStationsInJson.entryData();
        entryStationsInJson.initialisedLines().forEach(System.out::println);

    }
}