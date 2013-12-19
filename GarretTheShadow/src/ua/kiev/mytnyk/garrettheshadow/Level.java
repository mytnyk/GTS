package ua.kiev.mytnyk.garrettheshadow;

public enum Level {
	LEVEL1 ("level1.txt");
	 
	private String mLevelMapFileName;  // file name of a level
		 
	private Level(String name) {
		mLevelMapFileName = name;
	}
	 
	public String getFileName() {
		return mLevelMapFileName;
	}
}
