package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import org.junit.Test;

import mytnyk.gts.kernel.Object;

public class ObjectTest {

	@SuppressWarnings("static-method")
	@Test
	public void testObject() {
		String type = "obj type"; //$NON-NLS-1$
		String behaviur = "obj behavior"; //$NON-NLS-1$
		float speed = 10.f;
		String terrain = "highway"; //$NON-NLS-1$
		String take = "key"; //$NON-NLS-1$
		String kill = "alien"; //$NON-NLS-1$
		Object obj = new Object(type, behaviur);
		obj.setSpeed(speed);
		obj.addTerrain(terrain);
		obj.addTake(take);
		obj.addKill(kill);
		
		assertEquals(type, obj.getType());
		assertEquals(behaviur, obj.getBehavior());
		assertTrue(speed == obj.getSpeed());
		assertTrue(obj.hasTerrain(terrain));
		assertTrue(obj.canKill(kill));
		assertTrue(obj.canTake(take));

		assertFalse(obj.canTake(kill));
	}
	
	@SuppressWarnings("static-method")
	@Test
	public void whatDefaultSpeed() {
		Object obj = new Object("obj type", "obj behavior"); //$NON-NLS-1$ //$NON-NLS-2$

		assertTrue(0 == obj.getSpeed());
	}
	
	@SuppressWarnings("static-method")
	@Test
	public void testCopy() {
		Object obj = new Object("obj type", "obj behavior"); //$NON-NLS-1$ //$NON-NLS-2$
		obj.addTake("key"); //$NON-NLS-1$

		Object obj2 = new Object(obj);

		obj.addKill("victim"); //$NON-NLS-1$
		obj.setSpeed(5.f);

		assertEquals(obj.getBehavior(), obj2.getBehavior());
		assertTrue(obj2.canTake("key")); //$NON-NLS-1$
		assertFalse(obj2.canKill("victim")); //$NON-NLS-1$
		assertTrue(0 == obj2.getSpeed());
	}

}
