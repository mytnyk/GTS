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

	@SuppressWarnings("static-method")
	@Test
	public void testXmlListHandler() throws Throwable {

		IListOfObjects mockedList = mock(IListOfObjects.class);
		when(mockedList.getObjectTag()).thenReturn("sometag"); //$NON-NLS-1$

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("SomeProp", "SomeValue"); //$NON-NLS-1$ //$NON-NLS-2$

		String str = "<list><sometag><SomeProp>SomeValue</SomeProp></sometag></list>"; //$NON-NLS-1$
		InputStream is = new ByteArrayInputStream(str.getBytes());

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XmlListHandler handler = new XmlListHandler(mockedList);
		saxParser.parse(is, handler);

		verify(mockedList).add(ht);
	}

}
