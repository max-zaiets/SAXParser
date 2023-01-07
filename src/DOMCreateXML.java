import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMCreateXML {

    public static final String xmlFilePath = "D:\\IntellijProjects\\SAXParser\\src\\addresses.xml";

    public static void createXML(String xmlFilePath){

        try {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element root = doc.createElement("addresses");
        doc.appendChild(root);

        Element city = doc.createElement("city");
        city.setAttribute("size", "big");
        city.appendChild(doc.createTextNode("Kyiv"));
        root.appendChild(city);


        Element street = doc.createElement("street");
        street.appendChild(doc.createTextNode("Novoaleksandrivska"));
        city.appendChild(street);


        Element buildingNum = doc.createElement("building");
        buildingNum.appendChild(doc.createTextNode("12"));
        city.appendChild(buildingNum);


        Element city2 = doc.createElement("city");
        city2.setAttribute("size", "big");
        city2.appendChild(doc.createTextNode("Dnipro"));
        root.appendChild(city2);


        Element street2 = doc.createElement("street");
        street2.appendChild(doc.createTextNode("Mayska"));
        city2.appendChild(street2);

        Element buildingNum2 = doc.createElement("building");
        buildingNum2.appendChild(doc.createTextNode("28"));
        city2.appendChild(buildingNum2);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));

        transformer.transform(domSource, streamResult);

        System.out.println("XML file created");

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
