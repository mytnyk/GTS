package mytnyk.gts.kernel;

import java.util.ArrayList;

final public class Object {

	final private String mType;
	final private String mBehavior;
	private ArrayList<String> mTerrain;
	private String mSpeed;
	private ArrayList<String> mTake;
	private ArrayList<String> mKill;

	// Deep copy constructor
	public Object(Object obj) {
		mType = obj.mType;
		mBehavior = obj.mBehavior;
		mTerrain = new ArrayList<>(obj.mTerrain);
		mSpeed = obj.mSpeed;
		mTake = new ArrayList<>(obj.mTake);
		mKill = new ArrayList<>(obj.mKill);
	}

	public Object(String type, String behavior) {
		mType = type;
		mBehavior = behavior;
		mTerrain = new ArrayList<>();
		mTake = new ArrayList<>();
		mKill = new ArrayList<>();
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

	@Override
	public String toString() {
		return mType;
	}
}
