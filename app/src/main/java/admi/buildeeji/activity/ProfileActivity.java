package admi.buildeeji.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;

public class ProfileActivity extends BuildeejiActivity implements View.OnClickListener {
    ActionBar mActionBar;
    TextView mViewedAccount;
    TextView mAddAccount;
    TextView mChangeAccount;
    TextView mSignoutAccount;
    TextView mDeleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Profile");
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        mViewedAccount.setOnClickListener(this);
        mAddAccount.setOnClickListener(this);
        mDeleteAccount.setOnClickListener(this);
        mChangeAccount.setOnClickListener(this);
        mSignoutAccount.setOnClickListener(this);
    }

    private void initViews() {
        mViewedAccount = (TextView) findViewById(R.id.profile_view_account_tv);
        mAddAccount = (TextView) findViewById(R.id.profile_add_account_tv);
        mChangeAccount = (TextView) findViewById(R.id.profile_change_account_tv);
        mSignoutAccount = (TextView) findViewById(R.id.profile_sign_out_account_tv);
        mDeleteAccount = (TextView) findViewById(R.id.profile_delete_account_tv);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_view_account_tv:
                Toast.makeText(ProfileActivity.this, "View Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile_add_account_tv:
                Toast.makeText(ProfileActivity.this, "Add Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile_change_account_tv:
                Toast.makeText(ProfileActivity.this, "Change Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile_sign_out_account_tv:
                Intent logoutIntent = new Intent(ProfileActivity.this, LoginActivity.class);
                ProfileActivity.this.finish();
                startActivity(logoutIntent);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                break;
            case R.id.profile_delete_account_tv:
                Toast.makeText(ProfileActivity.this, "Delete Account", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
