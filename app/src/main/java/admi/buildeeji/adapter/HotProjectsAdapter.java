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
import admi.buildeeji.bin.GoldBuildExpo;
import admi.buildeeji.bin.HotProjects;
import admi.buildeeji.listeners.ClickListener;

/**
 * Created by Admin on 7/19/2016.
 */
public class HotProjectsAdapter extends RecyclerView.Adapter<HotProjectsAdapter.HotProjectsViewHolder> {

    ArrayList<HotProjects> hotProjectsArrayList;
    Context context;
    LayoutInflater inflater;

    public HotProjectsAdapter(Context context, ArrayList<HotProjects> hotProjectsArrayList) {
        this.context = context;
        this.hotProjectsArrayList = hotProjectsArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HotProjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_hot_projects_recycler_view, parent, false);
        HotProjectsViewHolder hotProjectsViewHolder = new HotProjectsViewHolder(view);
        return hotProjectsViewHolder;
    }

    @Override
    public void onBindViewHolder(HotProjectsViewHolder holder, int position) {
        HotProjects hotProjects = hotProjectsArrayList.get(position);
        holder.companyName.setText(hotProjects.getCompanyName());
        holder.contactPerson.setText(hotProjects.getContactPerson());
        holder.companyImage.setImageResource(hotProjects.getImage());
    }

    @Override
    public int getItemCount() {
        return hotProjectsArrayList.size();
    }

    public class HotProjectsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView companyName;
        TextView contactPerson;
        ImageView companyImage;
        ImageView mail;
        ImageView phone;
        CardView cardView;

        public HotProjectsViewHolder(View view) {
            super(view);
            companyName = (TextView) view.findViewById(R.id.hot_projects_company_name_tv);
            contactPerson = (TextView) view.findViewById(R.id.hot_projects_contact_person_tv);
            companyImage = (ImageView) view.findViewById(R.id.hot_projects_company_img);
            mail = (ImageView) view.findViewById(R.id.hot_projects_mail_icon);
            phone = (ImageView) view.findViewById(R.id.hot_projects_phone_icon);
            cardView = (CardView) view.findViewById(R.id.hot_projects_card_view);
            companyImage.setOnClickListener(this);
            cardView.setOnClickListener(this);
            phone.setOnClickListener(this);
            mail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ClickListener clickListener = (ClickListener) context;
            HotProjects hotProjects = hotProjectsArrayList.get(getAdapterPosition());
            switch (v.getId()) {
                case R.id.hot_projects_company_img:
                    showImageInDialog(hotProjects);
                    break;
                case R.id.hot_projects_card_view:
                    Bundle bundle = new Bundle();
                    bundle.putString(Util.RESULT_COMPANY_NAME, hotProjects.getCompanyName());
                    bundle.putString(Util.RESULT_CONTACT_PERSON, hotProjects.getContactPerson());
                    bundle.putString(Util.RESULT_SUMMERY, hotProjects.getSummery());
                    bundle.putString(Util.RESULT_FEATURE_PROJECTS, hotProjects.getFeatureProjects());
                    bundle.putString(Util.RESULT_PRESENT_PROJECTS, hotProjects.getPresentProjects());
                    bundle.putString(Util.RESULT_PAST_PROJECTS, hotProjects.getPreviousProjects());
                    clickListener.onClick(v, getAdapterPosition(), bundle);
                    break;
                case R.id.hot_projects_phone_icon:
                    clickListener.onClickPhone("9494896482");
                    break;
                case R.id.hot_projects_mail_icon:
                    clickListener.onClickMail("lakshman.bodduluru@gmail.com");
                    break;
            }
        }

        private void showImageInDialog(HotProjects hotProjects) {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custome_image_view_dialog);
            dialog.show();
            ImageView imageView = (ImageView) dialog.findViewById(R.id.custom_dialog_image_view);
            imageView.setImageResource(hotProjects.getImage());
        }
    }
}
