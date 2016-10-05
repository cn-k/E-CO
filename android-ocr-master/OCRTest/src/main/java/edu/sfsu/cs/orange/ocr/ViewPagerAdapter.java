package edu.sfsu.cs.orange.ocr;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
	final int PAGE_COUNT = 3;
	private String tabtitles[] = new String[] { "Text Search", "Info", "Deseases Search" };
	Context context;

	public ViewPagerAdapter(FragmentManager fm)
	{
		super(fm);
	}

	@Override
	public int getCount()
	{
		return PAGE_COUNT;
	}

	@Override
	public Fragment getItem(int position)
	{
		switch (position)
		{
			case 0:
				FragmentTab1 fragmenttab1 = new FragmentTab1();
				return fragmenttab1;

			case 1:
				FragmentTab2 fragmenttab2 = new FragmentTab2();
				return fragmenttab2;

			case 2:
				FragmentTab3 fragmenttab3 = new FragmentTab3();
				return fragmenttab3;
		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return tabtitles[position];
	}
}
