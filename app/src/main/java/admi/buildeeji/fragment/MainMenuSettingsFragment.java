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
import admi.buildeeji.adapter.SettingsAdapter;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.Settings;

/**
 * Created by Lakshman Bodduluru on 7/18/2016.
 */
public class MainMenuSettingsFragment extends Fragment {

    RecyclerView settingsRecyclerView;

    String[] array = {"Share", "Rate us", "About us", "Contact us", "5.Feed back", "Help & FAQ", "Live Chat"};
    ArrayList<Settings> settingsArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu_settings, container, false);
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

    private void setAdapterForRecyclerView() {
        SettingsAdapter settingsAdapter = new SettingsAdapter(getActivity(), settingsArrayList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        settingsRecyclerView.setLayoutManager(manager);
        settingsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        settingsRecyclerView.swapAdapter(settingsAdapter, true);
    }

    private void setData() {
        for (String data :
                array) {
            Settings settings = new Settings(data);
            settingsArrayList.add(settings);
        }
    }

    private void initListener() {

    }

    private void initViews() {
        settingsArrayList = new ArrayList<>();
        settingsRecyclerView = (RecyclerView) getActivity().findViewById(R.id.settings_recycler_view);
    }
}
