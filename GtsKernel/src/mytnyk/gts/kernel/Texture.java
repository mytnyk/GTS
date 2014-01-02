package mytnyk.gts.kernel;

final public class Texture {
	final private String mName;
	final private String mFile;

	public Texture(String name, String file) {
		mName = name;
		mFile = file;
	}

	public String getName() {
		return mName;
	}

	public String getFile() {
		return mFile;
	}
}
