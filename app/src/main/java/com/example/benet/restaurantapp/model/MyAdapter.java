package com.example.benet.restaurantapp.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benet.restaurantapp.R;

import java.util.List;

/**
 * Created by Benet on 17/02/15.
 */
public class MyAdapter extends BaseAdapter {

    private Activity view;
    private List<Restaurant> data;
    private int layout;
    private LayoutInflater layoutInflater;

    public MyAdapter(Activity view, List<Restaurant> data, int item_layout){

        this.view=view;
        this.data=data;
        this.layout=item_layout;

        this.layoutInflater=(LayoutInflater)this.view.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){convertView=this.layoutInflater.inflate(layout,null);}

        ImageView img=(ImageView)convertView.findViewById(R.id.img);
        TextView name=(TextView)convertView.findViewById(R.id.label_name);
        TextView city=(TextView)convertView.findViewById(R.id.label_ciudad);
        TextView zone=(TextView)convertView.findViewById(R.id.label_zona);

        img.setImageResource(data.get(position).getImg());
        name.setText(data.get(position).getName());
        city.setText(data.get(position).getCiudad());
        zone.setText(data.get(position).getZona());

        return convertView;
    }
}
