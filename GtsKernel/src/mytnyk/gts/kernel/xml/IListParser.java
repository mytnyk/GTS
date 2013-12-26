package mytnyk.gts.kernel.xml;

import java.io.InputStream;

public interface IListParser {
	void parse(InputStream is, IListOfObjects list);
}
