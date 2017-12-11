package com.starcompany.act.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.starcompany.act.R;
import com.starcompany.act.presentation.model.OrmaDatabase;

public class MainActivity extends AppCompatActivity {

    public OrmaDatabase orma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);





        if(orma == null) {
           orma = OrmaDatabase.builder(this).build();
        }

    }

}
