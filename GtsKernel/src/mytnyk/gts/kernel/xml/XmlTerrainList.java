package mytnyk.gts.kernel.xml;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Terrain;

public class XmlTerrainList implements IListOfObjects {

	static final private String mTag = "Terrain"; //$NON-NLS-1$
	static final private String mType = "Type"; //$NON-NLS-1$

	final private ArrayList<Terrain> mList = new ArrayList<>();

	public final ArrayList<Terrain> getList() {
		return mList;
	}
	
	@Override
	public String getObjectTag() {
		return mTag;
	}

	@Override
	public void add(Hashtable<String, String> properties) {
		String type = properties.get(mType);
		Terrain t = new Terrain(type);
		mList.add(t);		
	}
}
