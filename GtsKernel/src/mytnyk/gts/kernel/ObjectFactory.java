package mytnyk.gts.kernel;

import java.util.ArrayList;

public class ObjectFactory {

	private final ArrayList<Object> mList;
	public ObjectFactory(ArrayList<Object> list) {
		mList = list;
	}

	public Object getObject(String type) {
		for (Object t : mList)
			if (t.getType().equalsIgnoreCase(type))
				try {
					return t.clone();
				} catch (CloneNotSupportedException e) {
					throw new RuntimeException("Implement clone method!", e);
				}
		throw new RuntimeException("Object type is not supported!");
	}
}
