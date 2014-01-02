package mytnyk.gts.kernel.test;

import mytnyk.gts.kernel.Direction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DirectionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testIllegalCode() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal direction code"); //$NON-NLS-1$
		
		Direction.get(5);
	}

}
