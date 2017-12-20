package com.starcompany.act.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.starcompany.act.presentation.model.Achievement;
import com.starcompany.act.presentation.model.OrmaDatabase;
import com.starcompany.act.presentation.model.Task;
import com.starcompany.act.presentation.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class TaskFragment extends ListFragment {

    private static final String TAG = "TaskFragment";
    public TaskFragment(){}

    private OrmaDatabase orma;
    private Activity activity;

    private int tappedPosition = 0;

    private ArrayList<String> list;
    private StableArrayAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        MainActivity act = (MainActivity)getActivity();
        orma = act.orma;

        /*
        AsyncTask task = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {

                try {
                    Thread.sleep(1000);

                    orma.migrate(); // may throws SQLiteConstraintException

                    List<Achievement> titleList =   orma.selectFromAchievement()
                            .orderByTitleAsc()
                            .toList();

                    if(titleList.size() == 0){
                        Toast.makeText(getContext(), "Data  NotFound", Toast.LENGTH_SHORT).show();
                    }


                    Log.d(TAG, "------------------------");
                } catch (final Exception e) {
                    // Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
                return null;
            }
        }.execute();


*/

        list = new ArrayList<String>();
        for (int i = 0; i < Task.TaskName.length; ++i) {
            list.add(Task.TaskName[i]);
        }

        adapter = new StableArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list);
        setListAdapter(adapter);


    }

    private void deleteTask()
    {
        int position = tappedPosition;
        list.remove(position);
        adapter.notifyDataSetChanged();

    }

    private void dailyClearTask()
    {

        if(list.size() == 0){

            DailyDialogFragment d = new DailyDialogFragment();

            /*

            final MyDialogFragment dialog = new MyDialogFragment();
        dialog.setTargetFragment(this, 100);
        dialog.setArguments(bundle("aaa", "bbb", "ccc", "ddd"));
        dialog.show(getChildFragmentManager(), "my_dialog");
             */
            d.setTargetFragment(this, 100);
            d.show(getChildFragmentManager(), "my_dialog");
            //d.onCreateDialog(null);
            //Toast.makeText(v.getContext(), "やったね！", Toast.LENGTH_LONG).show();

        }
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
            tappedPosition = position;
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

        String taskName = list.get(position);
        Toast.makeText(v.getContext(), taskName, Toast.LENGTH_SHORT).show();

        //Achievement_Selector selector = orma.selectFromAchievement().titleEq(Task.TaskName[position])
         //       .orderByTitleDesc();


        this.deleteTask();

        this.dailyClearTask();
        // TODO 同じIDのタスクを取得する

        // TODO 更新処理
        Achievement achievement = new Achievement();
            achievement.title = Task.TaskName[position];
        achievement.content = "補足とくになし";

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
                   // Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
                return null;
            }
        }.execute();



        Log.i(TAG, "Achivement pos=>" + position + " : id=> " + id + " : Ach=>" + Task.TaskName[position]);
    }


}
