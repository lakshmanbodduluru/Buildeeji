package admi.buildeeji.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.Util;
import admi.buildeeji.adapter.ViewPagerAdapter;
import admi.buildeeji.fragment.ResultContactFragment;
import admi.buildeeji.fragment.ResultHomeFragment;
import admi.buildeeji.fragment.ResultImageFragment;
import admi.buildeeji.fragment.ResultVideoFragment;

public class ResultActivity extends BuildeejiActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String toolBarName ="";
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {

    }

    private void initViews() {
        bundle = getIntent().getExtras();
        toolBarName = bundle.getString(Util.RESULT_COMPANY_NAME);
        toolbar = (Toolbar) findViewById(R.id.result_toolbar);
        toolbar.setTitle(toolBarName);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.result_viewpager);
        setUpViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.result_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), ResultActivity.class.getSimpleName());
        adapter.addFragment(new ResultHomeFragment(bundle), "HOME");
        adapter.addFragment(new ResultVideoFragment(), "VIDEO");
        adapter.addFragment(new ResultImageFragment(), "IMAGE");
        adapter.addFragment(new ResultContactFragment(), "CONTACT");
        viewPager.setAdapter(adapter);
    }


}
