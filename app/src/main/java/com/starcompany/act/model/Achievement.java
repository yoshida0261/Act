package com.starcompany.act.model;


import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

@Table
public class Achievement {

    public static final String TAG = Achievement.class.getSimpleName();

    @PrimaryKey(autoincrement = true)
    public long id;

    @Column(indexed = true)
    public String title;


    @Column
    @Nullable
    public String content;

    @Column
    public long count;

}
