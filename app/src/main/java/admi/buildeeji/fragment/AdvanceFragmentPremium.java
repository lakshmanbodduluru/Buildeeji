package admi.buildeeji.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import admi.buildeeji.R;

/**
 * Created by Admin on 8/29/2016.
 */
public class AdvanceFragmentPremium extends BuildExpoFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advance_premium_plans, container, false);
        return view;
    }
}
