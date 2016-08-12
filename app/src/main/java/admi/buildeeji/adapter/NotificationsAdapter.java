package admi.buildeeji.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import admi.buildeeji.R;
import admi.buildeeji.bin.Notifications;

/**
 * Created by Admin on 7/19/2016.
 */
public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder> {

    Context context;
    ArrayList<Notifications> notificationsArrayList;
    LayoutInflater inflater;

    public NotificationsAdapter(Context context, ArrayList<Notifications> notificationsArrayList) {
        this.context = context;
        this.notificationsArrayList = notificationsArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NotificationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_notfication_recycler_view, parent, false);
        NotificationsViewHolder notificationsViewHolder = new NotificationsViewHolder(view);
        return notificationsViewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationsViewHolder holder, int position) {
        Notifications notifications = notificationsArrayList.get(position);
        holder.companyName.setText(notifications.getCompanyName());
        holder.contactPerson.setText(notifications.getContactPerson());
        holder.dateTime.setText(notifications.getDateTime());
    }

    @Override
    public int getItemCount() {
        return notificationsArrayList.size();
    }

    public class NotificationsViewHolder extends RecyclerView.ViewHolder {
        TextView companyName;
        TextView contactPerson;
        TextView dateTime;

        public NotificationsViewHolder(View view) {
            super(view);
            companyName = (TextView) view.findViewById(R.id.notification_company_name_tv);
            contactPerson = (TextView) view.findViewById(R.id.notification_contact_person_tv);
            dateTime = (TextView) view.findViewById(R.id.notification_date_time_tv);
        }
    }
}
