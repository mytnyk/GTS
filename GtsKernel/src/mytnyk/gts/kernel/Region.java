package mytnyk.gts.kernel;

final public class Region {

	final private Site[][] mSite;

	public Region(Site[][] site) {
		mSite = site;
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
