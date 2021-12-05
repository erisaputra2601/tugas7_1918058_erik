package com.example.rumah7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Kartu> movieItems;
    public CustomListAdapter(Activity activity, List<Kartu> movieItems)
    {
        this.activity = activity;
        this.movieItems = movieItems;
    }
        @Override
        public int getCount() {
        return movieItems.size();     }
        @Override
        public Object getItem(int location) {
        return  movieItems.get(location);     }
        @Override
        public long getItemId(int position) {
        return position;     }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (inflater == null)
                inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null)
                convertView = inflater.inflate(R.layout.custom_list, null);
            TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
            TextView no = (TextView) convertView.findViewById(R.id.text_no);
            TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
            Kartu m = movieItems.get(position);
            nama.setText("Nama : "+ m.get_nama());
            no.setText("No : "+ m.get_no());
            harga.setText("Harga : "+ m.get_harga());
            return convertView;
        }
}