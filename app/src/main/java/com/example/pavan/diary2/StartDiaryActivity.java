package com.example.pavan.diary2;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class StartDiaryActivity extends AppCompatActivity {

    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_diary);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        TextView title = (TextView) findViewById(R.id.title);
        TextView date = (TextView) findViewById(R.id.date);


        Intent intent = getIntent();
        String title_message = intent.getStringExtra(MainDiary.TITLE);
        title.setText(title_message);
        title.setTextSize(25);

        String date_message = intent.getStringExtra(MainDiary.DATE);
        //Log.d("date",date_message);
        date.setText(date_message);
        date.setTextSize(15);

        ImageView attachfile = (ImageView) findViewById(R.id.attachfile);
        attachfile.setOnClickListener(new View.OnClickListener(){
            int button01pos = 0;
            TableLayout attach_fileTable;

            @Override
            public void onClick(View v) {
                if (button01pos == 0) {
                    attach_fileTable = (TableLayout) findViewById(R.id.attach_file);
                    attach_fileTable.setVisibility(View.VISIBLE);
                    button01pos = 1;
                } else if (button01pos == 1) {
                    attach_fileTable.setVisibility(View.INVISIBLE);
                    button01pos = 0;
                }
            }

        });

    }

    public void goToCamera(View v){

    }

    public void goToGallery(View v){


    }



    public void goToAudio(View v){

    }

    public void goToLoaction(View v){

    }


    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }


}
