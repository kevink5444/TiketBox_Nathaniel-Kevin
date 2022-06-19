package com.nathanielkevinkurniawan.utsa.ticketbox;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public CustomListView(Activity context,String[] web, Integer[] imageId) {
        super(context, R.layout.list_single_data, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single_data, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtList);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgIcon);
        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
