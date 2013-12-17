package ua.kiev.mytnyk.garrettheshadow;

public enum WorldLevel {
	LEVEL1 ("level1.txt");
	 
	private String mLevelMapFileName;  // file name of a level
		 
	private WorldLevel(String name) {
		mLevelMapFileName = name;
	}
	 
	public String getFileName() {
		return mLevelMapFileName;
	}
}
