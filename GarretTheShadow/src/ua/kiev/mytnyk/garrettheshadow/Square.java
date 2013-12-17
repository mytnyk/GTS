package ua.kiev.mytnyk.garrettheshadow;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 
 */
public class Square {
		
	/** The buffer holding the vertices */
	private FloatBuffer vertexBuffer;
	
	/** The buffer holding the texture coordinates */
	private FloatBuffer textureBuffer;
	
	/** The initial vertex definition */
	private float vertices[] = 	{ 
			-0.5f, -0.5f, 0.0f, //Bottom Left
			 0.5f, -0.5f, 0.0f, //Bottom Right
			-0.5f,  0.5f, 0.0f, //Top Left
		     0.5f,  0.5f, 0.0f, //Top Right
								};
	private float texture[] =	{ 
			0f, 1f, 
			1f, 1f, 
			0f, 0f, 
			1f, 0f,
								};
	
	/**
	 * The Square constructor.
	 * 
	 * Initiate the buffers.
	 */
	public Square() {
		// float size is 4 bytes
		ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		vertexBuffer = byteBuf.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
		
		//
		byteBuf = ByteBuffer.allocateDirect(texture.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		textureBuffer = byteBuf.asFloatBuffer();
		textureBuffer.put(texture);
		textureBuffer.position(0);
	}

	/**
	 * The object own drawing function.
	 * Called from the renderer to redraw this instance
	 * with possible changes in values.
	 * 
	 * @param gl - The GL context
	 */
	public void draw(GL10 gl, int texturePointer) {
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturePointer);
		//Set the face rotation
		gl.glFrontFace(GL10.GL_CW);
		
		//Point to our vertex buffer
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
		
		//Enable vertex buffer
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		
		//Draw the vertices as triangle strip
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
		
		//Disable the client state before leaving
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	}

}
