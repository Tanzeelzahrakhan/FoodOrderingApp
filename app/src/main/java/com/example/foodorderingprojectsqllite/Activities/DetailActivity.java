package com.example.foodorderingprojectsqllite.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingprojectsqllite.Model.DBHelper;
import com.example.foodorderingprojectsqllite.R;
import com.example.foodorderingprojectsqllite.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
ActivityDetailBinding binding;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0)==1) {
            int image = getIntent().getIntExtra("img", 0);
            int price = Integer.parseInt(getIntent().getStringExtra("Price"));
            String name = getIntent().getStringExtra("Name");
            String description = getIntent().getStringExtra("description");
            binding.detailImage.setImageResource(image);
            binding.tvorderPrices.setText(String.format("%d", price));
            binding.nameLbl.setText(name);
            binding.DetailDescription.setText(description);

            binding.btnOrderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(
                            binding.etName.getText().toString(),
                            binding.etPhone.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString()));
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "error", Toast.LENGTH_SHORT).show();}}});
        }else {
             int id=getIntent().getIntExtra("id",0);
            Cursor cursor=helper.getOrderById(id);
            binding.etName.setText(cursor.getString(1));
            binding.etPhone.setText(cursor.getString(2));
            binding.tvorderPrices.setText(String.format("%d",3));
            binding.detailImage.setImageResource(cursor.getInt(4));
            binding.DetailDescription.setText(cursor.getString(5));
            binding.nameLbl.setText(cursor.getString(6));
        }
    }
}