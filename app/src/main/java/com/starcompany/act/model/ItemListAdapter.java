package com.starcompany.act.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.starcompany.act.R;

import java.util.ArrayList;


public class ItemListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    private static final int resource = R.layout.custom_listview_item;

    public ItemListAdapter(Context context, String[] values){
        super(context, -1, values);
        this.context = context;
        this.values = values;



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        // change the icon for Windows and iPhone
        String s = values[position];
        */
        /*
        if (s.startsWith("iPhone")) {
            imageView.setImageResource(R.drawable.no);
        } else {
            imageView.setImageResource(R.drawable.ok);
        }*/

        /*
        View view;

        // テンプレート処理。
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }

        // データをgetItemで取る
        Item item = getItem(position);

        TextView id = (TextView) view.findViewById(R.id.id);
        id.setText(item.id);
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(item.name);
*/

        return null;
    }

    // 設定されている CustomListItem の ArrayList を返す。
    // 縦横切替などでデータを移行するために使う。
    public ArrayList<Item> getItemList() {
        // 今回は Bundle#putParcelableArrayList() を使うことを想定する。
        // 必要に応じて Bundle#putSparseParcelableArray() を使ってもいい。

        int size = getCount();
        ArrayList<Item> itemList = new ArrayList<Item>(size);
        for (int index = 0; index < size; index++) {
           // itemList.add(getItem(index));
        }
        return itemList;
    }

    // Bundleから復元するときに必要になるはず。
    public void addAll(ArrayList<Item> parcelableArrayList) {
        // 強制でキャスト。落ちる場合は、設計か実装が間違っている。
        @SuppressWarnings("unchecked")
        ArrayList<Item> itemList = (ArrayList<Item>) parcelableArrayList;
        //super.addAll(itemList);
    }

    public void add(String id, String name) {
        Item item = new Item(id, name);
       // super.add(item);
    }

    // 削除
    public void remove(int index) {
        if (index < 0 || index >= getCount()) {
            return;
        }
        remove(getItem(index));
    }
}
