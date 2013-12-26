package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import mytnyk.gts.kernel.Code;
import mytnyk.gts.kernel.Object;
import mytnyk.gts.kernel.ObjectFactory;
import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.Site;
import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.TerrainFactory;

import org.junit.Test;

public class RegionTest {

	@Test
	public void test() {
		Terrain tw = new Terrain("Water");
		Code w = new Code("0", "Water");
		Code wh = new Code("1", "Water");
		wh.add("Human");
		Code[][] map = new Code[][] { {w, w}, {w, w}, {w, wh} };

		TerrainFactory tf = mock(TerrainFactory.class);
		when(tf.getTerrain("Water")).thenReturn(tw);
		
		ObjectFactory of = mock(ObjectFactory.class);
		when(of.getObject("Human")).thenReturn(new Object("Human", "Manual"));

		Region region = new Region(map, tf, of);
		Site s = region.getSite(2, 1);

		assertEquals(s.getTerrain().getType(), "Water");
		assertTrue(s.hasObject("Human"));

		s = region.getSite(1, 1);
		assertFalse(s.hasObject("Human"));
	}

}
