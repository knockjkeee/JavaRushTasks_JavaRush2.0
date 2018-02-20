package SaxApproachReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, XMLStreamException {
//        DefaultHandler handler = new DefaultHandler() {
//            @Override
//            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//                String name = attributes.getValue("id");
//                if (name != null ) {
//                    System.out.println(name);
//                }
//            }
//
//            @Override
//            public void characters(char[] ch, int start, int length) throws SAXException {
//                String str = "";
//                for (int i = 0; i < length; i++) {
//                    str += ch[start + 1];
//                }
//                System.out.println(str);
//            }
//        };
//
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        parser.parse(new File("XML\\test.xml"), handler);
//

//        XMLInputFactoryImpl factory = new XMLInputFactoryImpl();
//
//        XMLStreamReaderImpl paresr = (XMLStreamReaderImpl) factory.createXMLStreamReader(new FileInputStream("XML\\test.xml"));
//        while (paresr.hasNext()) {
//            int evetnt = paresr.next();
//            if (evetnt == XMLStreamReaderImpl.START_ELEMENT) {
//                System.out.println(paresr.getLocalName());
//            }
//        }


        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("XML\\test.xml"));

        while (reader.hasNext()) {
            int rr = reader.next();
            if (rr == XMLStreamReader.START_ELEMENT) {
                System.out.println(reader.getLocalName());
            }
        }

    }
}
