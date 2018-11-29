package com.newwave_preintern.leaverequestemployee.Activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.newwave_preintern.leaverequestemployee.Adapter.Pager;
import com.newwave_preintern.leaverequestemployee.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Tab extends AppCompatActivity {

    @BindView(R.id.tabLayout) TabLayout tabLayout;

    @BindView(R.id.pager) ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_remain_leaves));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_profile));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_calendar));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Pager pager = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                int tabIconColor = ContextCompat.getColor(Tab.this, R.color.colorAccent);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                int tabIconColor = ContextCompat.getColor(Tab.this, R.color.colorTabIcon);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
