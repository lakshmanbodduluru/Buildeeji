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
import admi.buildeeji.listeners.ClickListener;

/**
 * Created by Admin on 7/19/2016.
 */
public class BasicBuildExpoAdapter extends RecyclerView.Adapter<BasicBuildExpoAdapter.BuildExpoViewHolder> {

    ArrayList<BasicBuildExpo> buildExpoArrayList;
    Context context;
    LayoutInflater inflater;

    public BasicBuildExpoAdapter(Context context, ArrayList<BasicBuildExpo> buildExpoArrayList) {
        this.context = context;
        this.buildExpoArrayList = buildExpoArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BuildExpoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_bild_expo_recycler_view, parent, false);
        BuildExpoViewHolder buildExpoViewHolder = new BuildExpoViewHolder(view);
        return buildExpoViewHolder;
    }

    @Override
    public void onBindViewHolder(BuildExpoViewHolder holder, int position) {
        BasicBuildExpo buildExpo = buildExpoArrayList.get(position);
        holder.companyName.setText(buildExpo.getCompanyName());
        holder.contactPerson.setText(buildExpo.getContactPerson());
        holder.companyImage.setImageResource(buildExpo.getImage());
    }

    @Override
    public int getItemCount() {
        return buildExpoArrayList.size();
    }

    public class BuildExpoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView companyName;
        TextView contactPerson;
        ImageView companyImage;
        ImageView mail;
        ImageView phone;
        CardView cardView;


        public BuildExpoViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.basic_build_expo_card_view);
            companyName = (TextView) view.findViewById(R.id.basic_build_expo_company_name_tv);
            contactPerson = (TextView) view.findViewById(R.id.basic_build_expo_contact_person_tv);
            companyImage = (ImageView) view.findViewById(R.id.basic_build_expo_company_image);
            mail = (ImageView) view.findViewById(R.id.basic_build_expo_mail_icon);
            phone = (ImageView) view.findViewById(R.id.basic_build_expo_phone_icon);
            companyImage.setOnClickListener(this);
            cardView.setOnClickListener(this);
            mail.setOnClickListener(this);
            phone.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            BasicBuildExpo basicBuildExpo = buildExpoArrayList.get(getAdapterPosition());
            ClickListener clickListener = (ClickListener) context;
            switch (v.getId()) {
                case R.id.basic_build_expo_company_image:
                    showImageInDialog(basicBuildExpo);
                    break;
                case R.id.basic_build_expo_card_view:
                    Bundle bundle = new Bundle();
                    bundle.putString(Util.RESULT_COMPANY_NAME, basicBuildExpo.getCompanyName());
                    bundle.putString(Util.RESULT_CONTACT_PERSON, basicBuildExpo.getContactPerson());
                    bundle.putString(Util.RESULT_SUMMERY, basicBuildExpo.getSummery());
                    bundle.putString(Util.RESULT_FEATURE_PROJECTS, basicBuildExpo.getFeatureProjects());
                    bundle.putString(Util.RESULT_PRESENT_PROJECTS, basicBuildExpo.getPresentProjects());
                    bundle.putString(Util.RESULT_PAST_PROJECTS, basicBuildExpo.getPreviousProjects());
                    clickListener.onClick(v, getAdapterPosition(), bundle);
                    break;
                case R.id.basic_build_expo_phone_icon:
                    clickListener.onClickPhone(basicBuildExpo.getPhoneNumber());
                    break;
                case R.id.basic_build_expo_mail_icon:
                    clickListener.onClickMail(basicBuildExpo.getEmail());
                    break;
            }
        }

        private void showImageInDialog(BasicBuildExpo basicBuildExpo) {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custome_image_view_dialog);
            dialog.show();
            ImageView imageView = (ImageView) dialog.findViewById(R.id.custom_dialog_image_view);
            imageView.setImageResource(basicBuildExpo.getImage());
        }
    }
}
