package admi.buildeeji.activity;

import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;
import admi.buildeeji.adapter.ExpandableRecycleAdapter;
import admi.buildeeji.bin.Child;
import admi.buildeeji.bin.Parent;
import admi.buildeeji.listeners.ClickListener;

public class ExRecycle extends BuildeejiActivity implements ClickListener {


    RecyclerView mRecyclerView;
    List<Parent> mParentList;
    ExpandableRecycleAdapter mExpandableRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_recycle);
        init();
        setData();
        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {
        mExpandableRecycleAdapter = new ExpandableRecycleAdapter(ExRecycle.this, mParentList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mExpandableRecycleAdapter);
    }

    private void setData() {
        // RealEstate
        Child forums = new Child("Forums");
        Child interviews = new Child("Interviews");
        Child articles = new Child("Articles");
        Child reviews = new Child("Reviews");
        Child feedback = new Child("Feedback");

        //Property
        Child newProperty = new Child("New Property");
        Child resaleProperty = new Child("Resale Property");
        Child rentLeasePg = new Child("Rent/Lease/Pg");

        //Construction Materials
        Child constructionProfessionals = new Child("Construction Professionals");
        Child constructionServices = new Child("Construction Services");
        Child constructionMaterial = new Child("Construction Materials");

        Parent home = new Parent("Home", null);
        Parent realEstate = new Parent("Real Estate", Arrays.asList(forums, interviews, articles, reviews, feedback));
        Parent property = new Parent("Property", Arrays.asList(newProperty, resaleProperty, rentLeasePg));
        Parent constructionMaterials = new Parent("Construction Materials", Arrays.asList(constructionProfessionals, constructionServices, constructionMaterial));
        Parent buildExpo = new Parent("Build Expo", null);
        Parent postResidential = new Parent("Post Residential", null);
        Parent postCommercial = new Parent("Manage Edit Listing", null);
        Parent viewResponses = new Parent("View Responses", null);
        Parent shortList = new Parent("Short List", null);
        Parent recentActivity = new Parent("Recent Activity", null);
        mParentList = Arrays.asList(home, realEstate, property, constructionMaterials, buildExpo, postResidential, postCommercial, viewResponses, shortList, recentActivity);
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.navigation_recycler_view);
    }

    @Override
    public void onClick(View view, int position, Bundle bundle) {

    }

    @Override
    public void onClickHotProject() {

    }

    @Override
    public void onLongClick(View view, int position) {

    }

    @Override
    public void onClickMail(String toMail) {

    }

    @Override
    public void onClickPhone(String phone) {

    }

    @Override
    public void expandableRecycleClick(String name) {
        switch (name) {
            case "Home":
                Intent profile = new Intent(ExRecycle.this, ProfileActivity.class);
                startActivity(profile);
                break;
            case "Forums":
                Intent settings = new Intent(ExRecycle.this, SettingsActivity.class);
                startActivity(settings);
                break;
            default:
                break;

        }
    }
}
