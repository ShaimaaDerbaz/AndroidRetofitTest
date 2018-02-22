package com.example.shaimaaderbaz.retrofittest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.retrofittest.R;
import com.example.shaimaaderbaz.retrofittest.models.FeaturesResults;
import com.example.shaimaaderbaz.retrofittest.models.PropertiesEarthquake;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/3/2018.
 */

public class EearthquakeAdapter extends  RecyclerView.Adapter<EearthquakeAdapter.ViewHolder> {
    private List<FeaturesResults> mItems;
    private Context mContext;
    private PostItemListener mItemListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public TextView magnitude;
        public TextView location;
        public TextView time;
        public TextView url;
        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener)
        {
            super(itemView);
            magnitude = (TextView) itemView.findViewById(R.id.item_mgt_text_view);
            location = (TextView) itemView.findViewById(R.id.item_loc_text_view);
            time = (TextView) itemView.findViewById(R.id.item_time_text_view);
            url = (TextView) itemView.findViewById(R.id.item_url_text_view);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            FeaturesResults item = getItem(getAdapterPosition());
          //  this.mItemListener.onPostClick(item.getTime());

            notifyDataSetChanged();
        }
    }

    public EearthquakeAdapter( List<FeaturesResults> posts, PostItemListener itemListener) {
        mItems = posts;
       // mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public EearthquakeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EearthquakeAdapter.ViewHolder holder, int position)
    {

        FeaturesResults item = mItems.get(position);
        TextView textViewMgt = holder.magnitude;
        textViewMgt.setText(item.getProperties().getMagnitude()+"");
        TextView textViewLoc = holder.location;
        textViewLoc.setText(item.getProperties().getLocation()+"");
        TextView textViewTime = holder.time;
        textViewTime.setText(item.getProperties().getTime()+"");
        TextView textViewUrl = holder.url;
        textViewUrl.setText(item.getProperties().getUrl()+"");
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateEarthquake(List<FeaturesResults> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private FeaturesResults getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }

///////////////////////////////////////////////



}
