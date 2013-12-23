package mytnyk.gts.kernel;

import java.util.Hashtable;

public interface IListOfObjects {
	String getObjectTag();
	void add(Hashtable<String, String> properties);
}
