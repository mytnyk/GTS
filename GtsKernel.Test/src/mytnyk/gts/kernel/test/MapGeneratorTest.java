package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import mytnyk.gts.kernel.Code;
import mytnyk.gts.kernel.MapFactory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

public class MapGeneratorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test() {
		ArrayList<Code> codes = new ArrayList<Code>();
		Code w = new Code("0", "Water");
		Code s = new Code("1", "Sand");
		codes.add(w);
		codes.add(s);

		String str =	"0 0 0\n" +
						"0 1 0\n";
		MapFactory mapGen = new MapFactory(codes);
		Code[][] m = mapGen.generate(new ByteArrayInputStream(str.getBytes()));

		Code[][] gm = new Code[][] { {w, w}, {w, s}, {w, w} };
		assertTrue(Arrays.deepEquals(m, gm));
	}

	@Test
	public void testInvalidInput() {
		ArrayList<Code> codes = new ArrayList<Code>();
		codes.add(new Code("0", "Water"));
		
		String str =	"0 1\n" +
						"0 0\n";

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid code value");

		MapFactory map = new MapFactory(codes);
		map.generate(new ByteArrayInputStream(str.getBytes()));
	}
	
	@Test
	public void testInvalidInput2() {
		ArrayList<Code> codes = new ArrayList<Code>();
		codes.add(new Code("0", "Water"));
		
		String str =	"0 0\n" +
						"0\n";

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Input steam has different number of elements in rows");

		MapFactory map = new MapFactory(codes);
		map.generate(new ByteArrayInputStream(str.getBytes()));
	}
	
	@Test
	public void testStreamFailure() {

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Failed to parse map input stream");

		ByteArrayInputStream is = mock(ByteArrayInputStream.class);
		when(is.read()).thenReturn(0);

		MapFactory map = new MapFactory(new ArrayList<Code>());
		map.generate(is);
	}

}
