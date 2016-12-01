package admi.buildeeji.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.adapter.HomeAdapter;
import admi.buildeeji.bin.Home;

/**
 * Created by Admin on 7/18/2016.
 */
public class HomeFragment extends BuildeejiFragment {

    RecyclerView homeRecyclerView;
    ArrayList<Home> homeArrayList;
    String[] array = {"Build Expo", "Hot Projects", "Recent Activity", "Short List",
            "Properties for sale", "Properties for Rent", "Under Construction Projects",
            "Ready to move Projects"};
    int[] images = {
            R.drawable.hot_projects,
            R.drawable.hot_projects,
            R.drawable.hot_projects,
            R.drawable.hot_projects,
            R.drawable.hot_projects,
            R.drawable.hot_projects,
            R.drawable.hot_projects,
            R.drawable.hot_projects
    };

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        initViews();
        initListener();
        setData();
        setAdapterForRecyclerView();
    }

    private void setData() {

        for (int i = 0; i < array.length; i++) {
            Home home = new Home();
            home.setName(array[i]);
            home.setImages(images[i]);
            homeArrayList.add(home);
        }
    }

    private void setAdapterForRecyclerView() {
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), homeArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        homeRecyclerView.setLayoutManager(layoutManager);
        homeRecyclerView.setItemAnimator(new DefaultItemAnimator());
        homeRecyclerView.swapAdapter(homeAdapter, true);
    }

    private void initListener() {

    }

    private void initViews() {
        homeArrayList = new ArrayList<>();
        homeRecyclerView = (RecyclerView) getActivity().findViewById(R.id.home_recycler_view);
    }
}
