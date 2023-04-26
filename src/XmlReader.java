import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;

public class XmlReader {


    public XmlReader() throws ParserConfigurationException, IOException, SAXException {

        File inputFile = new File("input.txt");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("book");
        System.out.println("----------------------------");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if ( nNode.getNodeName().equals("book")) {


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element bookElement = (Element) nNode;
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    String year = bookElement.getElementsByTagName("publish_date").item(0).getTextContent();
                    String price = bookElement.getElementsByTagName("price").item(0).getTextContent();
                    String description = bookElement.getElementsByTagName("description").item(0).getTextContent();
                    String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();

                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Genre: " + genre);
                    System.out.println("Publish Date: " + year);
                    System.out.println("Price: " + price);
                    System.out.println("Description: " + description);

                }
            }
        }
    }
}
