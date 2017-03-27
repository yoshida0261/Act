package com.starcompany.act.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starcompany.act.R;
import com.starcompany.act.model.ItemListAdapter;

public class ItemListFragment extends ListFragment {

    private ItemListAdapter adapter;

    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //adapter = new ItemListAdapter(getActivity());
        //setListAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        this.getView().findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add("1", "button1");
            }
        });
        this.getView().findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add("2", "button2");
            }
        });
        this.getView().findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add("3", "button3");
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_list_fragment, container, false);
    }
}
