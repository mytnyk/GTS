package ua.kiev.mytnyk.garrettheshadow;

public class Human extends Object {

	protected Human(ObjectType type) {
		super(type);
	}

	@Override
	public Texture getTexture() {
		return Texture.HUMAN;
	}

}
