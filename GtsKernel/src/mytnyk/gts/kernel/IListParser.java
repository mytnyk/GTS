package mytnyk.gts.kernel;

import java.io.InputStream;

public interface IListParser {
	void parse(InputStream is, IListOfObjects list);
}
