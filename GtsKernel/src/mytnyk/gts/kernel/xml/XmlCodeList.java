package mytnyk.gts.kernel.xml;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Code;

public class XmlCodeList implements IListOfObjects {

	static final private String mTag = "Code"; //$NON-NLS-1$
	static final private String mValue = "Value"; //$NON-NLS-1$
	static final private String mTerrain = "Terrain"; //$NON-NLS-1$
	static final private String mObject = "Object"; //$NON-NLS-1$

	final private ArrayList<Code> mList = new ArrayList<>();

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
			for (String o : obj_list.split(" ")) //$NON-NLS-1$
				c.add(o);
		mList.add(c);
	}
}

