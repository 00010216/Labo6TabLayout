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
import com.example.kcruz.labo6tabs.utils.SharedPreference;

import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>{
    private Context mContext;
    List<Restaurant> mRestaurants;
    SharedPreference sharedPreference;

    public interface RestaurantListClickListener{
        public void onProductClick(View v, int position);
        public void onProductLongClick(View v, int position);

    }
    private RestaurantListClickListener mListener;

    public RestaurantListAdapter(Context context, List<Restaurant> restaurants, RestaurantListClickListener mListener){
        mContext = context;
        mRestaurants = restaurants;
        this.mListener = mListener;
        sharedPreference = new SharedPreference();
    }


    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        //indica la vista donde se ubicaran la informaciond de la lista
        CardView card;
        ImageView img;
        TextView title;
        ImageView favoriteImg;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            favoriteImg = itemView.findViewById(R.id.imgbtn_favorite);

        }
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false);
        return (new RestaurantViewHolder(view));
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, final int position) {
        final Restaurant restaurant = (Restaurant) mRestaurants.get(position);
        holder.img.setImageResource(mRestaurants.get(position).getPhoto());
        holder.title.setText(mRestaurants.get(position).getName());

        if (checkFavoriteItem(restaurant)) {
            holder.favoriteImg.setImageResource(R.drawable.ic_fav);
            holder.favoriteImg.setTag("red");
        } else {
            holder.favoriteImg.setImageResource(R.drawable.ic_fav_border);
            holder.favoriteImg.setTag("grey");
        }

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onProductClick(v, position);
            }
        });

        holder.favoriteImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onProductLongClick(v, position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public boolean checkFavoriteItem(Restaurant checkRestaurant) {
        boolean check = false;
        List<Restaurant> favorites = sharedPreference.getFavorites(mContext);
        if (favorites != null) {
            for (Restaurant restaurant : favorites) {
                if (restaurant.equals(checkRestaurant)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public void remove(Restaurant restaurant) {
        //super.remove(product);
        mRestaurants.remove(restaurant);
        notifyDataSetChanged();
    }
}
