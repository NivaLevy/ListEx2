package com.example.niva.listex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Niva on 05/06/2016.
 */
public class CustomAdapter extends ArrayAdapter<GroceriesObject> {

    private ArrayList<GroceriesObject> data;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<GroceriesObject> data) {
        super(context, layoutResourceId, data);
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = LayoutInflater.from(getContext()).inflate(R.layout.display_item, parent, false);
        ImageView imgIcon = (ImageView)row.findViewById(R.id.img);
        TextView txtTitle = (TextView)row.findViewById(R.id.title);
        TextView txtAmount = (TextView)row.findViewById(R.id.amount);

        GroceriesObject object = data.get(position);
        txtTitle.setText(object.getTitle());
        txtAmount.setText(object.getAmount() + "");
        imgIcon.setImageResource(object.getImg());

        return row;
    }



}
