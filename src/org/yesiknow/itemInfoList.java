package org.yesiknow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class itemInfoList {

	private String title;
	private int count;
	private List<basicItemInfo> infoList;

	public itemInfoList() {
		infoList = new ArrayList<basicItemInfo>();
	}

	public void addItem(basicItemInfo Item) {
		this.infoList.add(Item);
		this.count += 1;
	}

	public basicItemInfo get_Item(int location) {
		return this.infoList.get(location);
	}

	public List<basicItemInfo> getAllItems() {
		return this.infoList;
	}

	// LISTVIEW load data;
	public List<Map<String, Object>> getAllItemForListView() {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		int size = infoList.size();
		for (int i = 0; i < size; i++) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put(basicItemInfo.ITEMNAME, infoList.get(i).get_itemName());
			item.put(basicItemInfo.ITEMCLASS, infoList.get(i).get_itemClass());
			item.put(basicItemInfo.CONSUME, infoList.get(i).get_consume());
			item.put(basicItemInfo.RATE, infoList.get(i).get_rate());
			item.put(basicItemInfo.ADDRESS, infoList.get(i).get_address());
			item.put(basicItemInfo.TASTE, infoList.get(i).get_taste());
			item.put(basicItemInfo.SERV, infoList.get(i).get_serv());
			item.put(basicItemInfo.ENV, infoList.get(i).get_env());
			data.add(item);
		}
		return data;
	}

	public String get_title() {
		return this.title;
	}

	public void set_title(String title) {
		this.title = title;
	}

	public int get_count() {
		return this.count;
	}

	public void set_count(int count) {
		this.count = count;
	}

	public List<basicItemInfo> get_infoList() {
		return infoList;
	}

	public void set_itemlist(List<basicItemInfo> infolist) {
		this.infoList = infolist;
	}
	public void add_extralist(itemInfoList LIST)
	{
		for(basicItemInfo item : LIST.getAllItems())
			addItem(item);
		
	}
	
}
