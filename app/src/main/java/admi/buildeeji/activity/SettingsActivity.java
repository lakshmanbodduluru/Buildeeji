package admi.buildeeji.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.adapter.ViewPagerAdapter;
import admi.buildeeji.fragment.AccountSettingsFragment;
import admi.buildeeji.fragment.NotificationsSettingsFragment;
import admi.buildeeji.fragment.ThemSettingsFragment;

public class SettingsActivity extends BuildeejiActivity {
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {

    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.settings_toolbar);
        mViewPager = (ViewPager) findViewById(R.id.settings_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.settings_tabs);
        mToolbar.setTitle("Settings");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), SettingsActivity.class.getSimpleName());
        adapter.addFragment(new AccountSettingsFragment(), "Account");
        adapter.addFragment(new NotificationsSettingsFragment(), "Notifications");
        adapter.addFragment(new ThemSettingsFragment(), "Them");
        viewPager.setAdapter(adapter);
    }
}
