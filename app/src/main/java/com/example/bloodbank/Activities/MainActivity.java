package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.bloodbank.Adapters.RequestAdapter;
import com.example.bloodbank.DataModels.RequestDataModel;
import com.example.bloodbank.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<RequestDataModel> requestDataModels;
    private RequestAdapter requestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView make_request_button = findViewById(R.id.make_request_button);
        make_request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MakeRequestActivity.class));
                MainActivity.this.finish();
            }
        });
        requestDataModels = new ArrayList<>();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.search_button){
                    startActivity(new Intent(MainActivity.this,SearchActivity.class));
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        requestAdapter = new RequestAdapter(requestDataModels,this);
        recyclerView.setAdapter(requestAdapter);
        populateHomePage();
    }

    private void populateHomePage(){
        RequestDataModel requestDataModel = new RequestDataModel("Example Text of Blood Bank","https://www.google.com/search?q=car+images&client=firefox-b-d&sxsrf=ALeKk00OZrz66FmqxZWEE8UDOBOVHz-SFw:1591445619534&tbm=isch&source=iu&ictx=1&fir=fklJy2ybKuJw-M%253A%252CSAT7jSghFpqMMM%252C_&vet=1&usg=AI4_-kRH7Me2YC8DGf7ByjFPWuuAdMuiow&sa=X&ved=2ahUKEwj0nNP2lO3pAhWZWhUIHfYfD5oQ9QEwAnoECAoQNA&biw=1366&bih=654#imgrc=fklJy2ybKuJw-M:");
        requestDataModels.add(requestDataModel);
        requestDataModels.add(requestDataModel);
        requestDataModels.add(requestDataModel);
        requestDataModels.add(requestDataModel);
        requestDataModels.add(requestDataModel);
        requestDataModels.add(requestDataModel);
        requestAdapter.notifyDataSetChanged();
    }
}
