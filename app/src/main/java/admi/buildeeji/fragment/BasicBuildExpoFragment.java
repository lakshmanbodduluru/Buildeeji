package admi.buildeeji.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.activity.HomeActivity;
import admi.buildeeji.adapter.BasicBuildExpoAdapter;
import admi.buildeeji.bin.BasicBuildExpo;

/**
 * Created by Admin on 8/1/2016.
 */
public class BasicBuildExpoFragment extends BuildeejiFragment {
    RecyclerView recyclerView;
    public HomeActivity activity;

    String[] companyName = {"Basic BuildExpo", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    public static String[] contactPerson = {"Lakshman", "Krishna", "Suresh", "Naresh", "Harsha", "Vishnu", "Vishal", "Sravan Kumar", "Suresh Reddy", "Surya kiran", "Vishan gunne", "Vijay Kumar Reddy", "Trinadh kumar", "Srinivas", "Praveen yadav", "Prame Reddy", "Surendar", "Sukumar", "Sushanth", "Abhishake yadav", "Arjun kumar"};
    public String[] phone = {};
    private String[] email = {};
    public static int[] images = {R.drawable.hot_projects, R.drawable.hot_projects, R.drawable.hot_projects,
            R.drawable.hot_projects, R.drawable.hot_projects, R.drawable.hot_projects,
            R.drawable.hot_projects, R.drawable.hot_projects, R.drawable.hot_projects,
            R.drawable.hot_projects, R.drawable.hot_projects, R.drawable.hot_projects,
            R.drawable.hot_projects, R.drawable.hot_projects, R.drawable.hot_projects,
            R.drawable.hot_projects, R.drawable.hot_projects, R.drawable.hot_projects,
            R.drawable.hot_projects, R.drawable.ic_menu_camera, R.drawable.ic_home_black_24dp};
    public static String[] summery = {
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code",
            "I am trying to send a bundle from one activity to another. When I load the bundle in the recieving activity all the information seems to be null. Here is some code"

    };
    public static String[] featureProjects = {
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it.",
            "Setting a custom view to the tab is very useful when you are not able to achieve desired output by following the methods provided by tab layout. While setting a custom view to tab, make sure that you follow the specs suggested by android for tabs.\n" +
                    "\n" +
                    "When we set the tab an icon and text, you can see the icon is horizontally aligned with tab text. But if you want to place the icon above the tab label, you have to use a custom view to achive it."
    };


    ArrayList<BasicBuildExpo> basicBuildExpoArrayList;

    public static BasicBuildExpoFragment newInstance() {
        BasicBuildExpoFragment basicBuildExpoFragment = new BasicBuildExpoFragment();
        return basicBuildExpoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basic_build_expo, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (HomeActivity) activity;
    }

    private void init() {
        initViews();
        initListener();
        setData();
        setAdapterForRecyclerView();
    }

    private void setAdapterForRecyclerView() {
        BasicBuildExpoAdapter buildExpoAdapter = new BasicBuildExpoAdapter(getActivity(), basicBuildExpoArrayList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.swapAdapter(buildExpoAdapter, true);

    }

    private void setData() {
        for (int i = 0; i < companyName.length; i++) {
            BasicBuildExpo basicBuildExpo = new BasicBuildExpo();
            basicBuildExpo.setCompanyName(companyName[i]);
            basicBuildExpo.setContactPerson(contactPerson[i]);
            basicBuildExpo.setSummery(summery[i]);
            basicBuildExpo.setImage(images[i]);
            basicBuildExpo.setFeatureProjects(featureProjects[i]);
            basicBuildExpo.setPresentProjects(summery[i]);
            basicBuildExpo.setPreviousProjects(featureProjects[i]);
            basicBuildExpoArrayList.add(basicBuildExpo);
        }
    }

    private void initListener() {

    }

    private void initViews() {
        basicBuildExpoArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.basic_build_expo_recycler_view);
    }

}
