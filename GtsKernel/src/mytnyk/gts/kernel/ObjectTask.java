package mytnyk.gts.kernel;

public class ObjectTask implements Runnable {

	private final Object mObject;
	private final Region mRegion;
	private final IStrategy mStrategy;
	private Thread mThread = null;
	private final int[] xy = new int[] {0, 0};
	private boolean isPaused = false;

	public ObjectTask(Object object, Region region) {
		mObject = object;
		mRegion = region;
		mStrategy = StrategyType.create(mObject.getBehavior());
	}

	@Override
	public void run() {
		mThread = Thread.currentThread();

		try {
			while (true) {
				look();

				long lag = 1000;
				if (mObject.getSpeed() > 0.f)
					lag = (long) (1000/mObject.getSpeed());
				Thread.sleep(lag);

				synchronized (mRegion) {
					if (!mRegion.getPosition(xy, mObject))
						break; // if no object is found in region, then exit the task

					Site oldSite = mRegion.getSite(xy[0], xy[1]);
					mStrategy.move(xy);
					Site newSite = mRegion.getSite(xy[0], xy[1]);

					if (oldSite != newSite && null != newSite &&
							mObject.hasTerrain(newSite.getTerrain().getType())) {
						oldSite.removeObject(mObject); // change position of object in region
						newSite.addObject(mObject);
					}
				}
			}
		} catch (InterruptedException e) {
			// interrupted
		}
	}

	public void stop() {
		mThread.interrupt();
	}

	public void pause(){
		isPaused = true;
	}

	public void resume(){
		if (isPaused) {
			synchronized (mThread) {
				isPaused = false;
				mThread.notify();
			}
		}
	}

	private void look() throws InterruptedException{
		while (isPaused) {
			synchronized (mThread) {
				mThread.wait();
			}
		}
	}
}
