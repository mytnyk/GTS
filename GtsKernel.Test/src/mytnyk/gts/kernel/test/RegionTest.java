package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Map;
import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.Site;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class RegionTest {

	@Test
	public void test() {
		
		Map map = mock(Map.class);
		when(map.getMap()).thenReturn(new int[][]{ {0, 1}, {2, 3}, {4, 5} });
		
		Region region = new Region(map);
		Site s = region.getSite(2, 1);
		assertEquals(s.getTerrain().getType(), "Road");
	}

}
