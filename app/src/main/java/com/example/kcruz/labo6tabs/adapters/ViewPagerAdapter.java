package com.example.kcruz.labo6tabs.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.kcruz.labo6tabs.fragments.FavoritesFragment;
import com.example.kcruz.labo6tabs.fragments.RestaurantsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    //private final List<Fragment> frList = new ArrayList<>();
    //private final  List<String> frTitles = new ArrayList<>();
    //private FragmentManager fragmentManager;
   // private final Map<Integer, String> frTags;



    int NumberOfTabs;

    public ViewPagerAdapter (FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.NumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: RestaurantsFragment tab1 = new RestaurantsFragment(); return tab1;
            case 1: FavoritesFragment tab2 = new FavoritesFragment(); return tab2;
            default: return null;
        }
    }

    @Override
    public int getCount() { //envia el numero de tabs que se tiene
        return NumberOfTabs;
    }

    /*public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentManager = fm;
        frTags = new HashMap<Integer, String>();
    }

    @Override
    public Fragment getItem(int position) {
        return frList.get(position);
    }

    @Override
    public int getCount() {
        return frTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return frTitles.get(position);
    }

    public void addFragment(Fragment f, String title){
        frList.add(f);
        frTitles.add(title);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object obj = super.instantiateItem(container, position);
        if(obj instanceof Fragment){
            Fragment f = (Fragment) obj;
            frTags.put(position, f.getTag());
        }
        return obj;
    }


    public Fragment getFragment(int position){
        String tag = frTags.get(position);
        if(tag == null) return  null;
        return fragmentManager.findFragmentByTag(tag);
    }*/
}
