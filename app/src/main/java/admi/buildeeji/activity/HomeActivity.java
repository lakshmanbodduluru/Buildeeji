package admi.buildeeji.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.Util;
import admi.buildeeji.adapter.NavigationAdapter;
import admi.buildeeji.adapter.ViewPagerAdapter;
import admi.buildeeji.bin.NavigationDataProvider;
import admi.buildeeji.fragment.BuildExpoFragment;
import admi.buildeeji.fragment.HomeFragment;
import admi.buildeeji.fragment.HotProjectsFragment;
import admi.buildeeji.fragment.SettingsFragment;
import admi.buildeeji.fragment.NotificationsFragment;
import admi.buildeeji.listeners.ClickListener;

public class HomeActivity extends BuildeejiActivity
        implements NavigationView.OnNavigationItemSelectedListener, ClickListener {

    ExpandableListView expandableListView;
    LinkedHashMap<String, List<String>> navigationCategory;
    List<String> navigationList;
    NavigationAdapter navigationAdapter;
    Toolbar toolbar;
    public boolean mFirstBackPressed;
    TabLayout tabLayout;
    String mActivityName;
    ViewPager homeViewPager;
    private int[] tabIcons = {
            R.drawable.ic_home_white_24dp,
            R.drawable.build_expo,
            R.drawable.hot_projects,
            R.drawable.ic_notifications_none_white_24dp,
            R.drawable.ic_settings_white_24dp,
    };
    private int[] tabIconsBlack = {
            R.drawable.ic_home_black_24dp,
            R.drawable.build_expo,
            R.drawable.hot_projects,
            R.drawable.ic_notifications_none_black_24dp,
            R.drawable.ic_settings_black_24dp
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {

    }

    private void initViews() {
        mFirstBackPressed = false;
        mActivityName = getIntent().getStringExtra(Util.LOGIN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Expandable ListView
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        navigationCategory = NavigationDataProvider.getNavigationData();
        navigationList = new ArrayList<>(navigationCategory.keySet());
        navigationAdapter = new NavigationAdapter(this, navigationCategory, navigationList);
        expandableListView.setAdapter(navigationAdapter);

        // Swiping Tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        homeViewPager = (ViewPager) findViewById(R.id.home_viewpager);
        setUpViewPager(homeViewPager);
        tabLayout.setupWithViewPager(homeViewPager);
        setTabIcons();

    }

    private void setUpViewPager(ViewPager homeViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), HomeActivity.class.getSimpleName());
        adapter.addFragment(new HomeFragment(), "");
        adapter.addFragment(new BuildExpoFragment(), "");
        adapter.addFragment(new HotProjectsFragment(), "");
        adapter.addFragment(new NotificationsFragment(), "");
        adapter.addFragment(new SettingsFragment(), "");
        homeViewPager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (mActivityName == null) {
            askToExit();

        } else if (mActivityName.equals(LoginActivity.class.getSimpleName())) {
            askToExit();
        } else {
            HomeActivity.this.finish();
            Intent intent = new Intent(HomeActivity.this, FirstActivity.class);
            startActivity(intent);
        }
    }

    private void askToExit() {
        if (!mFirstBackPressed) {
            Toast.makeText(HomeActivity.this, "Press again to exit", Toast.LENGTH_SHORT).show();
            mFirstBackPressed = true;
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        sleep(4000);
                        mFirstBackPressed = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }


    @Override
    public void onClick(View view, int position, Bundle bundle) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onLongClick(View view, int position) {

    }

    @Override
    public void onClickMail(String toMail) {
        Intent email = new Intent(Intent.ACTION_VIEW);
        email.setType("plain/text");
        email.setData(Uri.parse("lakshman.bodduluru@gmail.com"));
        email.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{toMail});
        email.setType("message/rfc822");
        startActivity(email);
    }

    @Override
    public void onClickPhone(String phone) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String status = sharedPreferences.getString(Util.LOGIN_STATUS_KEY, "");
        if (status.equals(Util.LOGIN_STATUS)) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phone));
            startActivity(intent);
        } else {
            Intent login = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(login);
        }
    }


    // Adapter Class for Sliding Tab View

}
