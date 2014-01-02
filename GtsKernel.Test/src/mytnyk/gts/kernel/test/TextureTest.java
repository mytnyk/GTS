package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Texture;

import org.junit.Test;

public class TextureTest {

	@SuppressWarnings("static-method")
	@Test
	public void testTexture() {
		String name = "some name"; //$NON-NLS-1$
		String file = "some file"; //$NON-NLS-1$
		Texture tex = new Texture(name, file);
		assertEquals(name, tex.getName());
		assertEquals(file, tex.getFile());
	}

}
