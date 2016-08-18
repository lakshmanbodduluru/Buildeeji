package admi.buildeeji.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import admi.buildeeji.R;
import admi.buildeeji.Util;
import admi.buildeeji.activity.StringArraysClass;
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.PremiumBuildExpo;
import admi.buildeeji.listeners.ClickListener;

/**
 * Created by Lakshman Bodduluru on 8/1/2016.
 */


public class PremiumBuildExpoAdapter extends RecyclerView.Adapter<PremiumBuildExpoAdapter.PremiumBuildExpoViewHolder> {
    ArrayList<PremiumBuildExpo> premiumBuildExpoArrayList;
    Context context;
    LayoutInflater inflater;

    public PremiumBuildExpoAdapter(Context context, ArrayList<PremiumBuildExpo> premiumBuildExpoArrayList) {
        this.context = context;
        this.premiumBuildExpoArrayList = premiumBuildExpoArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PremiumBuildExpoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_premium_build_expo, parent, false);
        PremiumBuildExpoViewHolder goldBuildExpoViewHolder = new PremiumBuildExpoViewHolder(view);
        return goldBuildExpoViewHolder;
    }

    @Override
    public void onBindViewHolder(PremiumBuildExpoViewHolder holder, int position) {
        PremiumBuildExpo premiumBuildExpo = premiumBuildExpoArrayList.get(position);
        holder.companyName.setText(premiumBuildExpo.getCompanyName());
        holder.contactPerson.setText(premiumBuildExpo.getContactPerson());
        holder.companyImage.setImageResource(premiumBuildExpo.getImage());
    }

    @Override
    public int getItemCount() {
        return premiumBuildExpoArrayList.size();
    }

    public class PremiumBuildExpoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView companyName;
        TextView contactPerson;
        ImageView companyImage;
        ImageView mail;
        ImageView phone;
        CardView cardView;

        public PremiumBuildExpoViewHolder(View view) {
            super(view);
            companyName = (TextView) view.findViewById(R.id.premium_build_expo_company_name_tv);
            contactPerson = (TextView) view.findViewById(R.id.premium_build_expo_contact_person_tv);
            companyImage = (ImageView) view.findViewById(R.id.premium_build_expo_company_img);
            mail = (ImageView) view.findViewById(R.id.premium_build_expo_mail_icon);
            phone = (ImageView) view.findViewById(R.id.premium_build_expo_phone_icon);
            cardView = (CardView) view.findViewById(R.id.premium_build_expo_card_view);
            companyImage.setOnClickListener(this);
            cardView.setOnClickListener(this);
            phone.setOnClickListener(this);
            mail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            PremiumBuildExpo premiumBuildExpo = premiumBuildExpoArrayList.get(getAdapterPosition());
            ClickListener clickListener = (ClickListener) context;
            switch (v.getId()) {
                case R.id.premium_build_expo_company_img:
                    showImageInDialog(premiumBuildExpo);
                    break;
                case R.id.premium_build_expo_card_view:
                    Bundle bundle = new Bundle();
                    bundle.putString(Util.RESULT_COMPANY_NAME, premiumBuildExpo.getCompanyName());
                    bundle.putString(Util.RESULT_CONTACT_PERSON, premiumBuildExpo.getContactPerson());
                    bundle.putString(Util.RESULT_SUMMERY, premiumBuildExpo.getSummery());
                    bundle.putString(Util.RESULT_PRESENT_PROJECTS, premiumBuildExpo.getPresentProjects());
                    bundle.putString(Util.RESULT_PAST_PROJECTS, premiumBuildExpo.getPreviousProjects());
                    bundle.putString(Util.RESULT_FEATURE_PROJECTS, premiumBuildExpo.getFeatureProjects());
                    clickListener.onClick(v, getAdapterPosition(), bundle);
                    break;
                case R.id.premium_build_expo_phone_icon:
                    clickListener.onClickPhone(premiumBuildExpo.getPhoneNumber());
                    break;
                case R.id.premium_build_expo_mail_icon:
                    clickListener.onClickMail(premiumBuildExpo.getEmail());
                    break;
            }
        }

        private void showImageInDialog(PremiumBuildExpo premiumBuildExpo) {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custome_image_view_dialog);
            dialog.show();
            ImageView imageView = (ImageView) dialog.findViewById(R.id.custom_dialog_image_view);
            imageView.setImageResource(premiumBuildExpo.getImage());
        }
    }
}

