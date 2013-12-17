package ua.kiev.mytnyk.garrettheshadow;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
//import android.util.Log;

public class Scene implements GLSurfaceView.Renderer {
	
	private TextureProvider mTexProvider;
	
	private World mWorld;
	
	private float mViewPoint = -20f;
	
	public Scene(Context context) {
		mWorld = new World(context, WorldLevel.LEVEL1);
		mTexProvider = new TextureProvider(context);
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glShadeModel(GL10.GL_SMOOTH); 			//Enable Smooth Shading
		gl.glClearColor(0.0f, 0.0f, 5.0f, 0.5f); 	//Black Background
		gl.glClearDepthf(1.0f); 					//Depth Buffer Setup
		gl.glEnable(GL10.GL_DEPTH_TEST); 			//Enables Depth Testing
		gl.glDepthFunc(GL10.GL_LEQUAL); 			//The Type Of Depth Testing To Do
		gl.glEnable(GL10.GL_TEXTURE_2D);            //Enable Texture Mapping

		mTexProvider.bind(gl);
    }
	
	@Override
    public void onDrawFrame(GL10 gl) {

        // Draw background color
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        // Set GL_MODELVIEW transformation mode
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();   // reset the matrix to its default state

        // When using GL_MODELVIEW, you must set the view point
        synchronized (mWorld) {
	        int hx = mWorld.getHumanX();
	        int hy = mWorld.getHumanY();
	        
			GLU.gluLookAt(gl, hx, hy, mViewPoint, hx, hy, 0f, 0f, 1.0f, 0.0f);
	        // draw the World
			mWorld.draw(gl, mTexProvider);
        }
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Adjust the viewport based on geometry changes
        // such as screen rotations
        gl.glViewport(0, 0, width, height);

        // make adjustments for screen ratio
        float ratio = (float) width / height;
        gl.glMatrixMode(GL10.GL_PROJECTION);        // set matrix to projection mode
        gl.glLoadIdentity();                        // reset the matrix to its default state
        gl.glFrustumf(-ratio, ratio, -1, 1, 3, 70);  // apply the projection matrix
    }
    

	/**
	 * Load the textures
	 * 
	 * @param gl - The GL Context
	 * @param context - The Activity context
	 */

	public void scaleDown()	{
		mViewPoint += 0.03f*mViewPoint;
		if (mViewPoint < -69)
			mViewPoint = -69;
		//Log.d("DEBUG","Down " + mViewPoint);
	}
	
	public void scaleUp() {
		mViewPoint -= 0.03f*mViewPoint;
		if (mViewPoint > -3)
			mViewPoint = -3;
		//Log.d("DEBUG","Up " + mViewPoint);
	}
	
	public World getWorld() {
		return mWorld;
	}
}
