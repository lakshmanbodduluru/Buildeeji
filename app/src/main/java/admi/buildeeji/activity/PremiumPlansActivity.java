package admi.buildeeji.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.adapter.ViewPagerAdapter;
import admi.buildeeji.fragment.AdvanceFragmentPremium;
import admi.buildeeji.fragment.BasicPremiumFragment;
import admi.buildeeji.fragment.MonthlyPremiumFragment;
import admi.buildeeji.fragment.ResultContactFragment;
import admi.buildeeji.fragment.ResultHomeFragment;
import admi.buildeeji.fragment.ResultImageFragment;
import admi.buildeeji.fragment.ResultVideoFragment;
import admi.buildeeji.fragment.YearlyPremiumFragment;

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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), ResultActivity.class.getSimpleName());
        adapter.addFragment(new BasicPremiumFragment(), "Basic");
        adapter.addFragment(new AdvanceFragmentPremium(), "Advanced");
        adapter.addFragment(new MonthlyPremiumFragment(), "Monthly");
        adapter.addFragment(new YearlyPremiumFragment(), "Yearly");
        viewPager.setAdapter(adapter);
    }
}
