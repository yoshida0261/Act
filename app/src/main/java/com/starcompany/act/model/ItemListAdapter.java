package com.starcompany.act.model;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.starcompany.act.R;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import java.util.ArrayList;

/**
 * Created by takeshi on 16/11/26.
 */
public class ItemListAdapter extends ArrayAdapter<Item> {
    // 見易さのために定義。普段は直接 getView で指定する。
    private static final int resource = R.layout.custom_listview_item;

    public ItemListAdapter(Context context){
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // super.getView() は 呼ばない(カスタムビューにしているため)
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

        // カスタムビューの場合はViewが確実にあるtry-catch は不要ためか。
        TextView id = (TextView) view.findViewById(R.id.id);
        id.setText(item.id);
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(item.name);

        return view;
    }

    // 設定されている CustomListItem の ArrayList を返す。
    // 縦横切替などでデータを移行するために使う。
    public ArrayList<Item> getItemList() {
        // 今回は Bundle#putParcelableArrayList() を使うことを想定する。
        // 必要に応じて Bundle#putSparseParcelableArray() を使ってもいい。

        int size = getCount();
        ArrayList<Item> itemList = new ArrayList<Item>(size);
        for (int index = 0; index < size; index++) {
            itemList.add(getItem(index));
        }
        return itemList;
    }

    // Bundleから復元するときに必要になるはず。
    public void addAll(ArrayList<Item> parcelableArrayList) {
        // 強制でキャスト。落ちる場合は、設計か実装が間違っている。
        @SuppressWarnings("unchecked")
        ArrayList<Item> itemList = (ArrayList<Item>) parcelableArrayList;
        super.addAll(itemList);
    }

    public void add(String id, String name) {
        Item item = new Item(id, name);
        super.add(item);
    }

    // 削除
    public void remove(int index) {
        if (index < 0 || index >= getCount()) {
            return;
        }
        remove(getItem(index));
    }
}
