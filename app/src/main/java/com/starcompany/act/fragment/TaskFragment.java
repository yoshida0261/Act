package com.starcompany.act.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.starcompany.act.model.Task;

/**
 * Created by takeshi on 16/12/09.
 */
public class TaskFragment extends ListFragment {

    private static final String TAG = "TaskFragment";
    public TaskFragment(){}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                Task.TaskName
        ));
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Toast.makeText(v.getContext(), Task.TaskName[position], Toast.LENGTH_SHORT).show();

        // タップしたitemを保存

        // itemを削除


        Log.d(TAG, "onListItemClick position => " + position + " : id => " + id);
    }


}
