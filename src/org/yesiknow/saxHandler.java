package org.yesiknow;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class saxHandler extends DefaultHandler {

	basicItemInfo infoItem = null;
	itemInfoList infoList = null;
	final int BII_ID = 1;
	final int BII_NAME = 2;
	final int BII_CONSUME = 3;
	final int BII_RATE = 4;
	final int BII_TASTE = 5;
	final int BII_ENV = 6;
	final int BII_SERV = 7;
	final int BII_LAT = 8;
	final int BII_LNG = 9;
	final int BII_ADDRESS = 10;
	final int BII_ITEMCLASS = 11;
	final int BII_TEL = 12;
	final int BII_FEATURE = 14;
	final int BII_DISH = 16;
	final int IIL_TITLE = 17;
	final int IIL_COUNT = 18;
	int currentstate = 0;
	int features_number = 0;
	int dishes_number = 0;

	public saxHandler() {
	}

	public itemInfoList get_infoList() {

		return this.infoList;
	}

	@Override
	public void startDocument() throws SAXException {

		infoList = new itemInfoList();
		Log.i("info", "itemInfoList instance");
	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (localName.equals("infoList")) {
			currentstate = 0;
			Log.i("info", "INFOLIST");
			return;
		}
		if (localName.equals("title")) {
			currentstate = IIL_TITLE;
			Log.i("info", "TITLE");
			return;
		}
		if (localName.equals("count")) {
			currentstate = IIL_COUNT;
			return;
		}
		if (localName.equals("item")) {
			infoItem = new basicItemInfo();
			return;
		}
		if (localName.equals("id")) {
			currentstate = BII_ID;
			return;
		}
		if (localName.equals("name")) {
			currentstate = BII_NAME;
			return;
		}
		if (localName.equals("consume")) {
			currentstate = BII_CONSUME;
			return;
		}
		if (localName.equals("rate")) {
			currentstate = BII_RATE;
			return;
		}
		if (localName.equals("taste")) {
			currentstate = BII_TASTE;
			return;
		}
		if (localName.equals("env")) {
			currentstate = BII_ENV;
			return;
		}
		if (localName.equals("serv")) {
			currentstate = BII_SERV;
			return;
		}
		if (localName.equals("lat")) {
			currentstate = BII_LAT;
			return;
		}
		if (localName.equals("lng")) {
			currentstate = BII_LNG;
			return;
		}
		if (localName.equals("address")) {
			currentstate = BII_ADDRESS;
			return;
		}
		if (localName.equals("itemclass")) {
			currentstate = BII_ITEMCLASS;
			return;
		}
		if (localName.equals("tel")) {
			currentstate = BII_TEL;
			return;
		}
		if (localName.equals("feature")) {
			currentstate = BII_FEATURE;
			return;
		}
		if (localName.equals("dish")) {
			currentstate = BII_DISH;
			return;
		}
		currentstate = 0;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (localName.equals("item")) {
			infoList.addItem(infoItem);
			return;
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {

		String theString = new String(ch, start, length);
		switch (currentstate) {
		case IIL_TITLE:
			infoList.set_title(theString);
			currentstate = 0;
			break;
		case IIL_COUNT:
			//infoList.set_count(Integer.parseInt(theString));
			currentstate = 0;
			break;
		case BII_ID:
			infoItem.set_ID(theString);
			currentstate = 0;
			break;
		case BII_NAME:
			infoItem.set_itemName(theString);
			currentstate = 0;
			break;
		case BII_CONSUME:
			infoItem.set_consume(theString);
			currentstate = 0;
			break;
		case BII_RATE:
			infoItem.set_rate(theString);
			currentstate = 0;
			break;
		case BII_TASTE:
			infoItem.set_taste(theString);
			currentstate = 0;
			break;
		case BII_ENV:
			infoItem.set_env(theString);
			currentstate = 0;
			break;
		case BII_SERV:
			infoItem.set_serv(theString);
			currentstate = 0;
			break;
		case BII_LAT:
			infoItem.set_lat(Double.parseDouble(theString));
			currentstate = 0;
			break;
		case BII_LNG:
			infoItem.set_lng(Double.parseDouble(theString));
			currentstate = 0;
			break;
		case BII_ADDRESS:
			infoItem.set_address(theString);
			currentstate = 0;
			break;
		case BII_ITEMCLASS:
			infoItem.set_itemClass(theString);
			currentstate = 0;
			break;
		case BII_TEL:
			infoItem.set_tel(theString);
			currentstate = 0;
			break;
		case BII_FEATURE:

			infoItem.add_feature(theString);

			currentstate = 0;
			break;
		case BII_DISH:
			
				infoItem.add_dish(theString);

			currentstate = 0;
			break;

		default:
			return;
		}
	}

}