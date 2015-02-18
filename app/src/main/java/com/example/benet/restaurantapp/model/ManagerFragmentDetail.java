package com.example.benet.restaurantapp.model;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
            Log.e("ManagerFragmentDetail", " arrgs bundle recived");
             restaurant=(Restaurant)arg.getSerializable(MainActivity.SEND_DATA_DETAIL);
        }else{Log.e("ManagerFragmentDetail", " arrgs bundle not recived");}
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
       web.loadUrl(restaurant.getWeb()+"");

        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

}
