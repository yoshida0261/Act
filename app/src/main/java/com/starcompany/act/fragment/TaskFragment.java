package com.starcompany.act.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.starcompany.act.model.Task;

/**
 * Created by takeshi on 16/12/09.
 */
public class TaskFragment extends ListFragment {

    public TaskFragment(){}

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                Task.TaskName
        ));
    }
}
