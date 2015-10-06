package org.yesiknow;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class basicItemInfo {

	public static String ITEMNAME = "itemname";
	public static String ITEMCLASS = "itemclass";
	public static String CONSUME = "consume";
	public static String RATE = "rate";
	public static String ADDRESS = "address";
	public static String TASTE = "taste";
	public static String SERV = "serv";
	public static String ENV = "env";
	private String ID;
	private String itemName;// 商品名称
	private String consume;// 消费金额
	private String rate;// 总评分1-5
	private String taste;// 口味评分1-10
	private String env;// 环境评分1-10
	private String serv;// 服务评分1-10
	private double lat;// 纬度
	private double lng;// 经度
	private String address;// 地址
	private String itemClass;// 分类
	private String tel;// 电话
	private List<String> features;// 特点
	private List<String> dishes;// 特色菜
//	private BitmapDrawable pic;// 图片

	public basicItemInfo(String id, String itemname, String consume,
			String rate, String taste, String env, String serv, double lat,
			double lng, String address, String itemclass,
			List<String> features, List<String> dishes, String tel,
			Bitmap bitmap) {

		this.ID = id;
		this.itemName = itemname;
		this.consume = consume;
		this.rate = rate;
		this.taste = taste;
		this.env = env;
		this.serv = serv;
		this.lat = lat;
		this.lng = lng;
		this.address = address;
		this.itemClass = itemclass;
		this.tel = tel;
		this.features = new ArrayList<String>();
		this.features.addAll(features);
		this.dishes = new ArrayList<String>();
		this.dishes.addAll(dishes);
//		this.pic = new BitmapDrawable(bitmap);

	}

	public basicItemInfo() {
		this.ID = this.itemName = this.address = this.itemClass = this.tel = "";
		this.consume = "0";
		this.rate = this.taste = this.env = this.serv = "0.0";
		this.lat = this.lng = 0.0;
		this.features = new ArrayList<String>();
		this.dishes = new ArrayList<String>();
//		this.pic = null;

	}

	public String get_ID() {

		return this.ID;
	}

	public void set_ID(String id) {

		this.ID = id;
	}

	public String get_itemName() {

		return this.itemName;
	}

	public void set_itemName(String itemname) {

		this.itemName = itemname;
	}

	public String get_consume() {

		return this.consume;
	}

	public void set_consume(String consume) {

		this.consume = consume;
	}

	public String get_rate() {

		return this.rate;
	}

	public void set_rate(String rate) {

		this.rate = rate;
	}

	public String get_taste() {

		return this.taste;
	}

	public void set_taste(String taste) {

		this.taste = taste;
	}

	public String get_env() {

		return this.env;
	}

	public void set_env(String env) {

		this.env = env;
	}

	public String get_serv() {

		return this.serv;
	}

	public void set_serv(String serv) {

		this.serv = serv;
	}

	public double get_lat() {

		return this.lat;
	}

	public void set_lat(double lat) {

		this.lat = lat;
	}

	public double get_lng() {

		return this.lng;
	}

	public void set_lng(double lng) {

		this.lng = lng;
	}

	public String get_address() {

		return this.address;
	}

	public void set_address(String address) {

		this.address = address;
	}

	public String get_itemClass() {

		return this.itemClass;
	}

	public void set_itemClass(String itemclass) {

		this.itemClass = itemclass;
	}

	public String get_tel() {

		return this.tel;
	}

	public void set_tel(String tel) {

		this.tel = tel;
	}

	public List<String> get_features() {

		return this.features;
	}

	public void add_feature(String feature) {

		if (this.features == null)
			this.features = new ArrayList<String>();
		this.features.add(feature);
	}

	public List<String> get_dishes() {

		return this.dishes;
	}

	public void add_dish(String dish) {

		if (this.dishes == null)
			this.dishes = new ArrayList<String>();
		this.dishes.add(dish);
	}

//	public Bitmap get_pic() {
//		return this.pic.getBitmap();
//	}
//
//	public void set_pic(Bitmap bitmap) {
//		this.pic = new BitmapDrawable(bitmap);
//	}

	public String getAllAttributesWithText() {
		return this.ID + "\n" + this.itemName + "\n" + this.itemClass + "\n"
				+ this.consume + "\n" + this.rate + "\n" + this.taste + "\n"
				+ this.env + "\n" + this.serv + "\n" + this.address + "\n"
				+ this.tel + "\n" + this.lat + "\n" + this.lng;
	}
}
