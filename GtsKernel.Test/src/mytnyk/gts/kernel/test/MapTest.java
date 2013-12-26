package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import mytnyk.gts.kernel.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
	@Test
	public void test() {
		String str = 	"5 3\n" +
						"0 0 0 1 1\n" +
						"0 1 0 0 0\n" +
						"1 0 0 1 1\n";
		Map map = new Map(new ByteArrayInputStream(str.getBytes()));
		int[][] m = map.getMap();
		int[][] gm = new int[][] { {0, 0, 1}, {0, 1, 0}, {0, 0, 0}, {1, 0, 1}, {1, 0, 1} };
		assertTrue(Arrays.deepEquals(m, gm));
	}
	
	@Test
	public void testInvalidInput() {
		String str = 	"5 2\n" +
						"0 0 0 1 1\n" +
						"0 1 0 0 0\n" +
						"1 0 0 1 1\n";
		
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Failed to parse");
		
		@SuppressWarnings("unused")
		Map map = new Map(new ByteArrayInputStream(str.getBytes()));
	}

}
