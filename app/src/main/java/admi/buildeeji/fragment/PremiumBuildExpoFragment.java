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
import admi.buildeeji.activity.StringArraysClass;
import admi.buildeeji.adapter.PremiumBuildExpoAdapter;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.PremiumBuildExpo;

/**
 * Created by Admin on 7/31/2016.
 */
public class PremiumBuildExpoFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<PremiumBuildExpo> premiumBuildExpoArrayList;
    String[] array = {"Premium", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premium_build_expo, container, false);
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
        PremiumBuildExpoAdapter adapter = new PremiumBuildExpoAdapter(getActivity(), premiumBuildExpoArrayList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.swapAdapter(adapter, true);
    }

    private void setData() {
        for (int i = 0; i < 15; i++) {
            PremiumBuildExpo premiumBuildExpo = new PremiumBuildExpo();
            premiumBuildExpo.setCompanyName(StringArraysClass.companyNamePremium[i]);
            premiumBuildExpo.setImage(BasicBuildExpoFragment.images[i]);
            premiumBuildExpo.setContactPerson(StringArraysClass.phonePremium[i]);
            premiumBuildExpo.setEmail(StringArraysClass.emailPremium[i]);
            premiumBuildExpo.setSummery(BasicBuildExpoFragment.summery[i]);
            premiumBuildExpo.setFeatureProjects(BasicBuildExpoFragment.featureProjects[i]);
            premiumBuildExpo.setPresentProjects(BasicBuildExpoFragment.summery[i]);
            premiumBuildExpo.setPreviousProjects(BasicBuildExpoFragment.featureProjects[i]);
            premiumBuildExpoArrayList.add(premiumBuildExpo);
        }
    }

    private void initListener() {

    }

    private void initViews() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.premium_build_expo_recycler_view);
        premiumBuildExpoArrayList = new ArrayList<>();
    }
}
