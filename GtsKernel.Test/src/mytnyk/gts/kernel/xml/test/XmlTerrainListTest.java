package mytnyk.gts.kernel.xml.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.xml.XmlTerrainList;

import org.junit.Test;

public class XmlTerrainListTest {

	@Test
	public void test() {
		XmlTerrainList list = new XmlTerrainList();

		assertEquals("Terrain", list.getObjectTag());

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Name", "highway");

		list.add(ht);

		ArrayList<Terrain> l = list.getList();
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getType(), "highway");
	}

}
