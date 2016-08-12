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

import admi.buildeeji.R;
import admi.buildeeji.adapter.HotProjectsAdapter;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.HotProjects;

/**
 * Created by Lakshman Bodduluru on 7/18/2016.
 */
public class HotProjectsFragment extends Fragment {
    RecyclerView hotProjectsRecyclerView;
    ArrayList<HotProjects> hotProjectsArrayList;

    String[] companyName = {"Hot Projects", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot_projects, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void init() {
        initViews();
        initListener();
        setData();
        setAdapterForRecyclerView();
    }

    private void initListener() {

    }

    private void initViews() {
        hotProjectsArrayList = new ArrayList<>();
        hotProjectsRecyclerView = (RecyclerView) getActivity().findViewById(R.id.hot_projects_recycler_view);
    }

    private void setData() {
        for (int i = 0; i < companyName.length; i++) {
            HotProjects hotProjects = new HotProjects();
            hotProjects.setCompanyName(companyName[i]);
            hotProjects.setContactPerson(BasicBuildExpoFragment.contactPerson[i]);
            hotProjects.setImage(BasicBuildExpoFragment.images[i]);
            hotProjects.setSummery(BasicBuildExpoFragment.summery[i]);
            hotProjects.setFeatureProjects(BasicBuildExpoFragment.featureProjects[i]);
            hotProjects.setPresentProjects(BasicBuildExpoFragment.summery[i]);
            hotProjects.setPreviousProjects(BasicBuildExpoFragment.featureProjects[i]);
            hotProjectsArrayList.add(hotProjects);
        }
    }

    public void setAdapterForRecyclerView() {
        HotProjectsAdapter hotProjectsAdapter = new HotProjectsAdapter(getActivity(), hotProjectsArrayList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        hotProjectsRecyclerView.setLayoutManager(manager);
        hotProjectsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        hotProjectsRecyclerView.swapAdapter(hotProjectsAdapter, true);
    }

}
