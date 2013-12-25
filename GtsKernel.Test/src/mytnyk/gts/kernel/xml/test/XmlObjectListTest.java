package mytnyk.gts.kernel.xml.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Object;
import mytnyk.gts.kernel.xml.XmlObjectList;

import org.junit.Test;

public class XmlObjectListTest {

	@Test
	public void test() {
		XmlObjectList list = new XmlObjectList();

		assertEquals("Object", list.getObjectTag());

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Type", "Maverick");
		ht.put("Behavior", "SomeMovementStrategy");
		ht.put("Terrain", "Road Tree");
		ht.put("Kill", "Ant");
		ht.put("Take", "Grass");
		ht.put("Speed", "Very slow");

		list.add(ht);

		ArrayList<Object> l = list.getList();
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getType(), "Maverick");
		assertTrue(l.get(0).hasTerrain("Tree"));
	}

}
