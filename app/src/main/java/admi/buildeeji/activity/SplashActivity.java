package admi.buildeeji.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import admi.buildeeji.R;
import admi.buildeeji.Util;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String status = sharedPreferences.getString(Util.LOGIN_STATUS_KEY, "");
                if (status.equals(Util.LOGIN_STATUS)) {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashActivity.this, FirstActivity.class);
                    startActivity(intent);
                }
                SplashActivity.this.finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
