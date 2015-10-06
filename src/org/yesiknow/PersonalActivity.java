package org.yesiknow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalActivity extends Activity {

	private Button btn_ner, btn_opt, btn_per,btn_more;
	private ImageButton btn_back;
	private ImageView star11, star12, star13, star14, star15, star21, star22,
			star23, star24, star25, star31, star32, star33, star34, star35,
			star41, star42, star43, star44, star45,per_male,per_female;
	private myApplication app = null;
	private TextView per_consume;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal);
		app = (myApplication)getApplication();
		btn_ner = (Button) findViewById(R.id.generallist);
		btn_opt = (Button) findViewById(R.id.optimallist);
		btn_per = (Button) findViewById(R.id.personal);
		btn_per.setBackgroundResource(R.drawable.image_button_pressed);
		btn_back = (ImageButton)findViewById(R.id.per_back);
		star11 = (ImageView)findViewById(R.id.per_star1_1);
		star12 = (ImageView)findViewById(R.id.per_star1_2);
		star13 = (ImageView)findViewById(R.id.per_star1_3);
		star14 = (ImageView)findViewById(R.id.per_star1_4);
		star15 = (ImageView)findViewById(R.id.per_star1_5);
		star21 = (ImageView)findViewById(R.id.per_star2_1);
		star22 = (ImageView)findViewById(R.id.per_star2_2);
		star23 = (ImageView)findViewById(R.id.per_star2_3);
		star24 = (ImageView)findViewById(R.id.per_star2_4);
		star25 = (ImageView)findViewById(R.id.per_star2_5);
		star31 = (ImageView)findViewById(R.id.per_star3_1);
		star32 = (ImageView)findViewById(R.id.per_star3_2);
		star33 = (ImageView)findViewById(R.id.per_star3_3);
		star34 = (ImageView)findViewById(R.id.per_star3_4);
		star35 = (ImageView)findViewById(R.id.per_star3_5);
		star41 = (ImageView)findViewById(R.id.per_star4_1);
		star42 = (ImageView)findViewById(R.id.per_star4_2);
		star43 = (ImageView)findViewById(R.id.per_star4_3);
		star44 = (ImageView)findViewById(R.id.per_star4_4);
		star45 = (ImageView)findViewById(R.id.per_star4_5);
		per_male = (ImageView)findViewById(R.id.per_male);
		btn_more = (Button)findViewById(R.id.more);
		per_female = (ImageView)findViewById(R.id.per_female);
		per_consume = (TextView)findViewById(R.id.per_con); 
		per_consume.setText(new Integer(app.per_consume).toString());
		
		btn_more.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PersonalActivity.this, TestActivity.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
			}
		});
		per_consume.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				app.opt_order = 0;
				Intent intent = new Intent();
				intent.setClass(PersonalActivity.this, SetConsume.class);
				startActivity(intent);
				finish();
			}
		});
		per_male.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				per_male.setBackgroundResource(R.drawable.male);
				per_female.setBackgroundResource(R.drawable.female_no);
				
			}
		});
		per_female.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				per_female.setBackgroundResource(R.drawable.female);
				per_male.setBackgroundResource(R.drawable.male_no);
				
			}
		});
		
		star11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star11.setBackgroundResource(R.drawable.fav_star1);
				star12.setBackgroundResource(R.drawable.fav_star_no);
				star13.setBackgroundResource(R.drawable.fav_star_no);
				star14.setBackgroundResource(R.drawable.fav_star_no);
				star15.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sweet = 1;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star12.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star11.setBackgroundResource(R.drawable.fav_star1);
				star12.setBackgroundResource(R.drawable.fav_star1);
				star13.setBackgroundResource(R.drawable.fav_star_no);
				star14.setBackgroundResource(R.drawable.fav_star_no);
				star15.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sweet = 2;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star13.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star11.setBackgroundResource(R.drawable.fav_star1);
				star12.setBackgroundResource(R.drawable.fav_star1);
				star13.setBackgroundResource(R.drawable.fav_star1);
				star14.setBackgroundResource(R.drawable.fav_star_no);
				star15.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sweet = 3;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star14.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star11.setBackgroundResource(R.drawable.fav_star1);
				star12.setBackgroundResource(R.drawable.fav_star1);
				star13.setBackgroundResource(R.drawable.fav_star1);
				star14.setBackgroundResource(R.drawable.fav_star1);
				star15.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sweet = 4;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star15.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star11.setBackgroundResource(R.drawable.fav_star1);
				star12.setBackgroundResource(R.drawable.fav_star1);
				star13.setBackgroundResource(R.drawable.fav_star1);
				star14.setBackgroundResource(R.drawable.fav_star1);
				star15.setBackgroundResource(R.drawable.fav_star1);
				app.per_sweet = 5;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star21.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star21.setBackgroundResource(R.drawable.fav_star1);
				star22.setBackgroundResource(R.drawable.fav_star_no);
				star23.setBackgroundResource(R.drawable.fav_star_no);
				star24.setBackgroundResource(R.drawable.fav_star_no);
				star25.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sour = 1;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star22.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star21.setBackgroundResource(R.drawable.fav_star1);
				star22.setBackgroundResource(R.drawable.fav_star1);
				star23.setBackgroundResource(R.drawable.fav_star_no);
				star24.setBackgroundResource(R.drawable.fav_star_no);
				star25.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sour = 2;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star23.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star21.setBackgroundResource(R.drawable.fav_star1);
				star22.setBackgroundResource(R.drawable.fav_star1);
				star23.setBackgroundResource(R.drawable.fav_star1);
				star24.setBackgroundResource(R.drawable.fav_star_no);
				star25.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sour = 3;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star24.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star21.setBackgroundResource(R.drawable.fav_star1);
				star22.setBackgroundResource(R.drawable.fav_star1);
				star23.setBackgroundResource(R.drawable.fav_star1);
				star24.setBackgroundResource(R.drawable.fav_star1);
				star25.setBackgroundResource(R.drawable.fav_star_no);
				app.per_sour = 4;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star25.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star21.setBackgroundResource(R.drawable.fav_star1);
				star22.setBackgroundResource(R.drawable.fav_star1);
				star23.setBackgroundResource(R.drawable.fav_star1);
				star24.setBackgroundResource(R.drawable.fav_star1);
				star25.setBackgroundResource(R.drawable.fav_star1);
				app.per_sour = 5;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star31.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star31.setBackgroundResource(R.drawable.fav_star1);
				star32.setBackgroundResource(R.drawable.fav_star_no);
				star33.setBackgroundResource(R.drawable.fav_star_no);
				star34.setBackgroundResource(R.drawable.fav_star_no);
				star35.setBackgroundResource(R.drawable.fav_star_no);
				app.per_spicy = 1;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star32.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star31.setBackgroundResource(R.drawable.fav_star1);
				star32.setBackgroundResource(R.drawable.fav_star1);
				star33.setBackgroundResource(R.drawable.fav_star_no);
				star34.setBackgroundResource(R.drawable.fav_star_no);
				star35.setBackgroundResource(R.drawable.fav_star_no);
				app.per_spicy = 2;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star33.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star31.setBackgroundResource(R.drawable.fav_star1);
				star32.setBackgroundResource(R.drawable.fav_star1);
				star33.setBackgroundResource(R.drawable.fav_star1);
				star34.setBackgroundResource(R.drawable.fav_star_no);
				star35.setBackgroundResource(R.drawable.fav_star_no);
				app.per_spicy = 3;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star34.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star31.setBackgroundResource(R.drawable.fav_star1);
				star32.setBackgroundResource(R.drawable.fav_star1);
				star33.setBackgroundResource(R.drawable.fav_star1);
				star34.setBackgroundResource(R.drawable.fav_star1);
				star35.setBackgroundResource(R.drawable.fav_star_no);
				app.per_spicy = 4;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star35.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star31.setBackgroundResource(R.drawable.fav_star1);
				star32.setBackgroundResource(R.drawable.fav_star1);
				star33.setBackgroundResource(R.drawable.fav_star1);
				star34.setBackgroundResource(R.drawable.fav_star1);
				star35.setBackgroundResource(R.drawable.fav_star1);
				app.per_spicy = 5;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star41.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star41.setBackgroundResource(R.drawable.fav_star1);
				star42.setBackgroundResource(R.drawable.fav_star_no);
				star43.setBackgroundResource(R.drawable.fav_star_no);
				star44.setBackgroundResource(R.drawable.fav_star_no);
				star45.setBackgroundResource(R.drawable.fav_star_no);
				app.per_salty = 1;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star42.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star41.setBackgroundResource(R.drawable.fav_star1);
				star42.setBackgroundResource(R.drawable.fav_star1);
				star43.setBackgroundResource(R.drawable.fav_star_no);
				star44.setBackgroundResource(R.drawable.fav_star_no);
				star45.setBackgroundResource(R.drawable.fav_star_no);
				app.per_salty = 2;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star43.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star41.setBackgroundResource(R.drawable.fav_star1);
				star42.setBackgroundResource(R.drawable.fav_star1);
				star43.setBackgroundResource(R.drawable.fav_star1);
				star44.setBackgroundResource(R.drawable.fav_star_no);
				star45.setBackgroundResource(R.drawable.fav_star_no);
				app.per_salty = 3;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star44.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star41.setBackgroundResource(R.drawable.fav_star1);
				star42.setBackgroundResource(R.drawable.fav_star1);
				star43.setBackgroundResource(R.drawable.fav_star1);
				star44.setBackgroundResource(R.drawable.fav_star1);
				star45.setBackgroundResource(R.drawable.fav_star_no);
				app.per_salty = 4;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		star45.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				star41.setBackgroundResource(R.drawable.fav_star1);
				star42.setBackgroundResource(R.drawable.fav_star1);
				star43.setBackgroundResource(R.drawable.fav_star1);
				star44.setBackgroundResource(R.drawable.fav_star1);
				star45.setBackgroundResource(R.drawable.fav_star1);
				app.per_salty = 5;
				app.opt_order = 0;
				app.ner_order = 0;
			}
		});
		
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PersonalActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);
			}
		});
		
		btn_opt.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PersonalActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);

			}
		});
		btn_ner.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PersonalActivity.this, NearList.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);
			}
		});
	}
}
