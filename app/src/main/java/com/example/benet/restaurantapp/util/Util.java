package com.example.benet.restaurantapp.util;

import android.app.Activity;
import android.view.View;

import com.example.benet.restaurantapp.R;
import com.example.benet.restaurantapp.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benet on 18/02/15.
 */
public class Util extends Activity {


    public static List<Restaurant> getRestaurants(Activity view){

        List<Restaurant> data=new ArrayList<Restaurant>();
        for(int j=0; j<10; j++) {
            String[] titles = view.getResources().getStringArray(R.array.list_name_restaurant);
            String[] citys = view.getResources().getStringArray(R.array.list_ciudad_restaurant);
            String[] zons = view.getResources().getStringArray(R.array.list_zona_restaurant);
            String[] webs = view.getResources().getStringArray(R.array.list_web_restaurant);
            String[] imgs = view.getResources().getStringArray(R.array.list_img_restaurant);

            for (int i = 0; i < titles.length; i++) {

                data.add(new Restaurant(titles[i],
                        zons[i],
                        citys[i],
                        webs[i], view.getResources().getIdentifier(imgs[i], "mipmap", view.getPackageName())));
            }
        }
        return data;
    }
}
