package mytnyk.gts.kernel.xml.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Texture;
import mytnyk.gts.kernel.xml.XmlTextureList;

import org.junit.Test;

public class XmlTextureListTest{

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		XmlTextureList list = new XmlTextureList();

		assertEquals("Texture", list.getObjectTag()); //$NON-NLS-1$

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("Name", "some name"); //$NON-NLS-1$ //$NON-NLS-2$
		ht.put("File", "some file"); //$NON-NLS-1$ //$NON-NLS-2$

		list.add(ht);

		ArrayList<Texture> l = list.getList();
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getName(), "some name"); //$NON-NLS-1$
		assertEquals(l.get(0).getFile(), "some file"); //$NON-NLS-1$
	}

}
