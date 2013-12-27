package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.TerrainFactory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TerrainFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		ArrayList<Terrain> list = new ArrayList<>();
		Terrain t = new Terrain("highway"); //$NON-NLS-1$
		list.add(t);
		TerrainFactory f = new TerrainFactory(list);
		assertEquals(f.getTerrain("highway").getType(), "highway"); //$NON-NLS-1$ //$NON-NLS-2$
		assertEquals(f.getTerrain("highway"), t); //$NON-NLS-1$
	}

	@Test
	public void testNotSupported() {
		ArrayList<Terrain> list = new ArrayList<>();
		list.add(new Terrain("highway")); //$NON-NLS-1$
		TerrainFactory f = new TerrainFactory(list);

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Terrain type is not supported"); //$NON-NLS-1$

		f.getTerrain("road"); //$NON-NLS-1$
	}

}
