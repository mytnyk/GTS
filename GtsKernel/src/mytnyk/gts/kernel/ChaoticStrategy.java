package mytnyk.gts.kernel;

import java.util.Random;

public class ChaoticStrategy implements IStrategy {

	private final Random rn = new Random();

	@Override
	public void move(int[] xy) {
		Direction.get(getRandom()).move(xy);
	}

	public int getRandom() {
		return rn.nextInt(5); // 0, 1, 2, 3, 4;
	}

}
