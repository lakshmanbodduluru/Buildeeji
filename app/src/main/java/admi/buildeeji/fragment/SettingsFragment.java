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
import admi.buildeeji.Util;
import admi.buildeeji.activity.AboutUsActivity;
import admi.buildeeji.activity.ContactUs;
import admi.buildeeji.activity.HelpAndFaq;
import admi.buildeeji.activity.LiveChat;
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
        mContactUs.setOnClickListener(this);
        mFeedBack.setOnClickListener(this);
        mLiveChat.setOnClickListener(this);
        mHelpFAQ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settings_share:
                String shareBody = "Google play store link";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "APP NAME (Open it in Google Play Store to Download the Application)");

                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.settings_rate_us:
                break;
            case R.id.settings_about_us:
                Intent aboutIntent = new Intent(mActivity, AboutUsActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.settings_contact_us:
                Intent contactUs = new Intent(mActivity, ContactUs.class);
                startActivity(contactUs);
                break;
            case R.id.settings_feed_back:
                Bundle bundle = new Bundle();
                bundle.putString(Util.EMAIL_SUBJECT, "FeedBack");
                Intent feedBack = Util.sendEmail("support@voweisin.com", bundle);
                startActivity(feedBack);
                break;
            case R.id.settings_help_faq:
                Intent helpIntent = new Intent(mActivity, HelpAndFaq.class);
                startActivity(helpIntent);
                break;
            case R.id.settings_live_chat:
                Intent settingsIntent = new Intent(mActivity, LiveChat.class);
                startActivity(settingsIntent);
                break;
        }
    }
}
