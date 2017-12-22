package com.example.spark1435.midterm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();


        Bundle bundle = getIntent().getExtras();

        if (bundle != null){

            String name;
            String comment;
            String message;

            name = bundle.getString("name");
            comment = bundle.getString("comment");
            message = "Name: " + name + " - Comment: " + comment;

            SharedPreferences sp = this.getSharedPreferences("comments", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            Set<String> set = new HashSet<String>();


            Set<String> setToGet = sp.getStringSet("key-comments", null);
            if(setToGet != null){
                List<String> prevComments = new ArrayList<String>(setToGet);
                prevComments.add(message);
                set.addAll(prevComments);
                ArrayAdapter adapter = new ArrayAdapter<String>(this,
                        R.layout.activity_listview, prevComments);
                ListView listView = (ListView) findViewById(R.id.mobile_list);
                listView.setAdapter(adapter);
            }
            else{
                ArrayList<String> comments = new ArrayList<String>();
                comments.add(message);
                set.addAll(comments);
                ArrayAdapter adapter = new ArrayAdapter<String>(this,
                        R.layout.activity_listview, comments);
                ListView listView = (ListView) findViewById(R.id.mobile_list);
                listView.setAdapter(adapter);
            }
            edit.putStringSet("key-comments", set);
            edit.commit();
        }
    }

        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.addCommentButton:

                    Context context = getApplicationContext();
                    CharSequence text = "Name : Sangkyun Park";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    sendMessage1(view);
                    break;
                case R.id.contactButton:
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:" + Uri.encode("1234")));
                    startActivity(intent);
                    break;
        }
    }
    public void sendMessage1(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
