package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Terrain;

import org.junit.Test;

public class TerrainTest {

	@SuppressWarnings("static-method")
	@Test
	public void testTerrain() {
		String str = "some type"; //$NON-NLS-1$
		Terrain ter = new Terrain(str);
		assertEquals(str, ter.getType());
	}


}
