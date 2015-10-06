package org.yesiknow;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.util.EncodingUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.yesiknow.customview.RefreshableView;
import org.yesiknow.customview.RefreshableView.PullToRefreshListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class NearList extends Activity {

	public itemInfoList infoList;
	SAXParserFactory factory = null;
	SAXParser parser = null;
	XMLReader reader = null;
	saxHandler handler = null;
	private ListView listView;
	private TextView title;
	String url, params, response;
	myApplication app;
	Date   curDate = null;
	String date = null;
	private ImageButton btn_map;
	SimpleDateFormat sdf = null;
	private Button btn_ner, btn_opt, btn_per,btn_more;
	private RefreshableView refreshableView;
	private boolean i = true;
	Handler refreshHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0x111) {
				try {
					// refreshDataFromAssets();
					refreshDataFromNet();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log.e("infoListError",
							"Exception: " + Log.getStackTraceString(e));
				}

			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 初始化控件
		app = (myApplication) getApplication();
		curDate = new Date();
		sdf=new SimpleDateFormat("HH");  
		date=sdf.format(new java.util.Date());  
		listView = (ListView) findViewById(R.id.listview1);
		title = (TextView) findViewById(R.id.mainbar_title);
		btn_map = (ImageButton) findViewById(R.id.btn_map);
		btn_ner = (Button) findViewById(R.id.generallist);
		btn_opt = (Button) findViewById(R.id.optimallist);
		btn_per = (Button) findViewById(R.id.personal);
		btn_more = (Button)findViewById(R.id.more);
		btn_ner.setBackgroundResource(R.drawable.image_button_pressed);
		refreshableView = (RefreshableView) findViewById(R.id.refreshableview);
		title.setText("附近");

		// 初始化xml解析器
		initSAXhandler();
		refreshDataFromNet();

		// 定义控件动作事件

		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(2000);
					refreshHandler.sendEmptyMessage(0x111);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshableView.finishRefreshing();
			}
		}, 0);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				app.set_exchangeItem(app.get_generalList().get_Item(position));
				Intent intent = new Intent();
				intent.setClass(NearList.this, DetailActivity.class);
				startActivity(intent);

			}
		});
		btn_map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (app.get_generalList() != null) {
					app.set_flag(true);
					Intent intent = new Intent();
					intent.putExtra("DATAFORMAP", "LIST");
					intent.setClass(NearList.this, MapList.class);
					startActivity(intent);
				}
			}
		});
		btn_opt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(NearList.this, MainActivity.class);
				finish();
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);

			}
		});
		btn_per.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(NearList.this, PersonalActivity.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
			}
		});
		btn_more.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(NearList.this, TestActivity.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
			}
		});
	}



	public void refreshDataFromNet() {

		
		url = "192.168.2.1:5000/loc/";
		params = "lat=" + app.per_lat + "&lng=" + app.per_lng + "&order=" + app.ner_order + "&time="+ date;
		app.ner_order += 1;
		final Handler getHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x123) {
					try {
						infoList = getInfoList();
						app.set_generalList(infoList);
						showList();

					} catch (Exception e) {
					}

				}
			}
		};
//		Toast.makeText(NearList.this, "http://" + url + "?" + params,
//				Toast.LENGTH_LONG).show();
		new Thread() {
			@Override
			public void run() {
				response = GetPostUtil.sendGet("http://" + url, params);
				getHandler.sendEmptyMessage(0x123);
			}
		}.start();
	}

	public void initSAXhandler() {
		// 初始化xml解析
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			reader = parser.getXMLReader();
			handler = new saxHandler();
			reader.setContentHandler(handler);
		} catch (Exception e) {
		}
	}

	
	public itemInfoList getInfoList() throws IOException, SAXException {
		String str = null;
		// InputStream stream =
		// getResources().getAssets().open(changeRefresh());
		ByteArrayInputStream stream = new ByteArrayInputStream(response.getBytes());
		response.replace("\n", "");
//		Toast.makeText(NearList.this, response,
//		Toast.LENGTH_LONG).show();
		// 获取到的原始数据载入解析
		InputSource is = new InputSource(stream);
		reader.parse(is);
		return handler.get_infoList();

	}


	public void showList() {
		// 将数据绑定在listview上显示
		SimpleAdapter adapter = new SimpleAdapter(this,
				infoList.getAllItemForListView(), R.layout.listviewitem,
				new String[] { basicItemInfo.ITEMNAME, basicItemInfo.ITEMCLASS,
						basicItemInfo.CONSUME, basicItemInfo.RATE,
						basicItemInfo.ADDRESS, basicItemInfo.TASTE,
						basicItemInfo.SERV, basicItemInfo.ENV }, new int[] {
						R.id.itemName, R.id.itemClass, R.id.consume, R.id.rate,
						R.id.address, R.id.taste, R.id.serv, R.id.env });

		listView.setAdapter(adapter);
		

	}

	public String changeRefresh() {

		if (i) {
			i = false;
			return "ol1.xml";
		} else {
			i = true;
			return "ol2.xml";
		}
	}
	public void refreshDataFromAssets() {
		try {
			infoList = getInfoList();
			//infoList.add_extralist(app.get_generalList());
			app.set_generalList(infoList);
			showList();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
