package mytnyk.gts.kernel;

final public class Region {

	final private Site[][] mSite;

	public Region(Map map) {
		final int [][] m = map.getMap();
		int w = m.length;
		int h = m[0].length;
		mSite = new Site[w][h];

		for (int x = 0; x < w; x++) {
			for(int y = 0; y < h; y++) {
				// TODO: 
				// 1) read map
				// 2) do not create new terrain here, just take it from list
				// 3) clone necessary objects
				mSite[x][y] = new Site(new Terrain("Road"));
			}
		}
	}

	public Site getSite(int x, int y) {
		return mSite[x][y];
	}
}
