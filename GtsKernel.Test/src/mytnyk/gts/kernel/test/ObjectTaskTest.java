package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import mytnyk.gts.kernel.Object;
import mytnyk.gts.kernel.ObjectTask;
import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.Site;
import mytnyk.gts.kernel.Terrain;

import org.junit.Test;

public class ObjectTaskTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() throws Throwable {

		Object o = new Object("ant", "chaotic"); //$NON-NLS-1$ //$NON-NLS-2$
		o.addTerrain("road"); //$NON-NLS-1$
		o.setSpeed(1000.f);
		Terrain t = new Terrain("road"); //$NON-NLS-1$
		Site[][] site = new Site[][] { {new Site(t), new Site(t)}, {new Site(t), new Site(t)}, {new Site(t), new Site(t)} };
		site[1][1].addObject(o);
		Region r = new Region(site);
		ObjectTask task = new ObjectTask(o, r);

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(task);

		int[] xy = new int[] {0, 0};
		for (int i = 0; i < 100; i++) {
			if (!r.getPosition(xy, o))
				break;
			//System.out.println("Position: " + Arrays.toString(xy)); //$NON-NLS-1$
			Thread.sleep(1);
		}
		task.stop();

		exec.shutdownNow(); // terminate all

		while (!exec.isTerminated()) {
			//System.out.print(".");
		}

		//System.out.println("Finished all threads"); //$NON-NLS-1$

	}

}
