package mytnyk.gts.kernel;

public class ObjectTask implements Runnable {

	private final Object mObject;
	
	public ObjectTask(Object object) {
		mObject = object;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				System.out.println(mObject.getType());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finished!");
	}

	public void Stop() {
		Thread.currentThread().interrupt();
	}

	
}
