package com.example.finalpro;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int numberOfTabs;
    private Fragment[] childFragments;

    public PageAdapter(FragmentManager fm, int noOfTabs){
        super(fm);
        this.numberOfTabs = noOfTabs;
        childFragments = new Fragment[]{
                new HomeActivityFragment(),new AboutActivity()
        };
    }


    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position){
        String title;
        if(position == 0){
            title = "Home";
        }else{
            title = "About";
        }
        return title;
    }
}
