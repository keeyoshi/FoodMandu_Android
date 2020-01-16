package com.keeyoshi.foodmandu.ui.home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.keeyoshi.foodmandu.Model.User;
import com.keeyoshi.foodmandu.R;

import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private Integer [] images={R.drawable.slider1,R.drawable.slider2,R.drawable.slider6,R.drawable.slider7};
    private Object LayoutInflater;
    ImageView imageView;
    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    List<User> usersList1;
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        
        LayoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = ((LayoutInflater) LayoutInflater).inflate(R.layout.image_slider,null);
        imageView=view.findViewById(R.id.imageView11);
        imageView.setImageResource(R.drawable.food);
        imageView.setImageResource(images[position]);
        ViewPager vp=(ViewPager) container;
        vp.addView(view,0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp=(ViewPager) container;
        View view=(View) object;
        vp.removeView(view);
    }
}
