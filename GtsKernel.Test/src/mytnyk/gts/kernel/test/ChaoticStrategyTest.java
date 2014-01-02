package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import mytnyk.gts.kernel.ChaoticStrategy;

import org.junit.Test;

public class ChaoticStrategyTest {

	@Test
	public void test() {
		ChaoticStrategy s = spy(new ChaoticStrategy());
		int[] xy = new int[] {0, 0};

		doReturn(new Integer(1)).when(s).getRandom();
		s.move(xy);
		assertArrayEquals(xy, new int[] {-1, 0});
	}

}