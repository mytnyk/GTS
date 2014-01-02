package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import mytnyk.gts.kernel.ChaoticStrategy;
import mytnyk.gts.kernel.IStrategy;
import mytnyk.gts.kernel.StrategyType;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StrategyTypeTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test() {
		IStrategy st = StrategyType.create("Chaotic"); //$NON-NLS-1$
		assertTrue(st instanceof ChaoticStrategy);
	}
	
	@Test
	public void throwOnWrongStrategy() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Unknown strategy"); //$NON-NLS-1$
		
		StrategyType.create("Does not exist"); //$NON-NLS-1$
	}

}
