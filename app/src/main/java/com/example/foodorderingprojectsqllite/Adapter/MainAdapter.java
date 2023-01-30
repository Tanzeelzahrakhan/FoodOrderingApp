package com.example.foodorderingprojectsqllite.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingprojectsqllite.Activities.DetailActivity;
import com.example.foodorderingprojectsqllite.Model.MainModel;
import com.example.foodorderingprojectsqllite.R;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {
    @NonNull
    ArrayList<MainModel>list;
    Context context;

    public MainAdapter(@NonNull ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.main_sample_food,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        MainModel mainModel=list.get(position);
        holder.mainName.setText(mainModel.getName());
        holder.description.setText(mainModel.getDescription());
        holder.price.setText(mainModel.getPrice());
        holder.foodimage.setImageResource(mainModel.getImage());
          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent=new Intent(context, DetailActivity.class);
                  intent.putExtra("img",mainModel.getImage());
                  intent.putExtra("Price",mainModel.getPrice());
                  intent.putExtra("description",mainModel.getDescription());
                  intent.putExtra("Name",mainModel.getName());
                  intent.putExtra("type",1);
                  context.startActivity(intent);
              }
          });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
      //Itemmain_sample_foodBinding binding;
       ImageView foodimage;
        TextView mainName;
       TextView price;
      TextView description;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            //binding = ItemsamplemainfoodBinding.bind(itemView);
            foodimage=itemView.findViewById(R.id.imageview);
            mainName=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.orderPrices);
            description=itemView.findViewById(R.id.description);
        }
    }
}
