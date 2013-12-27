package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Site;
import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.Object;

import org.junit.Test;

public class SiteTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		Site s = new Site(new Terrain("highway")); //$NON-NLS-1$
		s.addObject(new Object("key", "static")); //$NON-NLS-1$ //$NON-NLS-2$

		assertTrue(s.hasObject("key")); //$NON-NLS-1$
		assertFalse(s.hasObject("door")); //$NON-NLS-1$
		assertEquals(s.getObjects().next().getType(), "key"); //$NON-NLS-1$
		assertEquals(s.getTerrain().getType(), "highway"); //$NON-NLS-1$
		assertEquals(s.toString(), "highway [key]"); //$NON-NLS-1$
	}

}
