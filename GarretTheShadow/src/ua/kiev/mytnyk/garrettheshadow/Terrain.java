package ua.kiev.mytnyk.garrettheshadow;

public enum Terrain {
	ROAD (Texture.ROAD,   ObjectCode.ROAD),
	WALL (Texture.WALL,   ObjectCode.WALL),
	TREE (Texture.TREE,   ObjectCode.TREE);
	
	final private Texture mTex;
	final private ObjectCode mCode;
	

	private Terrain(Texture tex, ObjectCode code) {
		mTex = tex;
		mCode = code;
	}

	public Texture getTexture() {
		return mTex;
	}
	
	public static Terrain getByCode(int code){
        for (Terrain obj : Terrain.values()) {
            if (obj.mCode.getCode() == code)
                return obj;
        }
        return Terrain.ROAD;
    }
}
