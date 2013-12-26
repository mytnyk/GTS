package mytnyk.gts.applet;

import java.applet.*;
import java.io.InputStream;
import java.util.ArrayList;

import mytnyk.gts.kernel.*;
import mytnyk.gts.kernel.Object;
import mytnyk.gts.kernel.xml.*;

public class GtsApplet extends Applet {
	private static final long serialVersionUID = 1L;

	public void init() {
		//Execute a job on the event-dispatching thread:
		//creating this applet's GUI.

		XmlTerrainList tlist = new XmlTerrainList();
		XmlObjectList olist = new XmlObjectList();
		XmlCodeList clist = new XmlCodeList();
		XmlListParser xmlparser = new XmlListParser();
		xmlparser.parse(getClass().getResourceAsStream("terrain.xml"), tlist);
		xmlparser.parse(getClass().getResourceAsStream("object.xml"), olist);
		xmlparser.parse(getClass().getResourceAsStream("code.xml"), clist);

		TerrainFactory tf = new TerrainFactory(tlist.getList());
		ObjectFactory of = new ObjectFactory(olist.getList());
		MapFactory mf = new MapFactory(clist.getList());

		Code[][] map = mf.generate(getClass().getResourceAsStream("level1.txt"));
		Region r = new Region(map, tf, of);

		for (int y = 0; y < r.getHeight(); y++)
			for (int x = 0; x < r.getWidth(); x++)
				System.out.println(r.getSite(x, y));

	}
}
