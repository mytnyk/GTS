package mytnyk.gts.kernel.xml.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Code;
import mytnyk.gts.kernel.xml.XmlCodeList;

import org.junit.Test;

public class CodeObjectListTest {

	@Test
	public void test() {
		XmlCodeList list = new XmlCodeList();

		assertEquals("Code", list.getObjectTag());

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Value", "1");
		ht.put("Terrain", "Road");
		ht.put("Object", "Key");

		list.add(ht);

		ArrayList<Code> l = list.getList();
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getValue(), "1");
		assertEquals(l.get(0).getTerrain(), "Road");
	}

}
