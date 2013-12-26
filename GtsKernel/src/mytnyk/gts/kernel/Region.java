package mytnyk.gts.kernel;

import java.util.ListIterator;

final public class Region {

	final private Site[][] mSite;

	public Region(Code[][] map, TerrainFactory terrainFactory, ObjectFactory objectFactory) {
		int w = map.length;
		int h = map[0].length;
		mSite = new Site[w][h];

		for (int x = 0; x < w; x++) {
			for(int y = 0; y < h; y++) {
				String terrainType = map[x][y].getTerrain();
				mSite[x][y] = new Site(terrainFactory.getTerrain(terrainType));

				ListIterator<String> objIt = map[x][y].getObject();
				while (objIt.hasNext())
					mSite[x][y].addObject(objectFactory.getObject(objIt.next()));
			}
		}
	}

	public Site getSite(int x, int y) {
		return mSite[x][y];
	}

	public int getWidth() {
		return mSite.length;
	}

	public int getHeight() {
		return mSite[0].length;
	}
}
