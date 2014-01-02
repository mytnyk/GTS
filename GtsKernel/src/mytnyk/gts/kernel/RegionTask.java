package mytnyk.gts.kernel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegionTask implements Runnable {

	private final Collection<ObjectTask> mTasks = new ArrayList<>();

	public RegionTask(Region region) {
		for (int y = 0; y < region.getHeight(); y++)
			for (int x = 0; x < region.getWidth(); x++) {
				ListIterator<Object> list = region.getSite(x, y).getObjects();
				while (list.hasNext())
					mTasks.add(new ObjectTask(list.next(), region));
			}
	}

	@Override
	public void run() {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (ObjectTask t : mTasks)
			exec.execute(t);
	}
	
	public void stop() {
		for (ObjectTask t : mTasks)
			t.stop();
	}

	public void pause() {
		for (ObjectTask t : mTasks)
			t.pause();
	}

	public void resume() {
		for (ObjectTask t : mTasks)
			t.resume();
	}
}
