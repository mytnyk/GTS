package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.Code;

import org.junit.Test;

public class CodeTest {

	@Test
	public void test() {
		String value = "some value";
		String terrain = "some terrain";
		Code c = new Code(value, terrain);
		String obj = "some obj";
		c.add(obj);
		assertEquals(c.getTerrain(), terrain);
		assertEquals(c.getValue(), value);
		assertEquals(c.getObject().next(), obj);
	}

}
