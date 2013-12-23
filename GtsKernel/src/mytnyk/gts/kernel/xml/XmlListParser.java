package mytnyk.gts.kernel.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mytnyk.gts.kernel.IListParser;
import mytnyk.gts.kernel.IListOfObjects;

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
			e.printStackTrace();
		}
	}
}
