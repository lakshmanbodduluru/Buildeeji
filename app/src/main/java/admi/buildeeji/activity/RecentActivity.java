package admi.buildeeji.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.adapter.ViewPagerAdapter;
import admi.buildeeji.fragment.RecentContactedPropertiesFragment;
import admi.buildeeji.fragment.RecentProjectsViewed;
import admi.buildeeji.fragment.RecentPropertiesViewed;
import admi.buildeeji.fragment.RecentSearchFragment;

public class RecentActivity extends BuildeejiActivity  {
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private android.app.ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==0){
                    mToolbar.setTitle("Searches");
                }
                else if(position==1){
                    mToolbar.setTitle("Contacted Properties");
                }
                else if(position==2){
                    mToolbar.setTitle("Properties Viewed");
                }
                else if(position==3){
                    mToolbar.setTitle("Contacted Projects");
                }
                else if(position==4){
                    mToolbar.setTitle("Projects Viewed");
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.recent_toolbar);
        mActionBar = getActionBar();
        mViewPager = (ViewPager) findViewById(R.id.recent_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.recent_tabs);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), RecentActivity.class.getSimpleName());
        adapter.addFragment(new RecentSearchFragment(), "Searches");
        adapter.addFragment(new RecentContactedPropertiesFragment(), "Contacted Properties");
        adapter.addFragment(new RecentPropertiesViewed(), "Properties Viewed");
        adapter.addFragment(new RecentContactedPropertiesFragment(), "Contacted Projects");
        adapter.addFragment(new RecentProjectsViewed(), "Projects Viewed");
        viewPager.setAdapter(adapter);
    }

}
