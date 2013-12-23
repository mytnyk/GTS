package mytnyk.gts.kernel.xml;

import java.util.ArrayList;

import mytnyk.gts.kernel.Terrain;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class TerrainXml {

	final private String mTerrainTag = "Terrain";
	final private String mTerrainName = "Name";
	
	public ArrayList<Terrain> Read() {
		ArrayList<Terrain> list = null;
		
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

		XmlPullParser parser = factory.newPullParser();
		
		XmlReader(mTerrainTag, )
		
		return null;
	}
}
