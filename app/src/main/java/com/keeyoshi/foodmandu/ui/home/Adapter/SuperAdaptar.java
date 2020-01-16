package com.keeyoshi.foodmandu.ui.home.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.keeyoshi.foodmandu.R;
import com.keeyoshi.foodmandu.URL.url;
import com.keeyoshi.foodmandu.strictmode.StrictModeClass;
import com.keeyoshi.foodmandu.ui.home.Model.Super7;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class SuperAdaptar extends RecyclerView.Adapter<SuperAdaptar.superViewHolder> {


    Context context;
    List<Super7> listsuper;

    public SuperAdaptar(Context context, List<Super7> listsuper) {
        this.context = context;
        this.listsuper = listsuper;
    }

    @NonNull
    @Override
    public superViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.super7,parent,false);
        return new superViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull superViewHolder holder, int position) {

        Super7 dataModel=listsuper.get(position);
        String imgpath = url.imagePath+dataModel.getImage();
        holder.tvCafe.setText(dataModel.getCafe());
        holder.tvDish.setText(dataModel.getDish());
        holder.tvLocation.setText(dataModel.getLocation());

        StrictModeClass.StrictMode();
        try {
            URL url=new URL(imgpath);
            holder.image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return listsuper.size();
    }

    public class superViewHolder extends RecyclerView.ViewHolder {
        TextView tvCafe,tvDish,tvLocation;
        ImageView image,icon;

        public superViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCafe=itemView.findViewById(R.id.tvcafe);
            tvDish=itemView.findViewById(R.id.tvdish);
            tvLocation=itemView.findViewById(R.id.tvlocation);
            image=itemView.findViewById(R.id.image);
            icon=itemView.findViewById(R.id.icon);
           }
        }
    }
