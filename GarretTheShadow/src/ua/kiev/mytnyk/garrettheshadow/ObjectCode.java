package ua.kiev.mytnyk.garrettheshadow;

public enum ObjectCode {
	ROAD (0),
	WALL (1),
	TREE (2),
	END  (5),
	HUMAN(8);
	
	final private int mCode;
	
	private ObjectCode(int code) {
		mCode = code;
	}
	
	public int getCode() {
		return mCode;
	}
}
