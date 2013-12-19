package ua.kiev.mytnyk.garrettheshadow;

public enum Object {
	END  (Texture.END,     ObjectCode.END),
	HUMAN(Texture.HUMAN,   ObjectCode.HUMAN);
	
	final private Texture mTex;
	final private ObjectCode mCode;  // code in map file
	
	private Object(Texture tex, ObjectCode code) {
		mTex = tex;
		mCode = code;
	}

	public Texture getTexture() {
		return mTex;
	}
	
	public static Object getByCode(int code){
        for (Object obj : Object.values()) {
            if (obj.mCode.getCode() == code)
                return obj;
        }
        return null;
    }
}
