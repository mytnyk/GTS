package mytnyk.gts.kernel.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

	@SuppressWarnings("static-method")
	@Test
	public void test() {
		ArrayList<Code> codes = new ArrayList<>();
		Code w = new Code("0", "Water"); //$NON-NLS-1$ //$NON-NLS-2$
		Code s = new Code("1", "Sand"); //$NON-NLS-1$ //$NON-NLS-2$
		codes.add(w);
		codes.add(s);

		String str =	"0 0 0\n" + //$NON-NLS-1$
						"0 1 0\n"; //$NON-NLS-1$
		MapFactory mapGen = new MapFactory(codes);
		Code[][] m = mapGen.getMap(new ByteArrayInputStream(str.getBytes()));

		Code[][] gm = new Code[][] { {w, w}, {s, w}, {w, w} };
		assertTrue(Arrays.deepEquals(m, gm));
	}

	@Test
	public void testInvalidInput() {
		ArrayList<Code> codes = new ArrayList<>();
		codes.add(new Code("0", "Water")); //$NON-NLS-1$ //$NON-NLS-2$
		
		String str =	"0 1\n" + //$NON-NLS-1$
						"0 0\n"; //$NON-NLS-1$

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid code value"); //$NON-NLS-1$

		MapFactory map = new MapFactory(codes);
		map.getMap(new ByteArrayInputStream(str.getBytes()));
	}
	
	@Test
	public void testInvalidInput2() {
		ArrayList<Code> codes = new ArrayList<>();
		codes.add(new Code("0", "Water")); //$NON-NLS-1$ //$NON-NLS-2$
		
		String str =	"0 0\n" + //$NON-NLS-1$
						"0\n"; //$NON-NLS-1$

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Input steam has different number of elements in rows"); //$NON-NLS-1$

		MapFactory map = new MapFactory(codes);
		map.getMap(new ByteArrayInputStream(str.getBytes()));
	}
	
	@Test
	public void testStreamFailure() throws IOException {

		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Failed to parse map input stream"); //$NON-NLS-1$

		try (ByteArrayInputStream is = mock(ByteArrayInputStream.class)) {
			when(new Integer(is.read())).thenReturn(new Integer(0));

			MapFactory map = new MapFactory(new ArrayList<Code>());
			map.getMap(is);
		}

	}

}
