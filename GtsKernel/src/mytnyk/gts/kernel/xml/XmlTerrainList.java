package mytnyk.gts.kernel.xml;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.IListOfObjects;
import mytnyk.gts.kernel.Terrain;

public class XmlTerrainList implements IListOfObjects {

	static final private String mTerrainTag = "Terrain";
	static final private String mTerrainName = "Type";

	final private ArrayList<Terrain> mTerrainList = new ArrayList<Terrain>();

	public final ArrayList<Terrain> getList() {
		return mTerrainList;
	}
	
	@Override
	public String getObjectTag() {
		return mTerrainTag;
	}

	@Override
	public void add(Hashtable<String, String> properties) {
		String terrainName = properties.get(mTerrainName);
		Terrain t = new Terrain(terrainName);
		mTerrainList.add(t);		
	}
}
