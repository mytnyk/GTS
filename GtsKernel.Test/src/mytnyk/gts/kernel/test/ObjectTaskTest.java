package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import mytnyk.gts.kernel.Object;
import mytnyk.gts.kernel.ObjectTask;

import org.junit.Test;

public class ObjectTaskTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() throws Throwable {
		Object o = new Object("obj", "chaotic"); //$NON-NLS-1$ //$NON-NLS-2$
		ObjectTask t = new ObjectTask(o);

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(t);
		Thread.sleep(10000);
		//exec.shutdown();
		//exec.awaitTermination(10, TimeUnit.SECONDS);
		t.Stop();
	}

}
