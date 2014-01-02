package mytnyk.garretttheshadow;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.microedition.khronos.opengles.GL10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;

import mytnyk.gts.kernel.Texture;

public class TextureFactory {

	private ArrayList<Texture> mList;
	private Hashtable<String, Integer> mNameToPointer = new Hashtable<String, Integer>();

	public TextureFactory(ArrayList<Texture> list) {
		mList = list;
	}

	public void bind(GL10 gl) {
		// Allocate texture pointers
		int numOfObjects = mList.size();
		int[] texPointers = new int[numOfObjects];
		// Generate texture pointers
		gl.glGenTextures(numOfObjects, texPointers, 0);

		for (int i = 0; i < mList.size(); i++) {
			Texture texture = mList.get(i);
			bind(gl, texPointers[i], texture.getFile());
			mNameToPointer.put(texture.getName(), Integer.valueOf(texPointers[i]));
		}
	}

	private void bind(GL10 gl, int pointer, String fileName) {
		//Get the texture from the Android resource directory
		InputStream is = getClass().getResourceAsStream(fileName);//mContext.getResources().openRawResource(object.getResId());
		Bitmap bitmap = BitmapFactory.decodeStream(is);
		try {
			is.close();
		} catch (IOException e) {
			Log.e("TEXTURES", "Failed to close input stream for " + fileName); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (bitmap == null) {
			Log.e("TEXTURES", "Cannot open texture in file " + fileName); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		//Create Nearest Filtered Texture and bind it to texture
		gl.glBindTexture(GL10.GL_TEXTURE_2D, pointer);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);

		bitmap.recycle();
	}

	public int getTexturePointer(String name)
	{
		return mNameToPointer.get(name).intValue();
	}
}
