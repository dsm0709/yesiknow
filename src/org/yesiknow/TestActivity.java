package org.yesiknow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TestActivity extends Activity {

	ImageButton back;
	Button moring, noon, night, loc1, loc2, loc3;
	myApplication app;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		// 初始化控件
		app = (myApplication) getApplication();
		back = (ImageButton) findViewById(R.id.test_back);
		moring = (Button) findViewById(R.id.test_morning);
		noon = (Button) findViewById(R.id.test_noon);
		night = (Button) findViewById(R.id.test_night);
		loc1 = (Button) findViewById(R.id.test_loc1);
		loc2 = (Button) findViewById(R.id.test_loc2);
		loc3 = (Button) findViewById(R.id.test_loc3);
		intent = new Intent();
		intent.setClass(TestActivity.this, MainActivity.class);
		
		moring.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.per_date = 7;
				Toast.makeText(TestActivity.this, "时间已设置为早上7点", Toast.LENGTH_SHORT).show();
				startActivity(intent);
				finish();
			}
		});
		noon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.per_date = 12;
				Toast.makeText(TestActivity.this, "时间已设置为中午12点", Toast.LENGTH_SHORT).show();
				startActivity(intent);
				finish();
			}
		});
		night.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.per_date = 22;
				Toast.makeText(TestActivity.this, "时间已设置为晚上22点", Toast.LENGTH_SHORT).show();
				startActivity(intent);
				finish();
			}
		});
		loc1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.per_lat = 34.265657;
				app.per_lng = 108.954142;
				Toast.makeText(TestActivity.this, "地点已设置为钟楼", Toast.LENGTH_SHORT).show();
				startActivity(intent);
				finish();
			}
		});
		loc2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.per_lat = 34.229055;
				app.per_lng = 108.953196;
				Toast.makeText(TestActivity.this, "地点已设置为小寨", Toast.LENGTH_SHORT).show();
				startActivity(intent);
				finish();
			}
		});
		loc3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.per_lat = 34.235651;
				app.per_lng = 108.923036;
				Toast.makeText(TestActivity.this, "地点已设置为西电老校区", Toast.LENGTH_SHORT).show();
				startActivity(intent);
				finish();
			}
		});

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				startActivity(intent);
				finish();
			}
		});
	}
}
