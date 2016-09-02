package admi.buildeeji.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import admi.buildeeji.BuildeejiFragment;
import admi.buildeeji.R;
import admi.buildeeji.enums.FragmentType;

/**
 * Created by Admin on 7/18/2016.
 */
public class BuildExpoFragment extends BuildeejiFragment implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroupBtn;
    private BasicBuildExpoFragment mBasicBuildExpoFragment;
    private NormalBuildExpoFragment mNormalBuildExpoFragment;
    private PremiumBuildExpoFragment mPremiumBuildExpoFragment;
    private GoldBuildExpoFragment mGoldBuildExpoFragment;
    private RadioButton basicBuildExpoRadioBtn;


    public BuildExpoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_build_expo, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

 /*   @Override
    public void onStart() {
        super.onStart();
        displayBasicBuildExpoFragment();
        mRadioGroupBtn.check(R.id.build_expo_basic_radio_button);

    }*/

    @Override
    public void onResume() {
        super.onResume();
//        mRadioGroupBtn.check(R.id.build_expo_basic_radio_button);
        if (basicBuildExpoRadioBtn.isChecked()) {
//            displayDefaultBasicBuildExpoFragment();
        }
    }


   private void init() {
        initViews();
        initListener();
    }


    private void initViews() {
        mRadioGroupBtn = (RadioGroup) getActivity().findViewById(R.id.radio_group);
        basicBuildExpoRadioBtn = (RadioButton) getActivity().findViewById(R.id.build_expo_basic_radio_button);
        mBasicBuildExpoFragment = new BasicBuildExpoFragment();
        mNormalBuildExpoFragment = new NormalBuildExpoFragment();
        mPremiumBuildExpoFragment = new PremiumBuildExpoFragment();
        mGoldBuildExpoFragment = new GoldBuildExpoFragment();
    }

    private void initListener() {
        mRadioGroupBtn.setOnCheckedChangeListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.build_expo_basic_radio_button) {
            initFragment(FragmentType.BasicBuildExpoFragment);
        } else if (checkedId == R.id.build_expo_normal_radio_button) {
            initFragment(FragmentType.NormalBuildExpoFragment);
        } else if (checkedId == R.id.build_expo_premium_radio_button) {
            initFragment(FragmentType.PremiumBuildExpoFragment);
        } else if (checkedId == R.id.build_expo_gold_radio_button) {
            initFragment(FragmentType.GoldBuildExpoFragment);
        }
    }

    private void initFragment(FragmentType type) {
        switch (type) {
            case BasicBuildExpoFragment:
                displayBasicBuildExpoFragment();
                break;
            case NormalBuildExpoFragment:
                displayNormalBuildExpoFragment();
                break;
            case PremiumBuildExpoFragment:
                displayPremiumBuildExpoFragment();
                break;
            case GoldBuildExpoFragment:
                displayGoldBuildExpoFragment();
                break;
            default:
                break;
        }
    }

    private void displayDefaultBasicBuildExpoFragment() {
        BasicBuildExpoFragment basicBuildExpoFragment = new BasicBuildExpoFragment();
        FragmentManager manager = mActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.parent_menu, basicBuildExpoFragment);
        transaction.commit();
    }

    private void displayBasicBuildExpoFragment() {
        BasicBuildExpoFragment basicBuildExpoFragment = (BasicBuildExpoFragment) getActivity().getSupportFragmentManager()
                .findFragmentByTag(BasicBuildExpoFragment.class.getSimpleName());
        if (basicBuildExpoFragment == null) {
            basicBuildExpoFragment = new BasicBuildExpoFragment();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.parent_menu, basicBuildExpoFragment, basicBuildExpoFragment.getClass().getSimpleName());
            fragmentTransaction.commit();
        }

    }


    private void displayNormalBuildExpoFragment() {
        NormalBuildExpoFragment normalBuildExpoFragment = (NormalBuildExpoFragment) getActivity().getSupportFragmentManager()
                .findFragmentByTag(NormalBuildExpoFragment.class.getSimpleName());
        if (normalBuildExpoFragment == null) {
            normalBuildExpoFragment = new NormalBuildExpoFragment();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.parent_menu, normalBuildExpoFragment, normalBuildExpoFragment.getClass().getSimpleName());
            fragmentTransaction.commit();
        }
    }

    private void displayPremiumBuildExpoFragment() {
        PremiumBuildExpoFragment premiumBuildExpoFragment = (PremiumBuildExpoFragment) getActivity().getSupportFragmentManager()
                .findFragmentByTag(PremiumBuildExpoFragment.class.getSimpleName());
        if (premiumBuildExpoFragment == null) {
            premiumBuildExpoFragment = new PremiumBuildExpoFragment();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.parent_menu, premiumBuildExpoFragment, premiumBuildExpoFragment.getClass().getSimpleName());
            fragmentTransaction.commit();
        }

    }

    private void displayGoldBuildExpoFragment() {
        GoldBuildExpoFragment goldBuildExpoFragment = (GoldBuildExpoFragment) getActivity().getSupportFragmentManager()
                .findFragmentByTag(GoldBuildExpoFragment.class.getSimpleName());
        if (goldBuildExpoFragment == null) {
            goldBuildExpoFragment = new GoldBuildExpoFragment();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.parent_menu, goldBuildExpoFragment, goldBuildExpoFragment.getClass().getSimpleName());
            fragmentTransaction.commit();
        }
    }


}
