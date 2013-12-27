package mytnyk.gts.kernel.xml.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Object;
import mytnyk.gts.kernel.xml.XmlObjectList;

import org.junit.Test;

public class XmlObjectListTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		XmlObjectList list = new XmlObjectList();

		assertEquals("Object", list.getObjectTag()); //$NON-NLS-1$

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("Type", "Maverick"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("Behavior", "SomeMovementStrategy"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("Terrain", "Road Tree"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("Kill", "Ant"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("Take", "Grass"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("Speed", "Very slow"); //$NON-NLS-1$ //$NON-NLS-2$

		list.add(ht);

		ArrayList<Object> l = list.getList();
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getType(), "Maverick"); //$NON-NLS-1$
		assertTrue(l.get(0).hasTerrain("Tree")); //$NON-NLS-1$
	}

}
