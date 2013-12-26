package mytnyk.gts.kernel.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.SAXException;

public class XmlListParser implements IListParser {

	@Override
	public void parse(InputStream is, IListOfObjects list) {

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			XmlListHandler handler = new XmlListHandler(list);
			saxParser.parse(is, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new RuntimeException("Failed to parse input stream!", e);
		}
	}
}
