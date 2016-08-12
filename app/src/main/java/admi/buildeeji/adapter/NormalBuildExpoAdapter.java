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
import admi.buildeeji.bin.BasicBuildExpo;
import admi.buildeeji.bin.NormalBuildExpo;
import admi.buildeeji.listeners.ClickListener;

/**
 * Created by Admin on 8/1/2016.
 */
public class NormalBuildExpoAdapter extends RecyclerView.Adapter<NormalBuildExpoAdapter.NormalBuildExpoViewHolder> {
    ArrayList<NormalBuildExpo> normalBuildExpoArrayList;
    Context context;
    LayoutInflater inflater;

    public NormalBuildExpoAdapter(Context context, ArrayList<NormalBuildExpo> goldBuildExpoArrayList) {
        this.context = context;
        this.normalBuildExpoArrayList = goldBuildExpoArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NormalBuildExpoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_normal_build_expo_recycle_view, parent, false);
        NormalBuildExpoViewHolder goldBuildExpoViewHolder = new NormalBuildExpoViewHolder(view);
        return goldBuildExpoViewHolder;
    }

    @Override
    public void onBindViewHolder(NormalBuildExpoViewHolder holder, int position) {
        NormalBuildExpo normalBuildExpo = normalBuildExpoArrayList.get(position);
        holder.companyName.setText(normalBuildExpo.getCompanyName());
        holder.contactPerson.setText(normalBuildExpo.getContactPerson());
        holder.companyImage.setImageResource(normalBuildExpo.getImage());
    }

    @Override
    public int getItemCount() {
        return normalBuildExpoArrayList.size();
    }

    public class NormalBuildExpoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView companyName;
        TextView contactPerson;
        ImageView companyImage;
        ImageView mail;
        ImageView phone;
        CardView cardView;

        public NormalBuildExpoViewHolder(View view) {
            super(view);
            companyName = (TextView) view.findViewById(R.id.normal_build_expo_company_name_tv);
            contactPerson = (TextView) view.findViewById(R.id.normal_build_expo_contact_person_tv);
            companyImage = (ImageView) view.findViewById(R.id.normal_build_expo_company_img);
            mail = (ImageView) view.findViewById(R.id.normal_build_expo_mail_icon);
            phone = (ImageView) view.findViewById(R.id.normal_build_expo_phone_icon);
            cardView = (CardView) view.findViewById(R.id.normal_build_expo_card_view);
            companyImage.setOnClickListener(this);
            cardView.setOnClickListener(this);
            phone.setOnClickListener(this);
            mail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            NormalBuildExpo normalBuildExpo = normalBuildExpoArrayList.get(getAdapterPosition());
            ClickListener clickListener = (ClickListener) context;
            switch (v.getId()) {
                case R.id.normal_build_expo_company_img:
                    showImageInDialog(normalBuildExpo);
                    break;
                case R.id.normal_build_expo_card_view:
                    Bundle bundle = new Bundle();
                    bundle.putString(Util.RESULT_SUMMERY, normalBuildExpo.getSummery());
                    bundle.putString(Util.RESULT_FEATURE_PROJECTS, normalBuildExpo.getFeatureProjects());
                    bundle.putString(Util.RESULT_PRESENT_PROJECTS, normalBuildExpo.getPresentProjects());
                    bundle.putString(Util.RESULT_PAST_PROJECTS, normalBuildExpo.getPreviousProjects());
                    clickListener.onClick(v, getAdapterPosition(), bundle);
                    break;
                case R.id.normal_build_expo_phone_icon:
                    clickListener.onClickPhone("9494896482");
                    break;
                case R.id.normal_build_expo_mail_icon:
                    clickListener.onClickMail("lakshman.bodduluru@gmail.com");
                    break;
            }
        }

        private void showImageInDialog(NormalBuildExpo normalBuildExpo) {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custome_image_view_dialog);
            dialog.show();
            ImageView imageView = (ImageView) dialog.findViewById(R.id.custom_dialog_image_view);
            imageView.setImageResource(normalBuildExpo.getImage());
        }
    }
}