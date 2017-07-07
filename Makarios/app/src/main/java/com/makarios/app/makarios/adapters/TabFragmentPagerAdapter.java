package com.makarios.app.makarios.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.makarios.app.makarios.fragments.CollectionsFragment;


public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Collections", "ClientList", "Team" };

    public TabFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CollectionsFragment.newInstance(position + 1);
            case 1:
                return new Fragment();
            case 2:
                return new Fragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
