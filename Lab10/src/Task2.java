import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Task2 {
    private static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("files/test.xml"));
        Element element = document.getDocumentElement();
        System.out.println(element.getTagName());
        printElements(element.getChildNodes(), 0);
    }
    private static void printElements(NodeList list, int tabs) {
        for (int i = 0 ; i < list.getLength(); i ++) {
            if (list.item(i) instanceof  Element) {
                System.out.println(((Element) list.item(i)).getTagName());
                String value = "";
                if (list.item(i).getTextContent().trim().isEmpty() && !((Text) list.item(i).getFirstChild()).getData().trim().isEmpty() && !((Text) list.item(i).getFirstChild()).getData().trim().equals("\n") ) {
                    Text text = (Text) list.item(i).getFirstChild();
                    value += " = " + text.getData().trim();
                }
                System.out.println(getTab(tabs) + list.item(i).getNodeName() + value);
                if ((((Element) list.item(i)).hasAttribute("name"))) {
                    System.out.println(((Element) list.item(i)).getAttribute("name"));
                }
                if ((((Element) list.item(i)).hasChildNodes())) {
                    printElements(list.item(1).getChildNodes(), ++tabs);
                }
            }

        }
    }
    static String getTab(int tabs) {
        String str = "";
        for (int i = 0 ; i < tabs; i ++) {
            str += "\t";
        }
        return str;
    }
}
