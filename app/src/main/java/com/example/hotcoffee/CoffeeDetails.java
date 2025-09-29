package com.example.hotcoffee;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CoffeeDetails extends AppCompatActivity {
    TextView drinkName,description;
    ImageView imageView;
    RecyclerView recyclerView;
    List<String> ingridients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coffee_details);
        drinkName=findViewById(R.id.drinkName);
        description=findViewById(R.id.drinkDes);
        imageView=findViewById(R.id.imageCoffee);
        recyclerView=findViewById(R.id.recyclerView);
        CoffeeModel model=getIntent().getParcelableExtra("DATA");
        if(model!=null){
            Glide.with(this).load(model.getImage()).into(imageView);
            drinkName.setText(model.getTitle());
            description.setText(model.getDescription());
            ingridients=model.getIngredients();

            IngreDients adapter=new IngreDients(ingridients);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            recyclerView.setItemAnimator(null);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}