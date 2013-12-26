package mytnyk.gts.kernel.xml;

import java.util.Hashtable;

public interface IListOfObjects {
	String getObjectTag();
	void add(Hashtable<String, String> properties);
}
