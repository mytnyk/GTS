package mytnyk.gts.kernel.xml.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mytnyk.gts.kernel.xml.IListOfObjects;
import mytnyk.gts.kernel.xml.XmlListHandler;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class XmlListHandlerTest {

	@Test
	public void testXmlListHandler() throws Throwable {

		IListOfObjects mockedList = mock(IListOfObjects.class);
		when(mockedList.getObjectTag()).thenReturn("sometag");

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("SomeProp", "SomeValue");

		String str = "<list><sometag><SomeProp>SomeValue</SomeProp></sometag></list>";
		InputStream is = new ByteArrayInputStream(str.getBytes());

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XmlListHandler handler = new XmlListHandler(mockedList);
		saxParser.parse(is, handler);

		verify(mockedList).add(ht);
	}

}
