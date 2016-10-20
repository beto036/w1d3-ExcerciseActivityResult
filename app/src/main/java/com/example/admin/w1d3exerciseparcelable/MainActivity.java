package com.example.admin.w1d3exerciseparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MY_KEY = "users";
    private ArrayList<User> users;

    private static final String TAG = "TAG_";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<User>();
    }

    public void createUser(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextMain);
        user = new User(editText.getText().toString());
        users.add(user);
        Toast.makeText(this, "You added " + user.getName() + " Total Users: " + users.size(), Toast.LENGTH_LONG).show();
    }

    public void showUsers(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putParcelableArrayListExtra(MY_KEY, users);
        startActivity(intent);
    }

    public void doSomething(View view) {
        // Create the text message with a string
         Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Edwin is the best");
        sendIntent.setType("text/plain");
        // Verify that the intent will resolve to an activity
         if (sendIntent.resolveActivity(getPackageManager()) != null) {
             startActivity(sendIntent);
         }
    }

    public void doSomething2(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: " + requestCode);
        Log.d(TAG, "onActivityResult: " + resultCode);
        Log.d(TAG, "onActivityResult: " + data.getStringExtra(ResultActivity.MY_KEY_RESULT));
    }
}
