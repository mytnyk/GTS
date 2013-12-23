package mytnyk.gts.kernel.xml;

import java.util.Hashtable;
import java.util.Stack;

import mytnyk.gts.kernel.IListOfObjects;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlListHandler extends DefaultHandler {

	private Hashtable<String, String> mProperties = new Hashtable<String, String>();
	private IListOfObjects mTargetList;

	private Stack<String> mTags = new Stack<String>();

	public XmlListHandler(IListOfObjects targetList) {
		mTargetList = targetList;
	}

	@Override  
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		mTags.push(qName);

		if (qName.equalsIgnoreCase(mTargetList.getObjectTag()))
			mProperties.clear();
	}

	@Override    
	public void endElement(String uri, String localName, String qName) throws SAXException {
		mTags.pop();

		if (qName.equalsIgnoreCase(mTargetList.getObjectTag()))
			mTargetList.add(mProperties);
	}

	@Override    
	public void characters(char ch[], int start, int length) throws SAXException {
		String value = new String(ch, start, length).trim();
		mProperties.put(mTags.peek(), value);
	}
}
