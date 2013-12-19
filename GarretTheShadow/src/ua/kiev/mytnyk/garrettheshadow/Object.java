package ua.kiev.mytnyk.garrettheshadow;

public abstract class Object {
	private ObjectType mType; 
	
	protected Object(ObjectType type) {
		mType = type;
	};
	
	public ObjectType getType() {
		return mType;
	}
	public abstract Texture getTexture();
}
