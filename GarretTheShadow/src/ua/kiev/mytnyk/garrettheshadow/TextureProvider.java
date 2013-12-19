package ua.kiev.mytnyk.garrettheshadow;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;

public class TextureProvider implements ITextureProvider {

	private Context mContext;
	/** texture pointers */
	private int[] mTexPointers;
	
	public TextureProvider(Context context) {
		mContext = context;
	}

	public void bind(GL10 gl) {
        // Allocate texture pointers
		int numOfObjects = Texture.values().length;
		mTexPointers = new int[numOfObjects];
		// Generate texture pointers
		gl.glGenTextures(numOfObjects, mTexPointers, 0);
		
		for (Texture obj: Texture.values()) {
			bind(gl, obj);
        }
	}
	
    private void bind(GL10 gl, Texture object) {
    	//Get the texture from the Android resource directory
    	InputStream is = mContext.getResources().openRawResource(object.getResId());
    	Bitmap bitmap = BitmapFactory.decodeStream(is);
    	try {
			is.close();
		} catch (IOException e) {
			Log.e("TEXTURES", "Failed to close input stream for resource index " + object);
		}
    	if (bitmap == null) {
    		Log.e("TEXTURES", "Cannot find texture for resource index " + object);
    	}
    	
		//Create Nearest Filtered Texture and bind it to texture
		gl.glBindTexture(GL10.GL_TEXTURE_2D, mTexPointers[object.ordinal()]);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);

		bitmap.recycle(); 
    }
    
    @Override
	public int getTexturePointer(Texture object) {
    	return mTexPointers[object.ordinal()];
    }
}
