package mytnyk.gts.kernel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MapFactory {
	final private ArrayList<Code> mCodes;

	public MapFactory(ArrayList<Code> codes) {
		mCodes = codes;
	}

	private Code getCodeByValue(String value) {
		for (Code c : mCodes) {
			if (c.getValue().equalsIgnoreCase(value))
				return c;
		}
		throw new RuntimeException("Invalid code value!");
	}

	private ArrayList<String[]> getCodeValues(InputStream is) {

		ArrayList<String[]> codeValues = new ArrayList<String[]>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;

			while ((line = reader.readLine()) != null)
				codeValues.add(line.split(" "));
		}
		catch (IOException e) {
			throw new RuntimeException("Failed to parse map input stream!", e);
		}
		return codeValues;
	}
	
	public Code[][] generate(InputStream is) {

		ArrayList<String[]> codeValues = getCodeValues(is);

		int h = codeValues.size();
		int w = codeValues.get(0).length;

		Code[][] map = new Code[w][h];
		for (int y = 0; y < h; y++) {
			String[] row = codeValues.get(y);
			if (row.length != w)
				throw new RuntimeException("Input steam has different number of elements in rows!");
			for (int x = 0; x < w; x++)
				map[x][y] = getCodeByValue(row[x]);
		}

		return map;
	}
}
