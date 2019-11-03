package com.example.finalpro;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int numberOfTabs;
    private Fragment[] childFragments;

    public PageAdapter(FragmentManager fm, int noOfTabs){
        super(fm);
        this.numberOfTabs = noOfTabs;
        childFragments = new Fragment[]{
                new HomeActivityFragment(),
                new AboutActivity(),
                new MahasiswaActivityFragment(),
                new DataMatkulActivityFragment()
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
        String title = null;
        if(position == 0){
            title = "Home";
        }else if(position==1){
            title = "About";
        }else if(position==2){
            title = "Mahasiswa";
        }else if(position==3){
            title = "Matakuliah";
        }
        return title;
    }
}
