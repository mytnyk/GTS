package ua.kiev.mytnyk.garrettheshadow;

public enum Texture {
	ROAD (R.drawable.road),
	WALL (R.drawable.mud),
	TREE (R.drawable.tree),
	END  (R.drawable.finish),
	HUMAN(R.drawable.aze1);
	
	final private int mResId; // resource name
	
	private Texture(int resId) {
		mResId = resId;
	}
	
	public int getResId() {
		return mResId;
	}
}
