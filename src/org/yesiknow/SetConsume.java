package org.yesiknow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;

public class SetConsume extends Activity {
	
	EditText ed;
	ImageButton back;
	myApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setconsume);
		// 初始化控件
		app = (myApplication) getApplication();
		ed = (EditText)findViewById(R.id.sc_setconsume);
		back = (ImageButton)findViewById(R.id.sc_back);
		ed.setInputType(EditorInfo.TYPE_CLASS_PHONE);
		ed.setText(new Integer(app.per_consume).toString());
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.per_consume = new Integer(ed.getText().toString());
				Intent intent  = new Intent();
				intent.setClass(SetConsume.this, PersonalActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
