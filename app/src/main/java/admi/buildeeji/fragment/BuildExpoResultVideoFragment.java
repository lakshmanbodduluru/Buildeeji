package admi.buildeeji.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;

/**
 * Created by Admin on 8/5/2016.
 */
public class BuildExpoResultVideoFragment extends BuildeejiFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_video, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
