package admi.buildeeji.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import admi.buildeeji.R;
import admi.buildeeji.Util;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView skip;
    private Button signIn;
    private Button signUp;
    private Button loginWithFb;
    private Button loginWithGooglePlus;
    private ViewPager viewPager;
    private MyViewPageAdapter myViewPageAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        skip.setOnClickListener(this);
        signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);
        loginWithFb.setOnClickListener(this);
        loginWithGooglePlus.setOnClickListener(this);

    }

    private void initViews() {
        skip = (TextView) findViewById(R.id.text_view_skip);
        signIn = (Button) findViewById(R.id.user_sign_in);
        signUp = (Button) findViewById(R.id.user_sign_up);

        loginWithFb = (Button) findViewById(R.id.sign_in_facebook);
        loginWithGooglePlus = (Button) findViewById(R.id.sign_up_google_pluse);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        // Layouts for all Welcome Slides
        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide4,
                R.layout.welcome_slide5,
                R.layout.welcome_slide6
        };
        addBottomDots(0);
        myViewPageAdapter = new MyViewPageAdapter();
        viewPager.setAdapter(myViewPageAdapter);
    }

    @Override
    public void onBackPressed() {
        FirstActivity.this.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_skip:
                Intent skipIntent = new Intent(FirstActivity.this, HomeActivity.class);
                skipIntent.putExtra(Util.LOGIN, this.getClass().getSimpleName());
                FirstActivity.this.finish();
                startActivity(skipIntent);
                break;
            case R.id.user_sign_in:
                Intent signInIntent = new Intent(FirstActivity.this, LoginActivity.class);
                FirstActivity.this.finish();
                startActivity(signInIntent);
                break;
            case R.id.user_sign_up:
                Intent signUpIntent = new Intent(FirstActivity.this, SignUpActivity.class);
                FirstActivity.this.finish();
                startActivity(signUpIntent);
                break;
            case R.id.sign_in_facebook:
                Toast.makeText(FirstActivity.this, "Login From Facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_up_google_pluse:
                Toast.makeText(FirstActivity.this, "Login From Google Pluse", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    // View Pager change Listener
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    // Add Bottom Dots
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    /**
     * View Page Adapter Class
     */
    public class MyViewPageAdapter extends PagerAdapter {

        public MyViewPageAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
