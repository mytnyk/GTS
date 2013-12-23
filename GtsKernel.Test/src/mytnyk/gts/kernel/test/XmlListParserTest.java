package mytnyk.gts.kernel.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import mytnyk.gts.kernel.IListOfObjects;
import mytnyk.gts.kernel.xml.XmlListParser;

import org.junit.Test;

public class XmlListParserTest {

	@Test
	public void testXmlListParser() {
		IListOfObjects mockedList = mock(IListOfObjects.class);
		when(mockedList.getObjectTag()).thenReturn("tag");

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("prop", "value");

		String str = "<list><tag><prop>value</prop></tag></list>";
		InputStream is = new ByteArrayInputStream(str.getBytes());

		XmlListParser p = new XmlListParser();
		p.parse(is, mockedList);

		verify(mockedList).add(ht);
	}

}
