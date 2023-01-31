package com.example.foodorderingprojectsqllite.Adapter;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingprojectsqllite.Activities.DetailActivity;
import com.example.foodorderingprojectsqllite.Model.DBHelper;
import com.example.foodorderingprojectsqllite.Model.OrdersModel;
import com.example.foodorderingprojectsqllite.R;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {
    ArrayList<OrdersModel>list;
    Context context;
    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;}
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new OrdersAdapter.viewHolder(view);}
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
       OrdersModel model=list.get(position);
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());
        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(context, DetailActivity.class);
            intent.putExtra("id",Integer.parseInt(model.getOrderNumber()));
            intent.putExtra("type",2);
            context.startActivity(intent);});
              holder.itemView.setOnLongClickListener(v -> {
                  new AlertDialog.Builder(context)
                          .setTitle("Delete Item")
                          .setMessage("Are you sure to delete this Item")
                          .setPositiveButton("Yes", (dialog, which) -> {
                              DBHelper helper=new DBHelper(context);
                              if(helper.deleteOrder(model.getOrderNumber())>0){
                                  Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show();
                              }else {
                                  Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                              }}).setNegativeButton("No", (dialog, which) -> {
                                      //dialog.cancel();
                                  }).show();
                  return false;
              });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
       TextView soldItemName;
        TextView orderNumber;
       TextView price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
          orderImage=itemView.findViewById(R.id.orderimage);
          soldItemName=itemView.findViewById(R.id.orderItemName);
          orderNumber=itemView.findViewById(R.id.orderNo);
          price=itemView.findViewById(R.id.Itemprice);

        }
    }
}
