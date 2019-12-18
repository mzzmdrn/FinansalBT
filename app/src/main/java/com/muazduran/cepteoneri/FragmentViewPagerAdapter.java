package com.muazduran.cepteoneri;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> firstFragment = new ArrayList<>();
    private final List<String> firstTitles = new ArrayList<>();


    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) firstFragment.get(position);
    }

    @Override
    public int getCount() {
        return firstTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return firstTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title){

        firstFragment.add(fragment);
        firstTitles.add(title);
    }
}
