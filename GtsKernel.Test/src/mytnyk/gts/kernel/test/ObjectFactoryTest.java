package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import mytnyk.gts.kernel.ObjectFactory;
import mytnyk.gts.kernel.Object;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ObjectFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@SuppressWarnings("static-method")
	@Test
	public void test() {
		ArrayList<Object> olist = new ArrayList<>();
		Object ant = new Object("ant", "chaotic"); //$NON-NLS-1$ //$NON-NLS-2$
		olist.add(ant);
		ObjectFactory of = new ObjectFactory(olist);
		assertEquals(of.createObject("ant").getType(), "ant"); //$NON-NLS-1$ //$NON-NLS-2$
		assertEquals(of.createObject("ant").getBehavior(), "chaotic"); //$NON-NLS-1$ //$NON-NLS-2$
		assertNotSame(of.createObject("ant"), ant); //$NON-NLS-1$
	}

	@Test
	public void testNotSupported() {
		ArrayList<Object> olist = new ArrayList<>();
		olist.add(new Object("ant", "chaotic")); //$NON-NLS-1$ //$NON-NLS-2$
		ObjectFactory of = new ObjectFactory(olist);
		
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Object type is not supported"); //$NON-NLS-1$
		
		of.createObject("bee"); //$NON-NLS-1$
	}
}
