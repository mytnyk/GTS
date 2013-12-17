package ua.kiev.mytnyk.garrettheshadow;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
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

}
