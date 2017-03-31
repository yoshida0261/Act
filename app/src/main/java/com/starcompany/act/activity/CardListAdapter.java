package com.starcompany.act.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starcompany.act.R;

public class CardListAdapter extends ArrayAdapter<PackageInfo> {

    LayoutInflater mInflater;
    PackageManager packageManager;

    public CardListAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
        packageManager = context.getPackageManager();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_list_item_card, parent, false);
        }

        PackageInfo info = getItem(position);

        TextView tv = (TextView) convertView.findViewById(R.id.title);
        tv.setText(info.applicationInfo.loadLabel(packageManager));

        tv = (TextView) convertView.findViewById(R.id.sub);
        tv.setText(info.packageName + "\n" + "versionName : " + info.versionName + "\nversionCode : " + info.versionCode);

        ImageView iv = (ImageView) convertView.findViewById(R.id.icon);
        iv.setImageDrawable(info.applicationInfo.loadIcon(packageManager));


        return convertView;
    }
}
