package mytnyk.gts.kernel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

final public class Site {

	private ArrayList<Object> mObjects = new ArrayList<>();
	private final Terrain mTerrain;

	public Site(Terrain t) {
		mTerrain = t;
	}

	public ListIterator<Object> getObjects() {
		return mObjects.listIterator();
	}

	public void addObject(Object o) {
		mObjects.add(o);
	}

	public boolean hasObject(String obj) {
		for (Object o : mObjects)
			if (o.getType().equalsIgnoreCase(obj))
				return true;
		return false;
	}

	public Terrain getTerrain() {
		return mTerrain;
	}

	@Override
	public String toString() {
		return mTerrain.getType() + " " + Arrays.toString(mObjects.toArray()); //$NON-NLS-1$
	}
}
