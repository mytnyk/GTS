package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Texture;

import org.junit.Test;

public class TextureTest {

	@SuppressWarnings("static-method")
	@Test
	public void testTexture() {
		String str = "some name"; //$NON-NLS-1$
		Texture tex = new Texture(str);
		assertEquals(str, tex.getName());
	}

}
