package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.StaticStrategy;

import org.junit.Test;

public class StaticStrategyTest {

	@Test
	public void test() {
		StaticStrategy s = new StaticStrategy();
		int[] xy = new int[] {2, 3};
		s.move(xy);
		assertArrayEquals(xy, new int[] {2, 3});
	}

}
