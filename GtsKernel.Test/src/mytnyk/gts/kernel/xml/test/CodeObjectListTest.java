package mytnyk.gts.kernel.xml.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Code;
import mytnyk.gts.kernel.xml.XmlCodeList;

import org.junit.Test;

public class CodeObjectListTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		XmlCodeList list = new XmlCodeList();

		assertEquals("Code", list.getObjectTag()); //$NON-NLS-1$

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("Value", "1"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("Terrain", "Road"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("Object", "Key"); //$NON-NLS-1$ //$NON-NLS-2$

		list.add(ht);

		ArrayList<Code> l = list.getList();
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getValue(), "1"); //$NON-NLS-1$
		assertEquals(l.get(0).getTerrain(), "Road"); //$NON-NLS-1$
	}

}
