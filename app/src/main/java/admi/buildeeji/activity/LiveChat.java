package admi.buildeeji.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import admi.buildeeji.R;

public class LiveChat extends AppCompatActivity {
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_chat);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Live Chat");
    }
}
