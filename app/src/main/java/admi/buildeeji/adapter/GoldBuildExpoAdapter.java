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
import admi.buildeeji.bin.GoldBuildExpo;
import admi.buildeeji.listeners.ClickListener;

/**
 * Created by Admin on 8/1/2016.
 */
public class GoldBuildExpoAdapter extends RecyclerView.Adapter<GoldBuildExpoAdapter.GoldBuildExpoViewHolder> {
    ArrayList<GoldBuildExpo> goldBuildExpoArrayList;
    Context context;
    LayoutInflater inflater;

    public GoldBuildExpoAdapter(Context context, ArrayList<GoldBuildExpo> goldBuildExpoArrayList) {
        this.context = context;
        this.goldBuildExpoArrayList = goldBuildExpoArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public GoldBuildExpoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_gold_buld_expo_recycler_view, parent, false);
        GoldBuildExpoViewHolder goldBuildExpoViewHolder = new GoldBuildExpoViewHolder(view);
        return goldBuildExpoViewHolder;
    }

    @Override
    public void onBindViewHolder(GoldBuildExpoViewHolder holder, int position) {
        GoldBuildExpo goldBuildExpo = goldBuildExpoArrayList.get(position);
        holder.companyName.setText(goldBuildExpo.getCompanyName());
        holder.contactPerson.setText(goldBuildExpo.getContactPerson());
        holder.companyImage.setImageResource(goldBuildExpo.getImage());
    }

    @Override
    public int getItemCount() {
        return goldBuildExpoArrayList.size();
    }

    public class GoldBuildExpoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView companyName;
        TextView contactPerson;
        ImageView companyImage;
        ImageView mail;
        ImageView phone;
        CardView cardView;

        public GoldBuildExpoViewHolder(View view) {
            super(view);
            companyName = (TextView) view.findViewById(R.id.gold_build_expo_company_name_tv);
            contactPerson = (TextView) view.findViewById(R.id.gold_build_expo_contact_person_tv);
            companyImage = (ImageView) view.findViewById(R.id.gold_build_expo_company_img);
            mail = (ImageView) view.findViewById(R.id.gold_build_expo_mail_icon);
            phone = (ImageView) view.findViewById(R.id.gold_build_expo_phone_icon);
            cardView = (CardView) view.findViewById(R.id.gold_build_expo_card_view);
            companyImage.setOnClickListener(this);
            cardView.setOnClickListener(this);
            phone.setOnClickListener(this);
            mail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            GoldBuildExpo goldBuildExpo = goldBuildExpoArrayList.get(getAdapterPosition());
            ClickListener clickListener = (ClickListener) context;
            switch (v.getId()) {
                case R.id.gold_build_expo_company_img:
                    showImageInDialog(goldBuildExpo);
                    break;
                case R.id.gold_build_expo_card_view:
                    Bundle bundle = new Bundle();
                    bundle.putString(Util.RESULT_COMPANY_NAME, goldBuildExpo.getCompanyName());
                    bundle.putString(Util.RESULT_CONTACT_PERSON, goldBuildExpo.getContactPerson());
                    bundle.putString(Util.RESULT_SUMMERY, goldBuildExpo.getSummery());
                    bundle.putString(Util.RESULT_FEATURE_PROJECTS, goldBuildExpo.getFeatureProjects());
                    bundle.putString(Util.RESULT_PRESENT_PROJECTS, goldBuildExpo.getPresentProjects());
                    bundle.putString(Util.RESULT_PAST_PROJECTS, goldBuildExpo.getPreviousProjects());
                    clickListener.onClick(v, getAdapterPosition(), bundle);
                    break;
                case R.id.gold_build_expo_phone_icon:
                    clickListener.onClickPhone(goldBuildExpo.getPhoneNumber());
                    break;
                case R.id.gold_build_expo_mail_icon:
                    clickListener.onClickMail(goldBuildExpo.getEmail());
                    break;
            }
        }

        private void showImageInDialog(GoldBuildExpo goldBuildExpo) {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custome_image_view_dialog);
            dialog.show();
            ImageView imageView = (ImageView) dialog.findViewById(R.id.custom_dialog_image_view);
            imageView.setImageResource(goldBuildExpo.getImage());
        }
    }
}
