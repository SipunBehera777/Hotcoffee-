package com.example.hotcoffee;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotcoffee.ViewModel.CoffeeViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CoffeeViewModel viewModel;
    private RecyclerView recyclerView;
    private CoffeeAdapter coffeeAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        coffeeAdapter = new CoffeeAdapter(new ArrayList<>(), new OnDrinkClick() {
            @Override
            public void onDrinkClick(CoffeeModel model) {
                Intent data=new Intent(MainActivity.this, CoffeeDetails.class);
                data.putExtra("DATA",model);
                startActivity(data);
            }
        });
        recyclerView.setAdapter(coffeeAdapter);

        viewModel = new ViewModelProvider(this).get(CoffeeViewModel.class);

        viewModel.getCoffee().observe(this, coffeeModels -> {
            if (coffeeModels != null) {
                coffeeAdapter.setData(coffeeModels);
            } else {
                Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
