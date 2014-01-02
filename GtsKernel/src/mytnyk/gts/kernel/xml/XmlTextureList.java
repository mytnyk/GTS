package mytnyk.gts.kernel.xml;

import java.util.ArrayList;
import java.util.Hashtable;

import mytnyk.gts.kernel.Texture;

public class XmlTextureList implements IListOfObjects {

	static final private String mTag = "Texture"; //$NON-NLS-1$
	static final private String mName = "Name"; //$NON-NLS-1$
	static final private String mFile = "File"; //$NON-NLS-1$

	final private ArrayList<Texture> mList = new ArrayList<>();

	public final ArrayList<Texture> getList() {
		return mList;
	}
	
	@Override
	public String getObjectTag() {
		return mTag;
	}

	@Override
	public void add(Hashtable<String, String> properties) {
		String name = properties.get(mName);
		String file = properties.get(mFile);
		Texture t = new Texture(name, file);
		mList.add(t);
	}

}
