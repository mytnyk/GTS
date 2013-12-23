package mytnyk.gts.applet;

import java.applet.*;
import java.io.InputStream;
import java.util.ArrayList;

import mytnyk.gts.kernel.Terrain;
import mytnyk.gts.kernel.xml.XmlListParser;
import mytnyk.gts.kernel.xml.XmlTerrainList;

public class GtsApplet extends Applet {
	private static final long serialVersionUID = 1L;

	public void init() {
		//Execute a job on the event-dispatching thread:
		//creating this applet's GUI.
		Terrain ter = new Terrain("road");
		String s = ter.getType();
		System.out.print(s);

		InputStream is = getClass().getResourceAsStream("terrain.xml");

		XmlTerrainList xmllist = new XmlTerrainList();
		XmlListParser xmlparser = new XmlListParser();
		xmlparser.parse(is, xmllist);
		ArrayList<Terrain> list = xmllist.getList();

		for(Terrain t : list)
			System.out.println(t.getType());
	}
}
