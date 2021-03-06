package com.yanes.assignment2;
/**
 * Claudia and Lidia Yanes Garcia
 * Assignment 2
 * CSCI 4020
 **/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  implements View.OnClickListener {
    private static final int REQUEST_CODE_ADD = 100;
    public static int activity= 10;
    public static String Activity_KEY= "activity";
    int total[] = {0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.bfirstv);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.bsecondv);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.bthirdv);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.bfirstv) {
            activity=0;
        } else if (view.getId() == R.id.bsecondv) {
          activity=1;
        } else if (view.getId() == R.id.bthirdv) {
           activity=2;
        }

        Intent intent = new Intent(this, Firstv.class);
        intent.putExtra(Activity_KEY, activity);
        startActivityForResult(intent, REQUEST_CODE_ADD);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;}


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemId=item.getItemId();
        if(itemId==R.id.mrules){
            Intent intent=new Intent(this, Rules.class);
            startActivity(intent);
            return true;
        }
        else if(itemId==R.id.mus)
        {
            Intent intent=new Intent(this, Aboutus.class);
            startActivity(intent);
            return true;
        } else if(itemId==R.id.mcredits) {
            Intent intent=new Intent(this, Credits.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ADD) {


            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled ", Toast.LENGTH_SHORT).show();
                return;
            } else if (resultCode == RESULT_OK) {

                int h = 0;
                String[] key_position={"first", "second", "third"};
                int[] key_id={R.id.text1, R.id.text2, R.id.text3};

                String high_score = data.getStringExtra(Activity_KEY);
                Log.i("high score", "high score" + high_score);
                h = Integer.parseInt(high_score);


                if (total[activity]< h) {
                    total[activity]= h;
                }
                TextView highscore = findViewById(key_id[activity]);
                highscore.setText("The highest score in the "+key_position[activity]+" game is " + total[activity]);
activity=10;
            }
        }
    }


}
