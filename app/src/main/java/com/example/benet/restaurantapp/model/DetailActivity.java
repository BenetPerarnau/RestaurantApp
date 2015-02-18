package com.example.benet.restaurantapp.model;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.benet.restaurantapp.R;
import com.example.benet.restaurantapp.test.MainActivity;

import java.util.ArrayList;

public class DetailActivity extends ActionBarActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent=getIntent();

        Bundle arg=new Bundle();

        arg.putSerializable(MainActivity.SEND_DATA_DETAIL,(Restaurant)intent.getSerializableExtra(MainActivity.SEND_DATA_DETAIL));

        ManagerFragmentDetail fragmentDetail=new ManagerFragmentDetail();
        fragmentDetail.setArguments(arg);

        this.fragmentManager=getFragmentManager();
        this.fragmentTransaction=this.fragmentManager.beginTransaction();
        this.fragmentTransaction.add(R.id.container_detail,fragmentDetail);
        this.fragmentTransaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
}
