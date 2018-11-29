package com.newwave_preintern.leaverequestemployee.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.newwave_preintern.leaverequestemployee.Fragment.HistoryFragment;
import com.newwave_preintern.leaverequestemployee.Fragment.ProfileFragment;
import com.newwave_preintern.leaverequestemployee.Fragment.RemainLeavesFragment;

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount)
    {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
            {
                RemainLeavesFragment remainLeavesFragment = new RemainLeavesFragment();
                return remainLeavesFragment;
            }

            case 1:
            {
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            }

            case 2:
            {
                HistoryFragment historyFragment = new HistoryFragment();
                return historyFragment;
            }

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
