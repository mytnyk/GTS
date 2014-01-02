package mytnyk.garretttheshadow;

import java.util.ListIterator;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import mytnyk.gts.kernel.Region;
import mytnyk.gts.kernel.Site;
import mytnyk.gts.kernel.Object;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

public class Scene implements GLSurfaceView.Renderer {

	private TextureFactory mTexFactory;
	private Region mRegion = null;
	private Square mDrawObj = new Square();
	
	private float mViewPoint = 20f;

	public Scene(TextureFactory texFactory) {
		mTexFactory = texFactory;
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glShadeModel(GL10.GL_SMOOTH); 			//Enable Smooth Shading
		gl.glClearColor(0.0f, 0.0f, 5.0f, 0.5f); 	//Black Background
		gl.glClearDepthf(1.0f); 					//Depth Buffer Setup
		gl.glEnable(GL10.GL_DEPTH_TEST); 			//Enables Depth Testing
		gl.glDepthFunc(GL10.GL_LEQUAL); 			//The Type Of Depth Testing To Do
		gl.glEnable(GL10.GL_TEXTURE_2D);            //Enable Texture Mapping

		mTexFactory.bind(gl);
	}

	@Override
	public void onDrawFrame(GL10 gl) {

		// Draw background color
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		// Set GL_MODELVIEW transformation mode
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();   // reset the matrix to its default state

		synchronized (mRegion) {
			int w =  mRegion.getWidth();
			int h =  mRegion.getHeight();
			
			int hx = 0;
			int hy = 0;

			for (int x = 0; x < w; x++)
				for (int y = 0; y < h; y++) {
					Site s = mRegion.getSite(x, y);
					ListIterator<Object> it = s.getObjects();
					while (it.hasNext()) {
						Object o = it.next();
						if (o.getType().equalsIgnoreCase("Human")) {
							hx = x; hy = y;
						}
					}
				}
			GLU.gluLookAt(gl, hx, hy, mViewPoint, hx, hy, 0f, 0f, 1.0f, 0.0f);

			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					Site s = mRegion.getSite(x, y);

					mDrawObj.draw(gl, mTexFactory.getTexturePointer(s.getTerrain().getType()));

					ListIterator<Object> it = s.getObjects();
					if (it.hasNext()) {
						Object o = it.next();
						mDrawObj.draw(gl, mTexFactory.getTexturePointer(o.getType()));
					}

					gl.glTranslatef(0f, 1.f, 0f);
				}
				gl.glTranslatef(0f, -h*1.f, 0f);
				gl.glTranslatef(1.f, 0f, 0f);
			}
			gl.glTranslatef(-w*1.f, 0f, 0f);
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

	public void scaleDown()	{
		mViewPoint += 0.03f*mViewPoint;
		if (mViewPoint > 69)
			mViewPoint = 69;
	}

	public void scaleUp() {
		mViewPoint -= 0.03f*mViewPoint;
		if (mViewPoint < 3)
			mViewPoint = 3;
	}

	public synchronized void Load(Region region) {
		mRegion = region;
	}
}
