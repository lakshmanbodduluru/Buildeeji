package admi.buildeeji.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import admi.buildeeji.R;
import admi.buildeeji.bin.Home;
import admi.buildeeji.listeners.ClickListener;

/**
 * Created by Admin on 7/18/2016.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    ArrayList<Home> homeArrayList;
    Context context;
    LayoutInflater inflater;

    public HomeAdapter(Context context, ArrayList<Home> homeArrayList) {
        this.context = context;
        this.homeArrayList = homeArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_home_recycler_view, parent, false);
        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        Home home = homeArrayList.get(position);
        holder.textView.setText(home.getName());
        holder.imageView.setImageResource(home.getImages());

    }

    @Override
    public int getItemCount() {
        return homeArrayList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageView imageView;
        CardView cardView;

        public HomeViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.home_recycle_text_view);
            imageView = (ImageView) view.findViewById(R.id.home_image_view);
            cardView = (CardView) view.findViewById(R.id.home_card_view);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Home home = homeArrayList.get(getAdapterPosition());
            switch (v.getId()) {
                case R.id.home_card_view:
                    clickCardView(v, getAdapterPosition());
                    break;
            }
        }
    }

    private void clickCardView(View view, int adapterPosition) {
        ClickListener clickListener = (ClickListener) context;
        switch (adapterPosition) {
            case 0:
                Bundle bundle = new Bundle();
                clickListener.onClick(view, adapterPosition, bundle);
                break;
            case 1:
                Bundle bundle1 = new Bundle();
                clickListener.onClick(view, adapterPosition, bundle1);
                break;
            case 2:
                Toast.makeText(context, "Recent Activity", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(context, "Short List", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(context, "Properties For Sale", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(context, "Properties For Rent", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(context, "Under Construction Properties", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(context, "Ready To Move Property", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
