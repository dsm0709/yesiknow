package org.yesiknow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.mapapi.map.PopupClickListener;
import com.baidu.mapapi.map.PopupOverlay;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class MapList extends Activity {
	private MapView mMapView = null;

	/**
	 * 用MapController完成地图控制
	 */
	private MapController mMapController = null;
	private MyOverlay mOverlay = null;
	private PopupOverlay pop = null;
	private TextView popupitemName, popupitemClass, popupitemTaste,
			popupitemServ, popupitemEnv, popupitemConsume, popupitemAddress,
			popupitemRate;
	private View viewCache = null;
	private ImageButton btnList;
	private View popupInfo = null;
	private itemInfoList preparedList = null;
	private basicItemInfo preparedItem = null;
	private myApplication app = null;
	private Intent naviIntent = null;
	private int centerLat, centerLng;
	private TextView mapTitle = null;
	private boolean flagForOnTap;
	private String titleString = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 获取MapManager
		app = (myApplication) this.getApplication();
		if (app.mBMapManager == null) {
			app.mBMapManager = new BMapManager(getApplicationContext());

			app.mBMapManager.init(new myApplication.MyGeneralListener());
		}

		setContentView(R.layout.activity_maplist);

		// 地图参数设定
		mMapView = (MapView) findViewById(R.id.bmapView);
		btnList = (ImageButton) findViewById(R.id.btn_map_back_list);
		mapTitle = (TextView) findViewById(R.id.mapTitle);
		viewCache = getLayoutInflater().inflate(R.layout.map_point_view, null);
		popupInfo = (View) viewCache.findViewById(R.id.listviewinfo);
		popupitemName = (TextView) viewCache.findViewById(R.id.map_itemName);
		popupitemClass = (TextView) viewCache.findViewById(R.id.map_itemClass);
		popupitemTaste = (TextView) viewCache.findViewById(R.id.map_itemTaste);
		popupitemServ = (TextView) viewCache.findViewById(R.id.map_itemServ);
		popupitemEnv = (TextView) viewCache.findViewById(R.id.map_itemEnv);
		popupitemConsume = (TextView) viewCache
				.findViewById(R.id.map_itemConsume);
		popupitemAddress = (TextView) viewCache
				.findViewById(R.id.map_itemAddress);
		popupitemRate = (TextView) viewCache.findViewById(R.id.map_itemRate);
		mMapController = mMapView.getController();
		mMapController.enableClick(true);
		mMapController.setZoom(14);
		mMapView.setBuiltInZoomControls(true);
		// 地图list显示与item重用显示
		naviIntent = getIntent();
		String branch = naviIntent.getStringExtra("DATAFORMAP");
		if (branch.equals("LIST")) {
			//OptimalList与GeneralList重用显示
			if (app.isOptimaList()) {
				preparedList = app.get_optimalList();
				mapTitle.setText("推荐");
				
			} else {
				preparedList = app.get_generalList();
				mapTitle.setText("附近");
			}
			flagForOnTap = true;
			centerLat = (int) (preparedList.get_Item(0).get_lat() * 1E6);
			centerLng = (int) (preparedList.get_Item(0).get_lng() * 1E6);
			initOverlayFromPreparedList();
			
		} else if (branch.equals("ITEM")) {
			preparedItem = app.get_exchangeItem();
			btnList.setVisibility(View.GONE);
			mapTitle.setText(preparedItem.get_itemName());
			flagForOnTap = false;
			centerLat = (int) (preparedItem.get_lat() * 1E6);
			centerLng = (int) (preparedItem.get_lng() * 1E6);
			initOverlayFromDetail();
		}
		// 确定地图中心点
		GeoPoint p = new GeoPoint(centerLat, centerLng);
		mMapController.setCenter(p);
		btnList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

	public void initOverlayFromPreparedList() {

		int[] icon_mark = { R.drawable.icon_marka, R.drawable.icon_markb,
				R.drawable.icon_markc, R.drawable.icon_markd,
				R.drawable.icon_marke, R.drawable.icon_markf,
				R.drawable.icon_markg, R.drawable.icon_markh,
				R.drawable.icon_marki, R.drawable.icon_markj };

		mOverlay = new MyOverlay(getResources().getDrawable(
				R.drawable.icon_marka), mMapView);
		Log.e("get_count", new Integer(preparedList.get_count()).toString());
		for (int i = 0; i < preparedList.get_count() && i < 10; i++) {
			basicItemInfo identity = preparedList.get_Item(i);
			GeoPoint point = new GeoPoint((int) (identity.get_lat() * 1E6),
					(int) (identity.get_lng() * 1E6));
			OverlayItem item = new OverlayItem(point, identity.get_itemName(),
					"");
			// 设置overlay图标，如不设置，则使用创建ItemizedOverlay时的默认图标.
			item.setMarker(getResources().getDrawable(icon_mark[i]));
			mOverlay.addItem(item);
		}
		mMapView.getOverlays().add(mOverlay);
		mMapView.refresh();
		
		PopupClickListener popListener = new PopupClickListener() {
			@Override
			public void onClickedPopup(int index) {
				Intent intent1 = new Intent();
				intent1.setClass(MapList.this, DetailActivity.class);
				pop.hidePop();
				startActivity(intent1);
			}
		};
		pop = new PopupOverlay(mMapView, popListener);
	}

	public void initOverlayFromDetail() {

		mOverlay = new MyOverlay(getResources().getDrawable(
				R.drawable.nav_turn_via_1), mMapView);
		GeoPoint point = new GeoPoint((int) (preparedItem.get_lat() * 1E6),
				(int) (preparedItem.get_lng() * 1E6));
		OverlayItem item = new OverlayItem(point, preparedItem.get_itemName(),
				"");
		mOverlay.addItem(item);
		mMapView.getOverlays().add(mOverlay);
		mMapView.refresh();
		PopupClickListener popListener = new PopupClickListener() 
		{
			@Override
			public void onClickedPopup(int index) {
//				Intent intent1 = new Intent();
//				intent1.setClass(MapList.this, DetailActivity.class);
//				pop.hidePop();
//				startActivity(intent1);
			}
		};
		pop = new PopupOverlay(mMapView, popListener);
	}

	public class MyOverlay extends ItemizedOverlay {

		public MyOverlay(Drawable defaultMarker, MapView mapView) {
			super(defaultMarker, mapView);

		}

		public void setPopupView(basicItemInfo popupitem)
		{
			popupitemName.setText(popupitem.get_itemName());
			popupitemClass.setText(popupitem.get_itemClass());
			popupitemAddress.setText(popupitem.get_address());
			popupitemRate.setText(popupitem.get_rate());
			popupitemTaste.setText(popupitem.get_taste());
			popupitemServ.setText(popupitem.get_taste());
			popupitemEnv.setText(popupitem.get_env());
			popupitemConsume.setText(popupitem.get_consume());
		}
			

		@Override
		public boolean onTap(int index) {
			OverlayItem item = getItem(index);
			basicItemInfo popupItem = null;
			int lat,lng;
			if (flagForOnTap) {
				popupItem= preparedList.get_Item(index);
				app.set_exchangeItem(popupItem);	
				lat = (int)(preparedList.get_Item(index).get_lat() * 1E6); 
				lng = (int)(preparedList.get_Item(index).get_lng() * 1E6);
			}
			else {
				popupItem = preparedItem;
				lat = (int)(preparedItem.get_lat() * 1E6); 
				lng = (int)(preparedItem.get_lng() * 1E6);
			}
			setPopupView(popupItem);
			mMapController.setCenter(new GeoPoint(lat,lng));
			mMapView.refresh();
			pop.showPopup(popupInfo, item.getPoint(), 96);
			return true;
		}

		public boolean onTap(GeoPoint pt, MapView mMapView) {
			if (pop != null) {
				pop.hidePop();
			}
			return false;
		}

	}

}