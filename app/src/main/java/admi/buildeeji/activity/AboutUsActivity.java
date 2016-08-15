package admi.buildeeji.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.fragment.AboutUsFragment;
import admi.buildeeji.fragment.LegalFragment;
import admi.buildeeji.fragment.PrivacyPolicyFragment;
import admi.buildeeji.fragment.TermsAndConditionsFragment;
import admi.buildeeji.listeners.AboutUsListener;

public class AboutUsActivity extends BuildeejiActivity implements AboutUsListener {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        actionBar = getSupportActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        openAboutUsFragment();
    }

    @Override
    public void openAboutUsFragment() {
        actionBar.setTitle("About us");
        AboutUsFragment aboutUsFragment = new AboutUsFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.about_us_container_recycle, aboutUsFragment);
        transaction.commit();
    }

    @Override
    public void openTermsAndConditionsFragment() {
        actionBar.setTitle("Terms and Conditions");
        TermsAndConditionsFragment termsAndConditionsFragment = new TermsAndConditionsFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.about_us_container_recycle, termsAndConditionsFragment);
        transaction.commit();
    }

    @Override
    public void openPrivacyPolicyFragment() {
        actionBar.setTitle("Privacy and Policy");
        PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.about_us_container_recycle, privacyPolicyFragment);
        transaction.commit();
    }

    @Override
    public void openLegalFragment() {
        actionBar.setTitle("Legal");
        LegalFragment legalFragment = new LegalFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.about_us_container_recycle, legalFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
