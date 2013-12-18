package ua.kiev.mytnyk.garrettheshadow;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.res.Configuration;

public class Run extends Activity {

	/** The OpenGL View */
	private GLSurfaceView glSurface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Scene scene = new Scene(this);
		Control ctrl = new Control(scene);
		
		glSurface = new GLSurfaceView(this);
		glSurface.setRenderer(scene);
		glSurface.setOnTouchListener(ctrl);

		setContentView(glSurface);
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
}
