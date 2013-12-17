package ua.kiev.mytnyk.garrettheshadow;

public enum WorldObject {
	ROAD (R.drawable.road,   0),
	WALL (R.drawable.mud,    1),
	TREE (R.drawable.tree,   2),
	END  (R.drawable.finish, 5),
	HUMAN(R.drawable.aze1,   8);
	
	private int mResId; // resource name
	private int mCode;  // code in map file
	 
	private WorldObject(int resId, int code) {
		mResId = resId;
		mCode = code;
	}
 
	public int getResId() {
		return mResId;
	}
	
	public int getCode() {
		return mCode;
	}
	
	public static WorldObject getByCode(int code){
        for (WorldObject obj: WorldObject.values()) {
            if (obj.mCode == code)
                return obj;
        }
        throw new IllegalArgumentException("Invalid object code!");
    }
}
