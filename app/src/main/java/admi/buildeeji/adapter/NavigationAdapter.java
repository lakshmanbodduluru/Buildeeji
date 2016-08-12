package admi.buildeeji.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import admi.buildeeji.R;

/**
 * Created by Admin on 7/14/2016.
 */
public class NavigationAdapter extends BaseExpandableListAdapter {
    private Context context;
    private HashMap<String, List<String>> moviesCategory;
    private List<String> moviesList;


    public NavigationAdapter(Context context, HashMap<String, List<String>> moviesCategory, List<String> moviesList) {
        this.context = context;
        this.moviesCategory = moviesCategory;
        this.moviesList = moviesList;
    }

    @Override
    public int getGroupCount() {
        return moviesList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return moviesCategory.get(moviesList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return moviesList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return moviesCategory.get(moviesList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custome_expandable_list_view, parent, false);
        }
        TextView parentTextView = (TextView) convertView.findViewById(R.id.expandable_list_view_text_view);
        parentTextView.setTypeface(null, Typeface.BOLD);
        parentTextView.setText(groupTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childTitle = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custome_expandable_list_view, parent, false);
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.expandable_list_view_text_view);
        childTextView.setText(childTitle);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
