package com.faraaf.tictacdev.firebaseanalytics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAnalytics firebaseAnalytics;
    String[] foods;
    Food food;
    Button btnClick;
    EditText edtTest;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        clickEvents();

        // Obtain the Firebase Analytics instance.
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        initModel();

        // choose random food name from the list
        food.setName(foods[randomIndex()]);

        //Here we create a bundle and pass it to the logEvent.
        // We can also set whether analytics collection is enabled for this app on this device.
        bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.ITEM_ID, food.getId());
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, food.getName());

        //Logs an app event.
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        //Sets whether analytics collection is enabled for this app on this device.
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds).
        firebaseAnalytics.setMinimumSessionDuration(500);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        firebaseAnalytics.setSessionTimeoutDuration(500);
        //Sets the user ID property.
        firebaseAnalytics.setUserId(String.valueOf(food.getId()));
        //Sets a user property to a given value.
        firebaseAnalytics.setUserProperty("Food", food.getName());

    }

    private void initModel() {
        foods = new String[]{"Apple", "Banana", "Grape", "Mango", "Orange"};
        food = new Food();
        food.setId(1);
    }

    private void bind() {
        btnClick = findViewById(R.id.btnClick);
        edtTest = findViewById(R.id.edtTest);
    }

    private void clickEvents() {
        btnClick.setOnClickListener(this);
    }

    private int randomIndex() {
        int min = 0;
        int max = foods.length - 1;
        Random rand = new Random();
        return min + rand.nextInt((max - min) + 1);
    }

    @Override
    public void onClick(View v) {
        //Sets the Favourite Book property.
        firebaseAnalytics.setUserProperty("FAVOURITE_FOOD", edtTest.getText().toString());
    }


}
