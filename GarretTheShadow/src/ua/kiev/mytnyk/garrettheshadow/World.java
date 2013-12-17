package ua.kiev.mytnyk.garrettheshadow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
//import android.util.Log;

public class World {

	private int map[][]; // map with codes
	private int w;
	private int h;
	
	private WorldObject worldObj[][]; // world objects on map
	private Square renderObj[][]; // rendering objects on map
	
	private int mHumanX = 0;
	private int mHumanY = 0;
	
	public World(Context context, WorldLevel level) {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(level.getFileName())));
			String line = reader.readLine();
			w = Integer.parseInt(line.split(" ")[0]);
			h = Integer.parseInt(line.split(" ")[1]);
			map = new int[w][h];
			int y = 0;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(" "); //split spaces 
				for (int x = 0; x < temp.length; x++)
					map[x][y] = Integer.parseInt(temp[x]);
				y++;
			}
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Init();
	}
	
	private void Init() {
		renderObj = new Square[w][h];
		worldObj = new WorldObject[w][h];
		for(int x = 0; x < w; x++) {
			for(int y = 0; y < h; y++) {
				renderObj[x][y] = new Square();
				worldObj[x][y] = WorldObject.getByCode(map[x][y]);
				if (worldObj[x][y] == WorldObject.HUMAN) {
					mHumanX = x;
					mHumanY = y;
				}
			}
		}
	}
	
	public int getHumanX() {
		return mHumanX;
	}
	
	public int getHumanY() {
		return mHumanY;
	}
	
	private boolean canMove(int x, int y) {
		return worldObj[x][y] != WorldObject.WALL;
	}
	
	private void move(int dx, int dy) {
		if (canMove(mHumanX + dx, mHumanY + dy)) {
			synchronized(this) {
				worldObj[mHumanX][mHumanY] = WorldObject.ROAD;
				mHumanX += dx;
				mHumanY += dy;
				worldObj[mHumanX][mHumanY] = WorldObject.HUMAN;
				//Log.d("MOVE", "Right");
			}
		}
	}
	
	public void moveLeft() {
		move(+1, 0);
	}
	
	public void moveRight() {
		move(-1, 0);
	}
	
	public void moveUp() {
		move(0, +1);
	}
	
	public void moveDown() {
		move(0, -1);
	}
	
	public synchronized void draw(GL10 gl, ITextureProvider texProvider) {
		//Log.d("DRAW", "Start");
		for(int x = 0; x < w; x++) {
			for(int y = 0; y < h; y++) {
				int ptr = texProvider.getTexturePointer(worldObj[x][y]);
				//gl.glTranslatef(2.f*x, 2.f*y, 0f);
				renderObj[x][y].draw(gl, ptr);
				//gl.glTranslatef(-2.f*x, -2.f*y, 0f);
				gl.glTranslatef(0f, 1.f, 0f);
			}
			gl.glTranslatef(0f, -h*1.f, 0f);
			gl.glTranslatef(1.f, 0f, 0f);
		}
		gl.glTranslatef(-w*1.f, 0f, 0f);
		//Log.d("DRAW", "End");
	}

}