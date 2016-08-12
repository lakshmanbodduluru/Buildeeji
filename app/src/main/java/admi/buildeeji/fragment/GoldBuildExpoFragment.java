package admi.buildeeji.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import admi.buildeeji.R;
import admi.buildeeji.adapter.GoldBuildExpoAdapter;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.GoldBuildExpo;

/**
 * Created by Admin on 7/31/2016.
 */
public class GoldBuildExpoFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<GoldBuildExpo> goldBuildExpoArrayList;
    String[] array = {"Gold", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gold_build_expo, container, false);
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
        GoldBuildExpoAdapter adapter = new GoldBuildExpoAdapter(getActivity(), goldBuildExpoArrayList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.swapAdapter(adapter, true);
    }

    private void setData() {
        for (int i = 0; i < array.length; i++) {
            GoldBuildExpo goldBuildExpo = new GoldBuildExpo();
            goldBuildExpo.setCompanyName(array[i]);
            goldBuildExpo.setContactPerson(BasicBuildExpoFragment.contactPerson[i]);
            goldBuildExpo.setFeatureProjects(BasicBuildExpoFragment.featureProjects[i]);
            goldBuildExpo.setSummery(BasicBuildExpoFragment.summery[i]);
            goldBuildExpo.setImage(BasicBuildExpoFragment.images[i]);
            goldBuildExpo.setPresentProjects(BasicBuildExpoFragment.summery[i]);
            goldBuildExpo.setPreviousProjects(BasicBuildExpoFragment.featureProjects[i]);
            goldBuildExpoArrayList.add(goldBuildExpo);
        }
    }

    private void initListener() {

    }

    private void initViews() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.gold_build_expo_recycler_view);
        goldBuildExpoArrayList = new ArrayList<>();
    }
}

