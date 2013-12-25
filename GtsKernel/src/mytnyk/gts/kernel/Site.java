package mytnyk.gts.kernel;

import java.util.ArrayList;
import java.util.ListIterator;

final public class Site {

	private ArrayList<Object> mObjects = new ArrayList<Object>();
	private final Terrain mTerrain;

	public Site(Terrain t) {
		mTerrain = t;
	}

	public final ListIterator<Object> getObjects() {
		return mObjects.listIterator();
	}

	public void addObject(Object o) {
		mObjects.add(o);
	}

	public Terrain getTerrain() {
		return mTerrain;
	}

}
