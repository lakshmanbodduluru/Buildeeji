package admi.buildeeji.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;

public class ProfileActivity extends BuildeejiActivity {
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Profile");
    }
}
