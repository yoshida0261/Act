package com.starcompany.act.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.starcompany.act.R;

import java.util.List;

public class ListSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_list);
        PackageManager packageManager = getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(PackageManager.GET_ACTIVITIES);

        CardListAdapter adapter = new CardListAdapter(getApplicationContext());

        if (packageInfoList != null) {
            for (PackageInfo info : packageInfoList) {
                adapter.add(info);
            }
        }

        int padding = (int) (getResources().getDisplayMetrics().density * 8);
        ListView listView = (ListView) findViewById(R.id.card_list);
        listView.setPadding(padding, 0, padding, 0);
        listView.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);
        listView.setDivider(null);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        //View header = inflater.inflate(R.layout.list_header_footer, listView, false);
        //View footer = inflater.inflate(R.layout.list_header_footer, listView, false);
        //listView.addHeaderView(header, null, false);
        //listView.addFooterView(footer, null, false);
        listView.setAdapter(adapter);
    }

}
