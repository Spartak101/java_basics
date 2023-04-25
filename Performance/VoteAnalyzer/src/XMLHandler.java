import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private int countIteration = 0;
    private  int countWriter = 0;
/*    private HashMap<Voter, Integer> voterCounts;

    public XMLHandler(){
        voterCounts = new HashMap<>();
    }*/

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter") && voter == null) {
                String birthDay = attributes.getValue("birthDay");
                DBConnection.countVoter(attributes.getValue("name"), String.valueOf(birthDay));
                countIteration++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (countIteration == 100000){
            try {
                DBConnection.executeMultiInsert();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            countIteration = 0;
            countWriter++;
            System.out.println(countWriter);
            /*voter = null;*/
        }
    }

 /*   public void printDuplicatedVoters(){
        for (Voter voter : voterCounts.keySet()){
            int count = voterCounts.get(voter);
            if (count > 1){
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }*/
}
