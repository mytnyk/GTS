package mytnyk.gts.kernel.xml.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import mytnyk.gts.kernel.xml.IListOfObjects;
import mytnyk.gts.kernel.xml.XmlListParser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class XmlListParserTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
	@SuppressWarnings("static-method")
	@Test
	public void testXmlListParser() {
		IListOfObjects mockedList = mock(IListOfObjects.class);
		when(mockedList.getObjectTag()).thenReturn("tag"); //$NON-NLS-1$

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("prop", "value"); //$NON-NLS-1$ //$NON-NLS-2$

		String str = "<list><tag><prop>value</prop></tag></list>"; //$NON-NLS-1$
		InputStream is = new ByteArrayInputStream(str.getBytes());

		XmlListParser p = new XmlListParser();
		p.parse(is, mockedList);

		verify(mockedList).add(ht);
	}
	
	@Test
	public void canThrowException() {
		IListOfObjects mockedList = mock(IListOfObjects.class);
		when(mockedList.getObjectTag()).thenReturn("tag"); //$NON-NLS-1$
		
		String str = "some invalid xml"; //$NON-NLS-1$
		InputStream is = new ByteArrayInputStream(str.getBytes());
		XmlListParser p = new XmlListParser();
		
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Failed to parse"); //$NON-NLS-1$
		
		p.parse(is, mockedList);
	}

}
