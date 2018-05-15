package com.example.kcruz.labo6tabs.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.kcruz.labo6tabs.models.Restaurant;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {
    public static final String SHARED_PREFS_NAME = "RESTAURANT_APP_TEST";
    public static final String FAVS = "Restaurant_Favorite";

    public SharedPreference(){
        super();
    }

    //Los siguientes 4 metodos se usan para manejar los favoritos

    public void saveFavorites (Context c, List<Restaurant> favs){
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = c.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        editor  = settings.edit();

        Gson gson = new Gson();
        String jsonFavs = gson.toJson(favs);

        editor.putString(FAVS ,jsonFavs);
        editor.commit();
    }

    public ArrayList<Restaurant> getFavorites(Context c){
        SharedPreferences settings;
        List<Restaurant> favs;

        settings = c.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);

        if(settings.contains(FAVS)){
            String jsonFavs = settings.getString(FAVS, null);
            Gson g = new Gson();
            Restaurant[] favItems = g.fromJson(jsonFavs, Restaurant[].class);

            favs = Arrays.asList(favItems);
            favs = new ArrayList<Restaurant>(favs);
        } else return null;

        return (ArrayList<Restaurant>) favs;
    }

    public void addFavorite(Context c, Restaurant p){
        List<Restaurant> favs = getFavorites(c);
        if(favs == null) favs = new ArrayList<Restaurant>();
        favs.add(p);
        saveFavorites(c, favs);
    }

    public void removeFavorite(Context c, Restaurant p){
        ArrayList<Restaurant> favs = getFavorites(c);
        if(favs != null) {
            favs.remove(p);
            saveFavorites(c, favs);
        }
    }
}
