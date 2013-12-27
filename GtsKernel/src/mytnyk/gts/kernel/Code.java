package mytnyk.gts.kernel;

import java.util.ArrayList;
import java.util.ListIterator;

public class Code {

	final private String mValue;
	final private String mTerrain;
	final ArrayList<String> mObjectList = new ArrayList<>();

	public Code(String value, String terrain) {
		mValue = value;
		mTerrain = terrain;
	}

	public void add(String obj) {
		mObjectList.add(obj);
	}

	public String getValue() {
		return mValue;
	}

	public String getTerrain() {
		return mTerrain;
	}
	
	public ListIterator<String> getObject() {
		return mObjectList.listIterator();
	}

}
