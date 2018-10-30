package co.codemaestro.punchclockv002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

public class TimeDataBase extends AppCompatActivity {

    String category, timeBankName, savedTime;
    private final LinkedList<String> myCategoryList = new LinkedList<>();
    private final LinkedList<String> myTimeList = new LinkedList<>();
    private RecyclerView myRecyclerView;
    private TimeDatabaseAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_database);

        Intent turnMeOn = getIntent();
        timeBankName = turnMeOn.getStringExtra("TIME_BANK_NAME");
        category = turnMeOn.getStringExtra("CATEGORY_NAME");
        savedTime = turnMeOn.getStringExtra("CURRENT_TIME");

        // Put data in lists
        myTimeList.addLast(savedTime);
        myCategoryList.addLast(category);

        // Run method to initialize RecyclerView
        initRecyclerView();
    }

    public void tempAddToList(View view) {

        myTimeList.addLast(savedTime);
        myCategoryList.addLast(category);
        myAdapter.notifyDataSetChanged();

    }

    private void initRecyclerView() {

        myRecyclerView = findViewById(R.id.timeRecyclerView);

        //Create an adapter then supply the data
        myAdapter = new TimeDatabaseAdapter(this, myTimeList, myCategoryList);


        // Connects the adapter to the RecView
        myRecyclerView.setAdapter(myAdapter);

        // Gives the RecView a default Layout Manager
        myRecyclerView.setLayoutManager(new LinearLayoutManager((this)));
    }

}
