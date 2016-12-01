package admi.buildeeji.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.adapter.ViewPagerAdapter;
import admi.buildeeji.fragment.PremiumAdvanceFragment;
import admi.buildeeji.fragment.PremiumBasicFragment;
import admi.buildeeji.fragment.MonthlyPremiumFragment;
import admi.buildeeji.fragment.PremiumYearlyFragment;

public class PremiumPlansActivity extends BuildeejiActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_plans);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {

    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.premium_plans_toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.premium_plans_tabs);
        mViewPager = (ViewPager) findViewById(R.id.premium_plans_viewpager);
        mToolbar.setTitle("Premium Plans");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), BuildExpoResultActivity.class.getSimpleName());
        adapter.addFragment(new PremiumBasicFragment(), "Basic");
        adapter.addFragment(new PremiumAdvanceFragment(), "Advanced");
        adapter.addFragment(new MonthlyPremiumFragment(), "Monthly");
        adapter.addFragment(new PremiumYearlyFragment(), "Yearly");
        viewPager.setAdapter(adapter);
    }
}
