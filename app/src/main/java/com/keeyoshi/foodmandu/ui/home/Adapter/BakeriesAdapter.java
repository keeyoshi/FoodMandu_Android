package com.keeyoshi.foodmandu.ui.home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.keeyoshi.foodmandu.R;
import com.keeyoshi.foodmandu.ui.home.Model.BakeriesViewModel;

import java.util.List;

public class BakeriesAdapter extends RecyclerView.Adapter<BakeriesAdapter.BakeriesViewHolder> {


    Context context;
    List<BakeriesViewModel> listBakeries;

    public BakeriesAdapter(Context context, List<BakeriesViewModel> listBakeries) {
        this.context = context;
        this.listBakeries = listBakeries;
    }

    @NonNull
    @Override
    public BakeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bakeries,parent,false);
        return new BakeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BakeriesViewHolder holder, int position) {

        BakeriesViewModel bakeriesViewModel=listBakeries.get(position);
        holder.image.setImageResource(bakeriesViewModel.getImage());
        holder.tvName.setText(bakeriesViewModel.getName());
    }

    @Override
    public int getItemCount() {
        return listBakeries.size();
    }

    public class BakeriesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tvName;

        public BakeriesViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.image);
            tvName=itemView.findViewById(R.id.tvname);
        }
    }
}
