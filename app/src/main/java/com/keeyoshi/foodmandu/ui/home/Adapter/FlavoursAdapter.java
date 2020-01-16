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

import com.keeyoshi.foodmandu.Model.Flavours;
import com.keeyoshi.foodmandu.R;
import com.keeyoshi.foodmandu.URL.url;
import com.keeyoshi.foodmandu.strictmode.StrictModeClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class FlavoursAdapter extends RecyclerView.Adapter<FlavoursAdapter.FlavourViewHolder> {

    Context context;
    List<Flavours> flavoursList;

    public FlavoursAdapter(Context context, List<Flavours> flavoursList) {
        this.context = context;
        this.flavoursList = flavoursList;
    }

    @NonNull
    @Override
    public FlavourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flavours,parent,false);
        return new FlavourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlavourViewHolder holder, int position) {

        Flavours flavours=flavoursList.get(position);
        String imgpath = url.imagePath+flavours.getImage();
        holder.tvItem.setText(flavours.getItem());
        holder.tvCafe.setText(flavours.getCafe());

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
        return flavoursList.size();
    }

    public class FlavourViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView tvItem, tvCafe;

        public FlavourViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.image);
            tvItem=itemView.findViewById(R.id.tvitem);
            tvCafe=itemView.findViewById(R.id.tvcafe);
        }
    }
}
