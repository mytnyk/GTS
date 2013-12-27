package mytnyk.gts.kernel;

import java.io.InputStream;
import java.util.ListIterator;

public class RegionFactory {

	TerrainFactory mTerrainFactory;
	ObjectFactory mObjectFactory;
	MapFactory mMapFactory;

	public RegionFactory(TerrainFactory terrainFactory, ObjectFactory objectFactory, MapFactory mapFactory) {
		mTerrainFactory = terrainFactory;
		mObjectFactory = objectFactory;
		mMapFactory = mapFactory;
	}
	
	public Region createRegion(InputStream is) {
		Code[][] map = mMapFactory.getMap(is);
		
		int w = map.length;
		int h = map[0].length;
		Site[][] site = new Site[w][h];

		for (int x = 0; x < w; x++) {
			for(int y = 0; y < h; y++) {
				String terrainType = map[x][y].getTerrain();
				site[x][y] = new Site(mTerrainFactory.getTerrain(terrainType));

				ListIterator<String> objIt = map[x][y].getObject();
				while (objIt.hasNext())
					site[x][y].addObject(mObjectFactory.createObject(objIt.next()));
			}
		}
		
		return new Region(site);
	}
}
