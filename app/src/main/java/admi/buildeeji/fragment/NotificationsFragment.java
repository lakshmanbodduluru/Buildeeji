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
import admi.buildeeji.adapter.NotificationsAdapter;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.Notifications;

/**
 * Created by Lakshman Bodduluru on 7/18/2016.
 */
public class NotificationsFragment extends Fragment {

    RecyclerView notificationRecyclerView;
    ArrayList<Notifications> notificationsArrayList;

    String[] companyName = {"Lakshman", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String[] dateTime = {
            "01/08/2016 01:20", "01/08/2016 02:14", "03/08/2016 12:32",
            "04/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20"
            , "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20"
            , "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20"
            , "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20", "01/08/2016 01:20"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        return view;
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
        for (int i = 0; i < 15; i++) {
            Notifications notifications = new Notifications();
            notifications.setCompanyName(StringArraysClass.companyNameNotification[i]);
            notifications.setContactPerson(StringArraysClass.contactPersonNotification[i]);
            notifications.setDateTime(dateTime[i]);
            notifications.setSummery(BasicBuildExpoFragment.summery[i]);
            notifications.setPastProjects(BasicBuildExpoFragment.featureProjects[i]);
            notifications.setFeatureProjects(BasicBuildExpoFragment.summery[i]);
            notifications.setPresentProjects(BasicBuildExpoFragment.featureProjects[i]);
            notificationsArrayList.add(notifications);
        }
    }

    private void initListener() {

    }

    private void initViews() {
        notificationsArrayList = new ArrayList<>();
        notificationRecyclerView = (RecyclerView) getActivity().findViewById(R.id.notification_recycler_view);
    }

    public void setAdapterForRecyclerView() {
        NotificationsAdapter notificationsAdapter = new NotificationsAdapter(getActivity(), notificationsArrayList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        notificationRecyclerView.setLayoutManager(manager);
        notificationRecyclerView.setItemAnimator(new DefaultItemAnimator());
        notificationRecyclerView.swapAdapter(notificationsAdapter, true);
    }
}
