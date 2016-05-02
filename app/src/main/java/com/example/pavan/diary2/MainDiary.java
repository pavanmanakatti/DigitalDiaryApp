package com.example.pavan.diary2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;



public class MainDiary extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    public final static String TITLE = "Diary Title";
    public final static String DATE = "Diary Date";
    String selectedDate;

    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_diary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_newdiary) {
            getDrawerToggleDelegate(); //close drawer
            //open dialog box and ask for title and date
            showDialog();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {


        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public void showDialog(){

        final EditText title_message;
        final CalendarView date;
        Button okbutton;


        final Dialog titledatedialog = new Dialog(this);

        titledatedialog.setContentView(R.layout.newdiary);



        TextView title = new TextView(this);
        title.setText("Enter Title and Date");
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setTextSize(20);


        titledatedialog.setTitle(title.toString());

        title_message = (EditText) titledatedialog.findViewById(R.id.title);
        date = (CalendarView) titledatedialog.findViewById(R.id.date);
        okbutton = (Button) titledatedialog.findViewById(R.id.ok);


        date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                StringBuilder sb = new StringBuilder();
                sb.append(dayOfMonth).append("/").append(month).append("/").append(year);
                selectedDate = sb.toString();
            }
        });

        okbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(getBaseContext(), StartDiaryActivity.class);
                if (title_message.getText().toString().length() == 0)
                    title_message.setError("Title is required!");
                else {
                    String message = title_message.getText().toString();
                    intent.putExtra(TITLE, message);
                    intent.putExtra(DATE, selectedDate);
                    startActivity(intent);
                }

                //if( selectedDate.length() == 0 )
                //selectedDate.setError( "Date is required!" );


            }
        });


        //AlertDialog dialog = builder.create();
        titledatedialog.show();
    }
}
