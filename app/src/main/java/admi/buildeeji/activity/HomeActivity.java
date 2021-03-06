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
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.Util;
import admi.buildeeji.adapter.ExpandableRecycleAdapter;
import admi.buildeeji.adapter.ViewPagerAdapter;
import admi.buildeeji.bin.Home;
import admi.buildeeji.bin.NavigationDataProvider;
import admi.buildeeji.fragment.BuildExpoFragment;
import admi.buildeeji.fragment.HomeFragment;
import admi.buildeeji.fragment.HotProjectsFragment;
import admi.buildeeji.fragment.SettingsFragment;
import admi.buildeeji.fragment.NotificationsFragment;
import admi.buildeeji.listeners.ClickListener;

public class HomeActivity extends BuildeejiActivity
        implements NavigationView.OnNavigationItemSelectedListener, ClickListener {

    RecyclerView mNavigationRecyclerView;
    Toolbar toolbar;
    private boolean mOptionsMenu;
    ExpandableRecycleAdapter mExpandableRecycleAdapter;
    public boolean mFirstBackPressed;
    TabLayout tabLayout;
    String mActivityName;
    NavigationDataProvider mNavigationDataProvider;
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
            R.drawable.build_expo_black,
            R.drawable.hot_projects_black,
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
        setNavigationRecycleAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);

    }

    private void setNavigationRecycleAdapter() {
        mExpandableRecycleAdapter = new ExpandableRecycleAdapter(HomeActivity.this, mNavigationDataProvider.getParentList());
        mNavigationRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mNavigationRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mExpandableRecycleAdapter.notifyParentItemChanged(1);
        mExpandableRecycleAdapter.notifyDataSetChanged();
        mNavigationRecyclerView.swapAdapter(mExpandableRecycleAdapter, true);
    }

    private void initListener() {
        homeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    tabLayout.getTabAt(0).setIcon(tabIconsBlack[0]);
                    tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                    tabLayout.getTabAt(2).setIcon(tabIcons[2]);
                    tabLayout.getTabAt(3).setIcon(tabIcons[3]);
                    tabLayout.getTabAt(4).setIcon(tabIcons[4]);
                } else if (position == 1) {
                    tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                    tabLayout.getTabAt(1).setIcon(tabIconsBlack[1]);
                    tabLayout.getTabAt(2).setIcon(tabIcons[2]);
                    tabLayout.getTabAt(3).setIcon(tabIcons[3]);
                    tabLayout.getTabAt(4).setIcon(tabIcons[4]);

                } else if (position == 2) {
                    tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                    tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                    tabLayout.getTabAt(2).setIcon(tabIconsBlack[2]);
                    tabLayout.getTabAt(3).setIcon(tabIcons[3]);
                    tabLayout.getTabAt(4).setIcon(tabIcons[4]);

                } else if (position == 3) {
                    tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                    tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                    tabLayout.getTabAt(2).setIcon(tabIcons[2]);
                    tabLayout.getTabAt(3).setIcon(tabIconsBlack[3]);
                    tabLayout.getTabAt(4).setIcon(tabIcons[4]);
                } else if (position == 4) {
                    tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                    tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                    tabLayout.getTabAt(2).setIcon(tabIcons[2]);
                    tabLayout.getTabAt(3).setIcon(tabIcons[3]);
                    tabLayout.getTabAt(4).setIcon(tabIconsBlack[4]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {
        mFirstBackPressed = false;
        mActivityName = getIntent().getStringExtra(Util.LOGIN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDataProvider = new NavigationDataProvider();
        mNavigationRecyclerView = (RecyclerView) findViewById(R.id.navigation_recycler_view);
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

        // NAVIGATION Expandable RecyclerView

        // Swiping Tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        homeViewPager = (ViewPager) findViewById(R.id.home_viewpager);
        setUpViewPager(homeViewPager);
//        homeViewPager.beginFakeDrag();
        homeViewPager.canScrollHorizontally(1);
        tabLayout.setupWithViewPager(homeViewPager);
//        setTabIcons();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_clear);

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

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(HomeActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                settingsIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(settingsIntent);
                break;
            case R.id.action_profile:
               /* Toast.makeText(HomeActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent profileIntent = new Intent(this, ProfileActivity.class);
                profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profileIntent);*/
                Intent exRecyclerView = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(exRecyclerView);
                break;
            case R.id.action_logout:
                /*Intent logoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
                HomeActivity.this.finish();
                startActivity(logoutIntent);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();*/

                Intent intent = new Intent(HomeActivity.this, FilterSortByActivity.class);
                startActivity(intent);
                break;
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
        Intent intent = new Intent(this, BuildExpoResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClickHotProject() {
        Intent intent = new Intent(this, HotProjectResultPage.class);
        startActivity(intent);
    }

    @Override
    public void onLongClick(View view, int position) {

    }

    @Override
    public void onClickMail(String toMail) {
        Bundle bundle = new Bundle();
        Intent email = Util.sendEmail(toMail, bundle);
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

    @Override
    public void expandableRecycleClick(String name) {
        switch (name) {
            case "Home":
                Intent profile = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(profile);
                break;
            case "Forums":
                Intent settings = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(settings);
                break;
            case "Recent Activity":
                Intent recentActivity = new Intent(HomeActivity.this, RecentActivity.class);
                startActivity(recentActivity);
                break;
            default:
                break;

        }
    }


    // Adapter Class for Sliding Tab View

}
