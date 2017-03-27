package com.starcompany.act.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.starcompany.act.R;
import com.starcompany.act.activity.MainActivity;
import com.starcompany.act.model.OrmaDatabase;
import com.starcompany.act.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TaskFragment extends ListFragment {

    private static final String TAG = "TaskFragment";
    public TaskFragment(){}

    private OrmaDatabase orma;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {



        super.onActivityCreated(savedInstanceState);


        //final ListView listview = (ListView) getActivity().findViewById(R.id.listview);


        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        /*
        final StableArrayAdapter adapter = new StableArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list);
*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.custom_listview_item2, values);
        setListAdapter(adapter);
        //listview.setAdapter(adapter);
       // setListAdapter(adapter);

        /*
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                //android.R.layout.simple_list_item_1,
                R.layout.custom_listview_item2,

                Task.TaskName
        ));
        */

        MainActivity act = (MainActivity)getActivity();
        orma = act.orma;

    }


    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Toast.makeText(v.getContext(), Task.TaskName[position], Toast.LENGTH_SHORT).show();

        //Achievement_Selector selector = orma.selectFromAchievement().titleEq(Task.TaskName[position])
         //       .orderByTitleDesc();
        /*
        Achievement achievement = new Achievement();
            achievement.title = Task.TaskName[position];
            achievement.count = 1;
        achievement.content = "補足とくになし";
*/
        //Achievement achievement = new Achievement(position, Task.TaskName[position], "none", 1);

        /*
        AsyncTask task = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {

                try {
                    Thread.sleep(1000);

                    orma.migrate(); // may throws SQLiteConstraintException

                    Log.d(TAG, "CRUD:start ------------------------");
                    Achievement achievement = new Achievement();
                    achievement.title = Task.TaskName[0];
                    achievement.content = "none";
                    achievement.count  = 1;


                    orma.insertIntoAchievement(achievement);


                    Log.d(TAG, "------------------------");
                } catch (final Exception e) {
                    Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
                return null;
            }
        }.execute();
        */

        Log.i(TAG, "Achivement pos=>" + position + " : id=> " + id + " : Ach=>" + Task.TaskName[position]);
    }


}
