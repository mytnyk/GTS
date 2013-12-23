package mytnyk.gts.kernel.xml;

import java.util.ArrayList;
import java.util.Hashtable;

import org.xmlpull.v1.XmlPullParser;

public class XmlReader {

	public void Read(Hashtable<String, String> map) {
	
	}
	
	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
		ArrayList<product> products = null;
        int eventType = parser.getEventType();
        Product currentProduct = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                	products = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name == "product"){
                        currentProduct = new Product();
                    } else if (currentProduct != null){
                        if (name == "productname"){
                            currentProduct.name = parser.nextText();
                        } else if (name == "productcolor"){
                        	currentProduct.color = parser.nextText();
                        } else if (name == "productquantity"){
                            currentProduct.quantity= parser.nextText();
                        }  
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("product") && currentProduct != null){
                    	products.add(currentProduct);
                    } 
            }
            eventType = parser.next();
        }
}
