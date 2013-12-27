package mytnyk.gts.kernel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tasks {

	public Tasks() {
		Object o = new Object("obj", "chaotic"); //$NON-NLS-1$ //$NON-NLS-2$
		ObjectTask otask = new ObjectTask(o);

		Collection<ObjectTask> tasks = new ArrayList<>();
		tasks.add(otask);


		ExecutorService exec = Executors.newCachedThreadPool();
		for (ObjectTask t : tasks)
			exec.execute(t);
	}
}
