package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Direction;
import mytnyk.gts.kernel.ManualStrategy;

import org.junit.Test;

public class ManualStrategyTest {

	@Test
	public void test() {
		ManualStrategy s = new ManualStrategy();
		s.setDirection(Direction.UP);
		int[] xy = new int[] {0, 0};

		s.move(xy);
		assertArrayEquals(xy, new int[] {0, 1});
	}

}
