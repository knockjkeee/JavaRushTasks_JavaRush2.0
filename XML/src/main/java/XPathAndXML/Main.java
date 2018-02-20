package XPathAndXML;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("D:\\JavaRushHomeWork\\project\\JavaRushTasks\\JavaRushTasks\\XML\\test.xml"));

        XPathFactory xpf = XPathFactory.newInstance();
        XPath pt = xpf.newXPath();

        System.out.println(pt.evaluate("/catalog/book/author", document));

        NodeList list = (NodeList) pt.evaluate("/catalog/book", document, XPathConstants.NODESET);

        System.out.println(list.item(2));
        System.out.println();

    }


}
