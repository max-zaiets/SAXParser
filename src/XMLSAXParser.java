import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XMLSAXParser {
    public static void parseWithSAX(String file) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean country = false;
                boolean city = false;
                boolean street = false;
                boolean building = false;
                String sizeCity = "";

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("country")) {
                        country = true;
                    }

                    if (qName.equalsIgnoreCase("city")) {
                        sizeCity = attributes.getValue("size");
                        city = true;
                    }
                    if (qName.equalsIgnoreCase("street")) {
                        street = true;
                    }
                    if (qName.equalsIgnoreCase("building")) {
                        building = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length){
                    if (country) {
                        System.out.println("country: ");
                        country = false;
                    }
                    if (city) {
                        System.out.println("city: " + new String(ch, start, length) + "\ncity attribute size: " + sizeCity);
                        city = false;
                    }
                    if (street) {
                        System.out.println("street: " + new String(ch, start, length));
                        street = false;
                    }
                    if (building) {
                        System.out.println("house: " + new String(ch, start, length));
                        building = false;
                    }
                }

            };
            saxParser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
