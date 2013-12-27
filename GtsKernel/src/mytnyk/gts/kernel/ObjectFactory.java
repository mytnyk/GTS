package mytnyk.gts.kernel;

import java.util.ArrayList;

public class ObjectFactory {

	private final ArrayList<Object> mList;
	public ObjectFactory(ArrayList<Object> list) {
		mList = list;
	}

	public Object createObject(String type) {
		for (Object t : mList)
			if (t.getType().equalsIgnoreCase(type))
				return new Object(t);
		throw new RuntimeException("Object type is not supported!"); //$NON-NLS-1$
	}
}
