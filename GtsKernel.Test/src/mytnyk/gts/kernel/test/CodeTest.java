package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Code;

import org.junit.Test;

public class CodeTest {

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		String value = "some value"; //$NON-NLS-1$
		String terrain = "some terrain"; //$NON-NLS-1$
		Code c = new Code(value, terrain);
		String obj = "some obj"; //$NON-NLS-1$
		c.add(obj);
		assertEquals(c.getTerrain(), terrain);
		assertEquals(c.getValue(), value);
		assertEquals(c.getObject().next(), obj);
	}

}
