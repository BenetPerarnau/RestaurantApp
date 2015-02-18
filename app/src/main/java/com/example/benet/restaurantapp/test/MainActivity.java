package com.example.benet.restaurantapp.test;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;


import com.example.benet.restaurantapp.R;
import com.example.benet.restaurantapp.model.DetailActivity;
import com.example.benet.restaurantapp.model.ManagerFragmentDetail;
import com.example.benet.restaurantapp.model.ManagerFragmentList;
import com.example.benet.restaurantapp.model.Restaurant;
import com.example.benet.restaurantapp.util.Util;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements ManagerFragmentList.OnMySelectedListener{

    public static final String SEND_DATA_LIST ="send_data_list";
    public static final String SEND_DATA_DETAIL ="send_data_detail";

    private List<Restaurant> data;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Activity context;
    private Bundle arg;
    private boolean mobile=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();


        ManagerFragmentList fragmentList=new ManagerFragmentList();//fuera de las condiciones pq este siempre se cargara

        if(findViewById(R.id.container)!=null){//mobile

            arg.putSerializable(SEND_DATA_LIST, (java.io.Serializable) data);
            fragmentList.setArguments(arg);
            this.fragmentTransaction.add(R.id.container, fragmentList);

        }else{//tablet

            mobile=false;

            arg.putSerializable(SEND_DATA_LIST, (java.io.Serializable) data);
            fragmentList.setArguments(arg);
            this.fragmentTransaction.add(R.id.container_list, fragmentList);

            ManagerFragmentDetail fragmentDetail=new ManagerFragmentDetail();
            arg.putSerializable(SEND_DATA_DETAIL,data.get(0));
            fragmentDetail.setArguments(arg);

            this.fragmentTransaction.add(R.id.container_detail, fragmentDetail);

        }
        this.fragmentTransaction.commit();
    }

    public void initComponents(){
        context=this;
        arg=new Bundle();
        data=Util.getRestaurants(context);

        this.fragmentManager=getFragmentManager();
        fragmentTransaction=this.fragmentManager.beginTransaction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //comunicación con el fragment
    @Override
    public void onMyListItemSelected(int position) {

        if(mobile){

            Intent intent=new Intent(this, DetailActivity.class);
            intent.putExtra(SEND_DATA_DETAIL,data.get(position));
            startActivity(intent);

        }else{

            ManagerFragmentDetail fragmentDetail=new ManagerFragmentDetail();
            arg.putSerializable(SEND_DATA_DETAIL,data.get(position));
            fragmentDetail.setArguments(arg);
            this.fragmentTransaction=this.fragmentManager.beginTransaction();
            this.fragmentTransaction.replace(R.id.container_detail, fragmentDetail);
            this.fragmentTransaction.commit();

        }

    }
}
