package com.example.benet.restaurantapp.model;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.benet.restaurantapp.R;
import com.example.benet.restaurantapp.test.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benet on 17/02/15.
 */
public class ManagerFragmentList extends Fragment implements AdapterView.OnItemClickListener {

    private OnMySelectedListener mCallbcak;
    private ListView list;
    private MyAdapter adapter;
    private List<Restaurant> data;
    private Activity context;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbcak=(OnMySelectedListener)activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context=getActivity();

        //recuperar los argumentos que hayan sido pasdos por la main activity
        Bundle args=getArguments();
        if(args!=null){
            this.data= (List<Restaurant>) args.getSerializable(MainActivity.SEND_DATA_LIST);
        }


    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initComponents();
    }

    public void initComponents(){

        list=(ListView)this.getActivity().findViewById(R.id.lista);
        this.adapter=new MyAdapter(context, data ,R.layout.model_item_lista);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mCallbcak.onMyListItemSelected(position);
        //Toast.makeText(context,"Pulsado item "+(position+1),Toast.LENGTH_SHORT).show();

    }

    public interface  OnMySelectedListener{
        public void onMyListItemSelected(int position);
    }
}
