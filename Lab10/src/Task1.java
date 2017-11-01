import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Task1 {

    private static String workingDir = System.getProperty("user.dir");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser = spf.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        Handler h = new Handler();
        reader.setContentHandler(h);
        reader.parse(workingDir + "/test.xml");
        //Report report = h.getReport();


    }

    private static class Handler extends DefaultHandler {
        static final String RECIPE_TAG = "recipe";
//        private Report report;
//
//        Report getReport() {
//
//        }
    }
}
