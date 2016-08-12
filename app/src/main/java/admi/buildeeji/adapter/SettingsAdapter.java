package admi.buildeeji.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import admi.buildeeji.R;
import admi.buildeeji.bin.Settings;

/**
 * Created by Admin on 7/19/2016.
 */
public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {
    ArrayList<Settings> settingsArrayList;
    Context context;
    LayoutInflater inflater;

    public SettingsAdapter(Context context, ArrayList<Settings> settingsArrayList) {
        this.context = context;
        this.settingsArrayList = settingsArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_settings_recycler_view, parent, false);
        SettingsViewHolder settingsViewHolder = new SettingsViewHolder(view);
        return settingsViewHolder;
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, int position) {
        Settings settings = settingsArrayList.get(position);
        holder.name.setText(settings.getName());
    }

    @Override
    public int getItemCount() {
        return settingsArrayList.size();
    }

    public class SettingsViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public SettingsViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.settings_recycle_text_view);
        }
    }
}
