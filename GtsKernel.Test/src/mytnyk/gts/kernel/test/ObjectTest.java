package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import org.junit.Test;

import mytnyk.gts.kernel.Object;

public class ObjectTest {

	@Test
	public void testObject() {
		String type = "obj type";
		String behaviur = "obj behavior";
		String speed = "ultrafast";
		String terrain = "highway";
		String take = "key";
		String kill = "alien";
		Object obj = new Object(type, behaviur);
		obj.setSpeed(speed);
		obj.addTerrain(terrain);
		obj.addTake(take);
		obj.addKill(kill);
		
		assertEquals(type, obj.getType());
		assertEquals(behaviur, obj.getBehavior());
		assertEquals(speed, obj.getSpeed());
		assertTrue(obj.hasTerrain(terrain));
		assertTrue(obj.canKill(kill));
		assertTrue(obj.canTake(take));

		assertFalse(obj.canTake(kill));
	}
	
	@Test
	public void whatDefaultSpeed() {
		Object obj = new Object("obj type", "obj behavior");

		assertNull(obj.getSpeed());
	}
	
	@Test
	public void testCopy() throws CloneNotSupportedException {
		Object obj = new Object("obj type", "obj behavior");
		obj.addTake("key");

		Object obj2 = obj.clone();

		obj.addKill("victim");
		obj.setSpeed("fast");

		assertEquals(obj.getBehavior(), obj2.getBehavior());
		assertTrue(obj2.canTake("key"));
		assertFalse(obj2.canKill("victim"));
		assertNull(obj2.getSpeed());
	}

}
