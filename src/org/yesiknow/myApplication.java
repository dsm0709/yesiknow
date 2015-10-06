package org.yesiknow;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;

public class myApplication extends Application{
	
	private itemInfoList generalList,optimalList;
	private basicItemInfo exchangeItem;
	public int per_sweet = 2;
	public int per_sour = 1;
	public int per_date = 0;
	public int per_spicy = 5;
	public int per_salty = 3;
	public int per_consume = 32;
	public double per_lat = 34.2291379539;
	public double per_lng = 108.953112203;
	public int opt_order = 0;
	public int ner_order = 0;
	private boolean flag = true;
	private static myApplication mInstance = null;
    public boolean m_bKeyRight = true;
    BMapManager mBMapManager = null;

	public myApplication() {
		// TODO Auto-generated constructor stub
		generalList = null;
		optimalList = null;
		exchangeItem = null;
	}
	
	public void set_optimalList(itemInfoList OL){
		optimalList = OL;
	}
	public itemInfoList get_optimalList() {
		return optimalList;
	}
	public void set_generalList(itemInfoList GL){
		generalList = GL;
	}
	public itemInfoList get_generalList() {
		return generalList;
	}
	public void set_exchangeItem(basicItemInfo EX){
		exchangeItem = EX;
	}
	public basicItemInfo get_exchangeItem() {
		return exchangeItem;
	}
	public boolean isOptimaList(){
		return flag;
	}
	public void set_flag(boolean FLAG)
	{
		this.flag = FLAG;
	}
	
	
	
	
	@Override
    public void onCreate() {
	    super.onCreate();
		mInstance = this;
		initEngineManager(this);
	}
	
	public void initEngineManager(Context context) {
        if (mBMapManager == null) {
            mBMapManager = new BMapManager(context);
        }

        if (!mBMapManager.init(new MyGeneralListener())) {
            Toast.makeText(myApplication.getInstance().getApplicationContext(), 
                    "BMapManager  初始化错误!", Toast.LENGTH_LONG).show();
        }
	}
	
	public static myApplication getInstance() {
		return mInstance;
	}
	
static class MyGeneralListener implements MKGeneralListener {
        
        @Override
        public void onGetNetworkState(int iError) {
//            if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
//                Toast.makeText(myApplication.getInstance().getApplicationContext(), "您的网络出错啦！",
//                    Toast.LENGTH_LONG).show();
//            }
//            else if (iError == MKEvent.ERROR_NETWORK_DATA) {
//                Toast.makeText(myApplication.getInstance().getApplicationContext(), "输入正确的检索条件！",
//                        Toast.LENGTH_LONG).show();
//            }
            // ...
        }

        @Override
        public void onGetPermissionState(int iError) {
        	//非零值表示key验证未通过
//            if (iError != 0) {
//                //授权Key错误：
//                Toast.makeText(myApplication.getInstance().getApplicationContext(), 
//                        "请在 myApplication.java文件输入正确的授权Key,并检查您的网络连接是否正常！error: "+iError, Toast.LENGTH_LONG).show();
//                myApplication.getInstance().m_bKeyRight = false;
//            }
//            else{
//            	myApplication.getInstance().m_bKeyRight = true;
//				Toast.makeText(
//						myApplication.getInstance().getApplicationContext(), 
//                        "key认证成功", Toast.LENGTH_LONG).show();
//            }
        }
    }

}
