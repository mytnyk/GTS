package mytnyk.gts.kernel;

public class ManualStrategy implements IStrategy {

	// Breaking rules here.. 
	// TODO: think of how to pass to manual control object
	public static Direction mDirection = Direction.NONE;
	@Override
	public void move(int[] xy) {
		mDirection.move(xy);
	}
	
	public void setDirection(Direction d) {
		mDirection = d;
	}

}
