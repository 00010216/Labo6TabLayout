package com.example.kcruz.labo6tabs.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kcruz.labo6tabs.R;
import com.example.kcruz.labo6tabs.adapters.RestaurantListAdapter;
import com.example.kcruz.labo6tabs.models.Restaurant;
import com.example.kcruz.labo6tabs.utils.SharedPreference;

import java.util.List;

public class RestaurantsFragment extends Fragment implements RestaurantListAdapter.RestaurantListClickListener
{

    public static final String ARG_ITEM_ID = "restaurant_list";

    Activity activity;
    RecyclerView restaurantListView;
    List<Restaurant> restaurants;
    RestaurantListAdapter restaurantListAdapter;
    LinearLayoutManager lManager;

    SharedPreference sharedPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        sharedPreference = new SharedPreference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container,
                false);
        findViewsById(view);
        restaurantListView.setHasFixedSize(true);

        lManager = new LinearLayoutManager(container.getContext());
        restaurantListView.setLayoutManager(lManager);

        setRestaurants();

        restaurantListAdapter = new RestaurantListAdapter(activity, restaurants, this);
        restaurantListView.setAdapter(restaurantListAdapter);
        return view;
    }

    private void setRestaurants() {

    }

    private void findViewsById(View view) {
        restaurantListView = (RecyclerView) view.findViewById(R.id.list_restaurants);
    }

    @Override
    public void onResume() {
        getActivity().setTitle(R.string.app_name);
        //getActivity().getSupportActionBar().setTitle(R.string.app_name);
        super.onResume();
    }

    @Override
    public void onProductClick(View v, int position) {
        System.out.println("POSITION OBTENIDA"+position);
        Restaurant p = restaurants.get(position);
        Toast.makeText(activity, p.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProductLongClick(View v, int position) {
        ImageView button = (ImageView) v.findViewById(R.id.imgbtn_favorite);

        String tag = button.getTag().toString();
        if(tag.equalsIgnoreCase("grey")){
            sharedPreference.addFavorite(activity, restaurants.get(position));
            Toast.makeText(activity,
                    activity.getResources().getString(R.string.add_favr),
                    Toast.LENGTH_SHORT).show();

            button.setTag("red");
            button.setImageResource(R.drawable.ic_fav);
        } else {
            sharedPreference.removeFavorite(activity, restaurants.get(position));
            button.setTag("grey");
            button.setImageResource(R.drawable.ic_fav_border);
            Toast.makeText(activity,
                    activity.getResources().getString(R.string.remove_favr),
                    Toast.LENGTH_SHORT).show();
        }
    }
}

