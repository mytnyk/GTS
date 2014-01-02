package mytnyk.garretttheshadow;

import mytnyk.gts.kernel.MapFactory;
import mytnyk.gts.kernel.ObjectFactory;
import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.RegionFactory;
import mytnyk.gts.kernel.RegionTask;
import mytnyk.gts.kernel.TerrainFactory;
import mytnyk.gts.kernel.xml.XmlCodeList;
import mytnyk.gts.kernel.xml.XmlListParser;
import mytnyk.gts.kernel.xml.XmlObjectList;
import mytnyk.gts.kernel.xml.XmlTerrainList;
import mytnyk.gts.kernel.xml.XmlTextureList;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuItem;

public class Run extends Activity {

	private final RegionFactory mRegionFactory;
	private final Scene mScene; 
	private RegionTask mRegionTask = null;

	public Run() {
		XmlTerrainList terrainList 	= new XmlTerrainList();
		XmlObjectList objectList 	= new XmlObjectList();
		XmlCodeList codeList 		= new XmlCodeList();
		XmlTextureList textureList 	= new XmlTextureList();

		XmlListParser xmlparser 	= new XmlListParser();
		xmlparser.parse(getClass().getResourceAsStream("terrain.xml")	, terrainList); //$NON-NLS-1$
		xmlparser.parse(getClass().getResourceAsStream("object.xml")	, objectList); //$NON-NLS-1$
		xmlparser.parse(getClass().getResourceAsStream("code.xml")		, codeList); //$NON-NLS-1$
		xmlparser.parse(getClass().getResourceAsStream("texture.xml")	, textureList); //$NON-NLS-1$

		mRegionFactory = new RegionFactory(
				new TerrainFactory(terrainList.getList()), 
				new ObjectFactory(objectList.getList()), 
				new MapFactory(codeList.getList()));

		mScene = new Scene(new TextureFactory(textureList.getList()));
	}

	private void LoadLevel1() {
		if (mRegionTask != null) {
			mRegionTask.stop();
			mRegionTask = null;
		}

		Region region = mRegionFactory.createRegion(getClass().getResourceAsStream("level1.txt")); //$NON-NLS-1$
		mScene.Load(region);
		mRegionTask = new RegionTask(region);
		mRegionTask.run();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		GLSurfaceView glSurface = new GLSurfaceView(this);
		glSurface.setRenderer(mScene);
		glSurface.setOnTouchListener(new Control(mScene));
		glSurface.setKeepScreenOn(true);

		setContentView(glSurface);

		LoadLevel1();
	}


	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onBackPressed() {
		return; // do not exit on pressing back
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.exit:
			finish();
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

	@Override
	protected void onPause() {
		mRegionTask.pause();
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		mRegionTask.resume();
		super.onResume();
	}
}
