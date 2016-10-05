package edu.sfsu.cs.orange.ocr;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{

	Locale locale;
	Configuration config;
	DatabaseHelper myDb ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.activity_main);
		myDb = new DatabaseHelper(this);
		//myDb = DatabaseHelper.getInstance(getApplicationContext());
		//myDb.getWritableDatabase();

		// Locate the viewpager in activity_main.xml
		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
		// Set the ViewPagerAdapter into ViewPager
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setLogo(R.drawable.logo);
		getSupportActionBar().setDisplayUseLogoEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		ViewPagerAdapter vp = new ViewPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(vp);
		viewPager.setCurrentItem(1);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.main_activity_bar, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {


		switch (item.getItemId()) {
			case R.id.language_tr:
				LocaleHelper.setLocale(this, "tr");
				locale = new Locale("tr");
				Locale.setDefault(locale);
				config = new Configuration();
				config.locale = locale;
				getBaseContext().getResources().updateConfiguration(config,
						getBaseContext().getResources().getDisplayMetrics());
				this.recreate();
				break;
			case R.id.language_en:
				LocaleHelper.setLocale(this, "en");
				locale = new Locale("en");
				Locale.setDefault(locale);
				Configuration config = new Configuration();
				config.locale = locale;
				getBaseContext().getResources().updateConfiguration(config,
						getBaseContext().getResources().getDisplayMetrics());

				this.recreate();
				break;
		}

		return true;
	}

}