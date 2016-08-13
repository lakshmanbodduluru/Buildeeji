package admi.buildeeji.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.listeners.AboutUsListener;
import admi.buildeeji.listeners.ClickListener;

/**
 * Created by Admin on 8/13/2016.
 */
public class AboutUsFragment extends BuildeejiFragment implements View.OnClickListener {
    ActionBar actionBar;
    CardView mTermsConditions;
    CardView mPrivacyPolicy;
    CardView mLegal;
    TextView aboutUsEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
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

    private void initViews() {
        mTermsConditions = (CardView) mActivity.findViewById(R.id.about_us_terms_conditions_card);
        mPrivacyPolicy = (CardView) mActivity.findViewById(R.id.about_us_privacy_policy_card);
        mLegal = (CardView) mActivity.findViewById(R.id.about_us_legal_card);
        aboutUsEmail = (TextView) mActivity.findViewById(R.id.about_us_email);
    }

    private void initListener() {
        mTermsConditions.setOnClickListener(this);
        mPrivacyPolicy.setOnClickListener(this);
        mLegal.setOnClickListener(this);
        aboutUsEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AboutUsListener aboutUsListener = (AboutUsListener) mActivity;
        switch (v.getId()) {
            case R.id.about_us_terms_conditions_card:
                aboutUsListener.openTermsAndConditionsFragment();
                break;
            case R.id.about_us_privacy_policy_card:
                aboutUsListener.openPrivacyPolicyFragment();
                break;
            case R.id.about_us_legal_card:
                aboutUsListener.openLegalFragment();
                break;
            case R.id.about_us_email:
                Intent email = new Intent(Intent.ACTION_VIEW);
                email.setType("plain/text");
                email.setData(Uri.parse("lakshman.bodduluru@gmail.com"));
                email.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@buildeeji.com"});
                email.setType("message/rfc822");
                startActivity(email);
        }
    }
}

