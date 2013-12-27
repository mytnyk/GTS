package mytnyk.gts.kernel.xml.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.xml.XmlTerrainList;

import org.junit.Test;

public class XmlTerrainListTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		XmlTerrainList list = new XmlTerrainList();

		assertEquals("Terrain", list.getObjectTag()); //$NON-NLS-1$

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("Type", "highway"); //$NON-NLS-1$ //$NON-NLS-2$

		list.add(ht);

		ArrayList<Terrain> l = list.getList();
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getType(), "highway"); //$NON-NLS-1$
	}

}
