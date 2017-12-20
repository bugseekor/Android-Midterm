package com.example.spark1435.midterm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name = "Sam";
    String comment = "empty yet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] mobileArray = {"Name: " + name ,"Comment: " + comment};
        
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.addCommentButton:
                    Context context = getApplicationContext();
                    CharSequence text = "Name : " + name;
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    sendMessage1(view);
                    break;
                case R.id.contactButton:
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                    startActivity(intent);
                    break;
        }
    }
    public void sendMessage1(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
