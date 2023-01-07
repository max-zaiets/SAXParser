
public class Main {
    public static void main(String[] args) {
        String path = "D:\\IntellijProjects\\SAXParser\\src\\addresses.xml";

        DOMCreateXML.createXML(DOMCreateXML.xmlFilePath);
        XMLSAXParser.parseWithSAX(path);
    }
}
