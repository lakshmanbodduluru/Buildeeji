package admi.buildeeji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.activity.AboutUsActivity;
import admi.buildeeji.adapter.SettingsAdapter;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.Settings;

/**
 * Created by Lakshman Bodduluru on 7/18/2016.
 */
public class SettingsFragment extends BuildeejiFragment implements View.OnClickListener {
    TextView mShare;
    TextView mRateUs;
    TextView mAboutUs;
    TextView mContactUs;
    TextView mFeedBack;
    TextView mHelpFAQ;
    TextView mLiveChat;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu_settings, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void init() {
        initViews();
        initListener();
    }

    private void initViews() {
        mShare = (TextView) mActivity.findViewById(R.id.settings_share);
        mRateUs = (TextView) mActivity.findViewById(R.id.settings_rate_us);
        mAboutUs = (TextView) mActivity.findViewById(R.id.settings_about_us);
        mContactUs = (TextView) mActivity.findViewById(R.id.settings_contact_us);
        mFeedBack = (TextView) mActivity.findViewById(R.id.settings_feed_back);
        mHelpFAQ = (TextView) mActivity.findViewById(R.id.settings_help_faq);
        mLiveChat = (TextView) mActivity.findViewById(R.id.settings_live_chat);
    }

    private void initListener() {
        mShare.setOnClickListener(this);
        mAboutUs.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settings_share:
                break;
            case R.id.settings_rate_us:
                break;
            case R.id.settings_about_us:
                Intent aboutIntent = new Intent(mActivity, AboutUsActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.settings_contact_us:
                break;
            case R.id.settings_feed_back:
                break;
            case R.id.settings_help_faq:
                break;
            case R.id.settings_live_chat:
                break;
        }
    }
}
