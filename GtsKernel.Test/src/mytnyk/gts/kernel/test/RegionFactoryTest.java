package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import mytnyk.gts.kernel.Code;
import mytnyk.gts.kernel.MapFactory;
import mytnyk.gts.kernel.Object;
import mytnyk.gts.kernel.ObjectFactory;
import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.RegionFactory;
import mytnyk.gts.kernel.Site;
import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.TerrainFactory;

import org.junit.Test;

public class RegionFactoryTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		Terrain tw = new Terrain("Water"); //$NON-NLS-1$
		Code w = new Code("0", "Water"); //$NON-NLS-1$ //$NON-NLS-2$
		Code wh = new Code("1", "Water"); //$NON-NLS-1$ //$NON-NLS-2$
		wh.add("Human"); //$NON-NLS-1$
		Code[][] map = new Code[][] { {w, w}, {w, w}, {w, wh} };

		TerrainFactory tf = mock(TerrainFactory.class);
		when(tf.getTerrain("Water")).thenReturn(tw); //$NON-NLS-1$
		
		ObjectFactory of = mock(ObjectFactory.class);
		when(of.createObject("Human")).thenReturn(new Object("Human", "Manual")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		MapFactory mf = mock(MapFactory.class);
		when(mf.getMap(null)).thenReturn(map);

		RegionFactory rf = new RegionFactory(tf, of, mf);
		Region region = rf.createRegion(null);
		Site s = region.getSite(2, 1);

		assertEquals(s.getTerrain().getType(), "Water"); //$NON-NLS-1$
		assertTrue(s.hasObject("Human")); //$NON-NLS-1$

		s = region.getSite(1, 1);
		assertFalse(s.hasObject("Human")); //$NON-NLS-1$
	}

}
