package mytnyk.gts.applet;

import java.applet.*;

import mytnyk.gts.kernel.Terrain;

public class GtsApplet extends Applet {
	private static final long serialVersionUID = 1L;

	public void init() {
	    //Execute a job on the event-dispatching thread:
	    //creating this applet's GUI.
		Terrain ter = new Terrain("road");
		String s = ter.getType();
		System.out.print(s);
	}
}
