package com.example.healthsphere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };
    private int[] headings = {
            R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three,
            R.string.heading_fourth
    };
    private int[] descriptions = {
            R.string.desc_one,
            R.string.desc_two,
            R.string.desc_three,
            R.string.desc_fourth
    };

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView slidetitleImage = view.findViewById(R.id.title_image);
        TextView slideHeading = view.findViewById(R.id.texttitle);
        TextView slideDesc = view.findViewById(R.id.textdesc);

        slidetitleImage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDesc.setText(descriptions[position]);

        // Set content descriptions for accessibility
        slidetitleImage.setContentDescription(context.getString(R.string.image_description));
        slideHeading.setContentDescription(context.getString(R.string.heading_description, position + 1));
        slideDesc.setContentDescription(context.getString(R.string.description_description, position + 1));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}


//package com.example.healthsphere;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.viewpager.widget.PagerAdapter;
//
//public class ViewPagerAdapter extends PagerAdapter {
//    Context context;
//    int[] images = {
//            R.drawable.image1,
//            R.drawable.image2,
//            R.drawable.image3,
//            R.drawable.image4
//
//    };
//    int[] headings = {
//            R.string.heading_one,
//            R.string.heading_two,
//            R.string.heading_three,
//            R.string.heading_fourth
//    };
//    int[] description = {
//            R.string.desc_one,
//            R.string.desc_two,
//            R.string.desc_three,
//            R.string.desc_fourth
//    };
//    @Override
//    public int getCount() {
//        return headings.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == (LinearLayout) object;
//    }
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position){
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);
//
//        ImageView slidetitleImage = (ImageView) view.findViewById(R.id.title_image);
//        TextView slideHeading = (TextView) view.findViewById(R.id.texttitle);
//        TextView slideDesc = (TextView) view.findViewById(R.id.textdesc);
//
//
//        slidetitleImage.setImageResource(images[position]);
//        slideHeading.setText(headings[position]);
//        slideDesc.setText(description[position]);
//
//        container.addView(view);
//        return view;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((LinearLayout)object);
//    }
//}
