package com.example.benet.restaurantapp.model;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benet.restaurantapp.R;
import com.example.benet.restaurantapp.test.MainActivity;

/**
 * Created by Benet on 18/02/15.
 */
public class ManagerFragmentDetail extends Fragment {

    private WebView web;
    private Restaurant restaurant;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arg=getArguments();
        if(arg!=null){
             restaurant=(Restaurant)arg.getSerializable(MainActivity.SEND_DATA_DETAIL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initComponents();
    }
    public void initComponents(){

       web=(WebView)getActivity().findViewById(R.id.detail_web);
       web.loadUrl(restaurant.getWeb().toString());
    }

}
