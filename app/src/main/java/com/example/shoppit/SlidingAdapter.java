package com.example.shoppit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.annotation.NonNull;

import com.example.shoppit.R;

import org.jetbrains.annotations.NotNull;

public class SlidingAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlidingAdapter(Context context){
        this.context = context;
    }
    //image array banayi aur drawable se objects connect kiye
    int[] imagesArray = {

            R.drawable.onboardscreen1,
            R.drawable.onboardscreen2,
            R.drawable.onboardscreen3
    };
    //same for headings
    int[] headingArray = {
            R.string.first_slide,
            R.string.second_slide,
            R.string.third_slide
    };
    //same for uske niche ka content
    int[] descriptionArray = {
            R.string.description,
            R.string.description,
            R.string.description,

    };

    @Override
    public int getCount(){
        return headingArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object Object){
        return view == (ConstraintLayout) Object;
    }

    @NotNull

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliding_layout, container,false);

        ImageView imageView = view.findViewById(R.id.slider_img);
        TextView textView = view.findViewById(R.id.heading);
        TextView description = view.findViewById(R.id.description);

        imageView.setImageResource(imagesArray[position]);
        textView.setText(headingArray[position]);
        description.setText(descriptionArray[position]);

        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position,@NotNull Object Object) {
        container.removeView((ConstraintLayout) Object);
    }
}
