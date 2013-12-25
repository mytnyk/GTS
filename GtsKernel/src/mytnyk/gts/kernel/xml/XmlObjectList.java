package mytnyk.gts.kernel.xml;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.IListOfObjects;
import mytnyk.gts.kernel.Object;

public class XmlObjectList implements IListOfObjects {

	static final private String mTag = "Object";
	static final private String mType = "Type";
	static final private String mBehavior = "Behavior";
	static final private String mTerrain = "Terrain";
	static final private String mSpeed = "Speed";
	static final private String mTake = "Take";
	static final private String mKill = "Kill";

	final private ArrayList<Object> mList = new ArrayList<Object>();

	public final ArrayList<Object> getList() {
		return mList;
	}

	@Override
	public String getObjectTag() {
		return mTag;
	}

	@Override
	public void add(Hashtable<String, String> properties) {
		String type = properties.get(mType);
		String behavior = properties.get(mBehavior);
		Object t = new Object(type, behavior);

		String terrain_list = properties.get(mTerrain);
		if (terrain_list != null)
			for (String s : terrain_list.split(" "))
				t.addTerrain(s);

		String speed = properties.get(mSpeed);
		if (speed != null)
			t.setSpeed(speed);

		String take_list = properties.get(mTake);
		if (take_list != null)
			for (String s : take_list.split(" "))
				t.addTake(s);

		String kill_list = properties.get(mKill);
		if (kill_list != null)
			for (String s : kill_list.split(" "))
				t.addKill(s);

		mList.add(t);		
	}
}