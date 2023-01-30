package com.example.foodorderingprojectsqllite.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingprojectsqllite.Adapter.MainAdapter;
import com.example.foodorderingprojectsqllite.Model.MainModel;
import com.example.foodorderingprojectsqllite.R;
import com.example.foodorderingprojectsqllite.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<MainModel> list = new ArrayList<>();
    MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list.add(new MainModel(R.drawable.burger, "Burger", "5", "Chicken Burger with Extra cheese."));
        list.add(new MainModel(R.drawable.burgers, " Zingar Burger", "8", "Chicken Burger with Extra cheese."));
        list.add(new MainModel(R.drawable.pastaa, "pasta", "3", "pasta with Extra chicken."));
        list.add(new MainModel(R.drawable.buriyani, "Bariyani", "10", "Chicken Bariyani spicy and yummy!"));
        list.add(new MainModel(R.drawable.shuwrams, "Shuwrama", "5", "Shuwrama with Extra cheese."));
        list.add(new MainModel(R.drawable.seekh, "Tikka Botie", "6", "Chicken tikka botie spiccy and yummy!"));
        list.add(new MainModel(R.drawable.sheerqurma, "SheerQurma", "5", "SheerQurma Sweet Dish"));
        list.add(new MainModel(R.drawable.icecreams, "Ice Cream", "2", "Ice Cream are in chocolate flavor."));
        list.add(new MainModel(R.drawable.kabab, "Seekh Kabab", "8", "Seekh Kabab spiccy and yummy!"));
        list.add(new MainModel(R.drawable.sampleimg, "Chicken Pakory", "5", " Chicken pakory with chicken."));
        list.add(new MainModel(R.drawable.pasta, "Macroni ", "12", " Macroni  with chicken."));
        list.add(new MainModel(R.drawable.rassmilai, "RassMilai", "3", "Rass Milai sweet dish."));
        list.add(new MainModel(R.drawable.cakes, "Cakes", "9", "Cakes with Extra Cream and Chocolate."));
        list.add(new MainModel(R.drawable.icecream, "Ice Cream", "5", " Ice Cream  with Chocolate."));
        list.add(new MainModel(R.drawable.pastie, "Pasti", "1", " Pasti  with Chocolate and cream."));
        list.add(new MainModel(R.drawable.pizzas, "Pizza", "10", "Pizza with chicken are avalible."));
        list.add(new MainModel(R.drawable.macronipasta, "Macroni pasta", "7", " Macroni pasta with chicken."));
        list.add(new MainModel(R.drawable.ice, "Chocolate ice cream", "9", " Ice Cream  with Chocolate"));
        list.add(new MainModel(R.drawable.jelabi, "jelabi", "9", "jelabi is sweet"));


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerviews.setLayoutManager(layoutManager);
        adapter=new MainAdapter(list,this);
        binding.recyclerviews.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.orders:
                Intent intent=new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}