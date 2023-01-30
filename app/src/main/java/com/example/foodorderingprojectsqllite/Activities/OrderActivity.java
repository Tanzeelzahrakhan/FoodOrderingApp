package com.example.foodorderingprojectsqllite.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingprojectsqllite.Adapter.OrdersAdapter;
import com.example.foodorderingprojectsqllite.Model.DBHelper;
import com.example.foodorderingprojectsqllite.Model.OrdersModel;
import com.example.foodorderingprojectsqllite.R;
import com.example.foodorderingprojectsqllite.databinding.ActivityOrderAcitivityBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
ActivityOrderAcitivityBinding binding;
DBHelper helper;
OrdersAdapter adapter;
ArrayList<OrdersModel>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_acitivity);
        binding=ActivityOrderAcitivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        helper=new DBHelper(this);
        list=helper.getOrders();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.OderRecyclerview.setLayoutManager(layoutManager);
        adapter=new OrdersAdapter(list,this);
        binding.OderRecyclerview.setAdapter(adapter);

    }
}