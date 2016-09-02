package admi.buildeeji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.activity.PremiumPlansActivity;
import admi.buildeeji.activity.ProfileActivity;

/**
 * Created by Admin on 8/29/2016.
 */
public class AccountSettingsFragment extends BuildeejiFragment implements View.OnClickListener {
    TextView mUpgradePremiumTv;
    TextView mProfileTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_settings, container, false);
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
        mUpgradePremiumTv.setOnClickListener(this);
        mProfileTv.setOnClickListener(this);
    }

    private void initViews() {
        mUpgradePremiumTv = (TextView) mActivity.findViewById(R.id.account_upgrade_premium_tv);
        mProfileTv = (TextView) mActivity.findViewById(R.id.profile_settings_tv);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.account_upgrade_premium_tv:
                Intent premiumPlansIntent = new Intent(mActivity, PremiumPlansActivity.class);
//                premiumPlansIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(premiumPlansIntent);
//                Toast.makeText(mActivity, "/////////", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile_settings_tv:
                Intent profileIntent = new Intent(mActivity, ProfileActivity.class);
//                profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profileIntent);
                break;
        }
    }
}
