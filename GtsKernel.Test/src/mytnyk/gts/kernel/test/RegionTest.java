package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.Site;
import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.Object;

import org.junit.Test;

public class RegionTest {

	private final Region r;

	public RegionTest() {
		Terrain t = new Terrain("road"); //$NON-NLS-1$
		Site[][] site = new Site[][] { {new Site(t), new Site(t)}, {new Site(t), new Site(t)}, {new Site(t), new Site(t)}};
		r = new Region(site);
	}
	@SuppressWarnings("static-method")
	@Test
	public void test() {
		assertEquals(r.getWidth(), 3);
		assertEquals(r.getHeight(), 2);

		int[] xy = new int[] {0, 0};
		assertFalse(r.getPosition(xy, new Object("some fake object", "none"))); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Test
	public void testOutOfBounds() {
		assertNull(r.getSite(4, 4));
	}
}
