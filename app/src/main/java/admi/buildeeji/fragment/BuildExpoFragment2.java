package admi.buildeeji.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.adapter.ViewPagerAdapter;

/**
 * Created by Admin on 8/17/2016.
 */
public class BuildExpoFragment2 extends BuildeejiFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_build_expo2, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {

    }

    private void initViews() {
        viewPager = (ViewPager) mActivity.findViewById(R.id.build_expo_viewpager);
        setUpViewPager(viewPager);
        tabLayout = (TabLayout) mActivity.findViewById(R.id.frag_tabs);
//        viewPager.beginFakeDrag();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), null);
        viewPagerAdapter.addFragment(new BasicBuildExpoFragment(), "BASIC");
        viewPagerAdapter.addFragment(new NormalBuildExpoFragment(), "NORMAL");
        viewPagerAdapter.addFragment(new PremiumBuildExpoFragment(), "PREMIUM");
        viewPagerAdapter.addFragment(new GoldBuildExpoFragment(), "GOLD");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
