package DomApproachWriter;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        Element font = document.createElement("font");
        Text text = document.createTextNode("TimesNewRoman");

        document.appendChild(root);
        root.appendChild(font);
        font.appendChild(text);
        font.setAttribute("size", "20");

//        Transformer t = TransformerFactory.newInstance().newTransformer();
//        t.setOutputProperty(OutputKeys.INDENT, "yes");
//        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("Test213.xml")));

        DOMImplementation implementation = document.getImplementation();
        DOMImplementationLS impLs = (DOMImplementationLS) implementation.getFeature("LS", "3.0");
        LSSerializer ser = impLs.createLSSerializer();
        ser.getDomConfig().setParameter("format-pretty-print", true);
        String str = ser.writeToString(document);
//        System.out.println(str);

        LSOutput out = impLs.createLSOutput();
        out.setEncoding("UTF-8");
        out.setByteStream(Files.newOutputStream(Paths.get("123.xml")));
        ser.write(document, out);

    }
}
