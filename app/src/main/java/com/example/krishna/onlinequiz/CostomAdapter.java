package com.example.krishna.onlinequiz;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Krishna on 5/19/2018.
 */

public class CostomAdapter extends ArrayAdapter {
    Activity activity;
    String course[];
    Integer image[];
    ImageView im;
    TextView tv;

    public CostomAdapter(Activity activity, String[] course, Integer[] image) {
        super(activity,R.layout.costom_layout,course);
        this.activity=activity;
        this.course=course;
        this.image=image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.costom_layout,null);
        tv= (TextView) v.findViewById(R.id.textv);
        im= (ImageView) v.findViewById(R.id.imagev);
        tv.setText(course[position]);
        im.setImageResource(image[position]);
        return  v;
    }
}
