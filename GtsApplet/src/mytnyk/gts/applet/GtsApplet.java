package mytnyk.gts.applet;

import java.applet.*;

import mytnyk.gts.kernel.*;
import mytnyk.gts.kernel.xml.*;

public class GtsApplet extends Applet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		XmlTerrainList tlist = new XmlTerrainList();
		XmlObjectList olist = new XmlObjectList();
		XmlCodeList clist = new XmlCodeList();
		XmlTextureList texlist = new XmlTextureList();
		XmlListParser xmlparser = new XmlListParser();
		xmlparser.parse(getClass().getResourceAsStream("terrain.xml"), tlist); //$NON-NLS-1$
		xmlparser.parse(getClass().getResourceAsStream("object.xml"), olist); //$NON-NLS-1$
		xmlparser.parse(getClass().getResourceAsStream("code.xml"), clist); //$NON-NLS-1$
		xmlparser.parse(getClass().getResourceAsStream("texture.xml"), texlist); //$NON-NLS-1$

		TerrainFactory tf = new TerrainFactory(tlist.getList());
		ObjectFactory of = new ObjectFactory(olist.getList());
		MapFactory mf = new MapFactory(clist.getList());

		RegionFactory rf = new RegionFactory(tf, of, mf);

		Region r = rf.createRegion(getClass().getResourceAsStream("level1.txt")); //$NON-NLS-1$
/*
		for (int y = 0; y < r.getHeight(); y++)
			for (int x = 0; x < r.getWidth(); x++)
				System.out.println(r.getSite(x, y));
	*/	
		RegionTask rt = new RegionTask(r);
		rt.run();

		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				for (int y = 0; y < r.getHeight(); y++)
					for (int x = 0; x < r.getWidth(); x++)
						System.out.println(r.getSite(x, y));
				System.out.println("-----------------------"); //$NON-NLS-1$
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rt.stop();
	}
}
