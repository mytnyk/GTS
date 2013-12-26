package mytnyk.gts.kernel;

import java.util.ArrayList;

public class TerrainFactory {

	private final ArrayList<Terrain> mList;
	public TerrainFactory(ArrayList<Terrain> list) {
		mList = list;
	}
	
	public Terrain getTerrain(String type) {
		for (Terrain t : mList)
			if (t.getType().equalsIgnoreCase(type))
				return t;
		throw new RuntimeException("Terrain type is not supported!");
	}
}
