package admi.buildeeji.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;

/**
 * Created by Lakshman Bodduluru on 8/13/2016.
 */
public class PrivacyPolicyFragment extends BuildeejiFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_privacy_policy, container, false);
        return view;
    }
}
