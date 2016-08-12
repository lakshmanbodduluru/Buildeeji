package admi.buildeeji.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.Util;

/**
 * Created by Admin on 8/5/2016.
 */
public class ResultHomeFragment extends BuildeejiFragment {
    Bundle bundle;
    TextView mCompanyName;
    TextView summery;
    TextView featureProjects;
    TextView presentProjects;
    TextView pastProjects;

    public ResultHomeFragment(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_home, container, false);
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
    }

    private void setData() {
        summery.setText(bundle.getString(Util.RESULT_SUMMERY));
        mCompanyName.setText(bundle.getString(Util.RESULT_COMPANY_NAME));
        featureProjects.setText(bundle.getString(Util.RESULT_FEATURE_PROJECTS));
        presentProjects.setText(bundle.getString(Util.RESULT_PRESENT_PROJECTS));
        pastProjects.setText(bundle.getString(Util.RESULT_PAST_PROJECTS));
    }

    private void initListener() {
        summery = (TextView) mActivity.findViewById(R.id.result_home_summary);
        featureProjects = (TextView) mActivity.findViewById(R.id.result_home_feature_projects);
        presentProjects = (TextView) mActivity.findViewById(R.id.result_home_present_projects);
        pastProjects = (TextView) mActivity.findViewById(R.id.result_home_past_projects);
        mCompanyName = (TextView) mActivity.findViewById(R.id.result_home_company_name);
    }

    private void initViews() {

    }
}
