package mytnyk.gts.kernel;

import java.util.ArrayList;

public class Object {

	final private String mType;
	final private String mBehavior;
	private ArrayList<String> mTerrain = new ArrayList<String>();
	private String mSpeed;
	private ArrayList<String> mTake = new ArrayList<String>();
	private ArrayList<String> mKill = new ArrayList<String>();
	
	public Object(String type, String behavior) {
		mType = type;
		mBehavior = behavior;
	}

	public String getType() {
		return mType;
	}

	public String getBehavior() {
		return mBehavior;
	}

	public String getSpeed() {
		return mSpeed;
	}

	public void setSpeed(String speed) {
		mSpeed = speed;
	}

	public boolean hasTerrain(String terrain) {
		return mTerrain.contains(terrain);
	}

	public void addTerrain(String terrain) {
		mTerrain.add(terrain);
	}
	
	public boolean canTake(String obj) {
		return mTake.contains(obj);
	}

	public void addTake(String obj) {
		mTake.add(obj);
	}
	
	public boolean canKill(String obj) {
		return mKill.contains(obj);
	}

	public void addKill(String obj) {
		mKill.add(obj);
	}
	
}
