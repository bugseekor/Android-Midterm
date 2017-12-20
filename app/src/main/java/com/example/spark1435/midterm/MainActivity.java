package com.example.spark1435.midterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addCommentButton:
                sendMessage1(view);
                break;
            case R.id.contactButton:

                break;
        }
    }
    public void sendMessage1(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
