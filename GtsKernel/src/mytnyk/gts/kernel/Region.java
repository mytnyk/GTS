package mytnyk.gts.kernel;

final public class Region {

	final private Site[][] mSite;

	public Region(Site[][] site) {
		mSite = site;
	}

	public Site getSite(int x, int y) {
		try {
			return mSite[x][y];
		}
		catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public int getWidth() {
		return mSite.length;
	}

	public int getHeight() {
		return mSite[0].length;
	}
/*
	public Site getSite(Object obj) {
		for (Site[] row : mSite)
			for (Site s : row)
				if (s.hasObject(obj))
					return s;
		return null;
	}*/

	public boolean getPosition(int[] xy, Object obj) {
		for (int y = 0; y < getHeight(); y++)
			for (int x = 0; x < getWidth(); x++)
				if (mSite[x][y].hasObject(obj)) {
					xy[0] = x;
					xy[1] = y;
					return true;
				}
		return false;
	}
}
