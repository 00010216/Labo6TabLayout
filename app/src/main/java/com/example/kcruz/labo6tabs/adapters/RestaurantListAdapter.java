package com.example.kcruz.labo6tabs.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kcruz.labo6tabs.R;
import com.example.kcruz.labo6tabs.models.Restaurant;

import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>{
    private Context context;
    List<Restaurant> restaurants;

    public RestaurantListAdapter(Context mContext, List<Restaurant> mRestaurants) {
        context = mContext;
        restaurants = mRestaurants;
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        //indica la vista donde se ubicaran la informaciond de la lista
        CardView card;
        ImageView img;
        TextView title,description;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_item,parent,false);
        return (new RestaurantViewHolder(view));
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        holder.img.setImageResource(restaurants.get(position).getPhoto());
        holder.title.setText(restaurants.get(position).getName());
        holder.description.setText(restaurants.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

}
