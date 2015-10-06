package org.yesiknow;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

	myApplication application;
	basicItemInfo detail;
	ImageButton btnBack,btnMap;
	TextView detailName, detailTaste, detailServ, detailEnv, detailTel,
			detailAddress, detailFeatures, detailDishes,detailConsume,detailClass;
	ImageView detailRate;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		application = (myApplication) getApplication();
		detail = application.get_exchangeItem();
		if(detail == null)
			{	
				detail = new basicItemInfo();
				Toast.makeText(this, "资源加载错误，请返回列表重新加载", Toast.LENGTH_SHORT).show();
			}
		btnBack = (ImageButton)findViewById(R.id.detailback);
		btnMap = (ImageButton)findViewById(R.id.btn_detail_map);
		detailName = (TextView) findViewById(R.id.detailname);
		detailAddress = (TextView) findViewById(R.id.detailaddress);
		detailEnv = (TextView) findViewById(R.id.detailenv);
		detailServ = (TextView) findViewById(R.id.detailserv);
		detailTaste = (TextView) findViewById(R.id.detailtaste);
		detailRate = (ImageView) findViewById(R.id.detailrate);
		detailTel = (TextView) findViewById(R.id.detailtel);
		detailFeatures = (TextView)findViewById(R.id.detailfeatures);
		detailDishes = (TextView)findViewById(R.id.detaildishes);
		detailConsume = (TextView)findViewById(R.id.detailconsume);
		detailClass = (TextView)findViewById(R.id.detailclass);
		detailName.setText(detail.get_itemName());
		detailAddress.setText(detail.get_address());
		detailTel.setText(detail.get_tel());
		detailTaste.setText(detail.get_taste());
		detailServ.setText(detail.get_serv());
		detailEnv.setText(detail.get_env());
		detailClass.setText(detail.get_itemClass());
		detailConsume.setText("¥ "+detail.get_consume());
		detailRate.setBackgroundResource(set_DetailRate());
		detailFeatures.setText(set_DetailFeatures());
		detailDishes.setText(set_DetailDishes());
		
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		btnMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("DATAFORMAP", "ITEM");
				intent.setClass(DetailActivity.this, MapList.class);
				startActivity(intent);
			}
		});

	}

	public int set_DetailRate() {
		String rate = detail.get_rate();
		if (rate.equals("10"))
			return R.drawable.rate_10;
		if (rate.equals("15"))
			return R.drawable.rate_15;
		if (rate.equals("20"))
			return R.drawable.rate_20;
		if (rate.equals("25"))
			return R.drawable.rate_25;
		if (rate.equals("30"))
			return R.drawable.rate_30;
		if (rate.equals("35"))
			return R.drawable.rate_35;
		if (rate.equals("40"))
			return R.drawable.rate_40;
		if (rate.equals("45"))
			return R.drawable.rate_45;
		if (rate.equals("50"))
			return R.drawable.rate_50;
		else
			return R.drawable.rate_40;

	}

	public String set_DetailFeatures() {
		List<String> strList = detail.get_features();
		String str = "";
		for (int i = 0; i < strList.size(); i++)
			str += strList.get(i) + "  ";
		return str;
	}

	public String set_DetailDishes() {
		List<String> strList = detail.get_dishes();
		String str = "";
		for (int i = 0; i < strList.size(); i++)
			str += strList.get(i) + "  ";
		return str;
	}
}
