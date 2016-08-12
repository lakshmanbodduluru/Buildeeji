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
import admi.buildeeji.adapter.NormalBuildExpoAdapter;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.NormalBuildExpo;

/**
 * Created by Admin on 8/1/2016.
 */
public class NormalBuildExpoFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<NormalBuildExpo> normalBuildExpoArrayList;
    String[] array = {"Normal", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_normal_build_expo, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setDataForRecyclerView();
    }

    private void setDataForRecyclerView() {
        NormalBuildExpoAdapter adapter = new NormalBuildExpoAdapter(getActivity(), normalBuildExpoArrayList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.swapAdapter(adapter, true);
    }

    private void setData() {
        for (int i = 0; i < array.length; i++) {
            NormalBuildExpo normalBuildExpo = new NormalBuildExpo();
            normalBuildExpo.setCompanyName(array[i]);
            normalBuildExpo.setContactPerson(BasicBuildExpoFragment.contactPerson[i]);
            normalBuildExpo.setSummery(BasicBuildExpoFragment.summery[i]);
            normalBuildExpo.setImage(BasicBuildExpoFragment.images[i]);
            normalBuildExpo.setFeatureProjects(BasicBuildExpoFragment.featureProjects[i]);
            normalBuildExpo.setPresentProjects(BasicBuildExpoFragment.summery[i]);
            normalBuildExpo.setPreviousProjects(BasicBuildExpoFragment.featureProjects[i]);
            normalBuildExpoArrayList.add(normalBuildExpo);
        }
    }

    private void initListener() {

    }

    private void initViews() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.normal_build_expo_recycler_view);
        normalBuildExpoArrayList = new ArrayList<>();
    }
}
