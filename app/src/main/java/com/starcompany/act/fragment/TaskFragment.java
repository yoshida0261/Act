package com.starcompany.act.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.starcompany.act.activity.MainActivity;
import com.starcompany.act.model.Achievement;
import com.starcompany.act.model.OrmaDatabase;
import com.starcompany.act.model.Task;

/**
 * Created by takeshi on 16/12/09.
 */
public class TaskFragment extends ListFragment {

    private static final String TAG = "TaskFragment";
    public TaskFragment(){}

    private OrmaDatabase orma;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                Task.TaskName
        ));

        MainActivity act = (MainActivity)getActivity();
        orma = act.orma;

    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Toast.makeText(v.getContext(), Task.TaskName[position], Toast.LENGTH_SHORT).show();

        // タップしたitemを保存

        // itemを削除

        Achievement achievement = new Achievement();
        achievement.title = Task.TaskName[position];



        Log.i(TAG, "Achivement pos=>" + position + " : id=> " + id + " : Ach=>" + Task.TaskName[position]);
    }


}
