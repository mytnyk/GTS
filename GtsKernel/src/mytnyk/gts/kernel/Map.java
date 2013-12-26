package mytnyk.gts.kernel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {
	final private int map[][];

	public Map(InputStream is) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = reader.readLine();
			int w = Integer.parseInt(line.split(" ")[0]);
			int h = Integer.parseInt(line.split(" ")[1]);
			map = new int[w][h];
			int y = 0;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(" "); //split spaces 
				for (int x = 0; x < temp.length; x++)
					map[x][y] = Integer.parseInt(temp[x]);
				y++;
			}
		}
		catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
			throw new RuntimeException("Failed to parse map input stream!", e);
		}
	}

	public int[][] getMap() {
		return map;
	}
}
