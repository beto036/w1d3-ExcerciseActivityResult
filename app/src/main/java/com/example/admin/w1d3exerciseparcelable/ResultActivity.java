package com.example.admin.w1d3exerciseparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "TAG_";
    public static final String MY_KEY_RESULT = "MY_RESULT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        ArrayList<User> users = getIntent().getParcelableArrayListExtra(MainActivity.MY_KEY);
//        Iterator<User> userIterator = users.iterator();
//        Log.d(TAG, "Users");
//        while (userIterator.hasNext()){
//            Log.d(TAG, userIterator.next().toString());
//        }
    }

    public void returnData(View view) {
        Intent intent = new Intent();
        intent.putExtra(MY_KEY_RESULT, "RESULT_FROM_SECOND");
        setResult(10, intent);
        finish();
    }
}
