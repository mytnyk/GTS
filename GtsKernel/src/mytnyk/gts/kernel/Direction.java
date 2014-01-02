package mytnyk.gts.kernel;

public enum Direction {
	NONE (0),
	LEFT (1),
	RIGHT(2),
	DOWN (3),
	UP   (4);

	int mCode;
	Direction(int code) {
		mCode = code;
	}

	public static Direction get(int code) {
		for(Direction d : Direction.values()) {
			if (d.mCode == code)
				return d;
		}
		throw new RuntimeException("Illegal direction code!"); //$NON-NLS-1$
	}

	public void move(int[] xy) {
		switch (this) {
		default:
		case NONE:
			break;
		case LEFT:
			xy[0] -= 1;
			break;
		case RIGHT:
			xy[0] += 1;
			break;
		case DOWN:
			xy[1] -= 1;
			break;
		case UP:
			xy[1] += 1;
			break;
		}
	}
}
