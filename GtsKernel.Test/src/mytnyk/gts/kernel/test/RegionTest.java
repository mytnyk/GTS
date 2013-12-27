package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.Site;

import org.junit.Test;

public class RegionTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		Site[][] site = new Site[][] { {null, null}, {null, null}, {null, null}};
		Region r = new Region(site);
		assertEquals(r.getWidth(), 3);
		assertEquals(r.getHeight(), 2);
	}

}
