package mytnyk.gts.kernel.xml;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Code;
import mytnyk.gts.kernel.IListOfObjects;

public class XmlCodeList implements IListOfObjects {

	static final private String mTag = "Code";
	static final private String mValue = "Value";
	static final private String mTerrain = "Terrain";
	static final private String mObject = "Object";

	final private ArrayList<Code> mList = new ArrayList<Code>();

	public final ArrayList<Code> getList() {
		return mList;
	}

	@Override
	public String getObjectTag() {
		return mTag;
	}

	@Override
	public void add(Hashtable<String, String> properties) {
		String value = properties.get(mValue);
		String terrain = properties.get(mTerrain);
		Code c = new Code(value, terrain);
		String obj_list = properties.get(mObject);
		if (obj_list != null)
			for (String o : obj_list.split(" "))
				c.add(o);
		mList.add(c);
	}
}

