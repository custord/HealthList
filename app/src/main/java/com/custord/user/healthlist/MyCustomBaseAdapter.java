package com.custord.user.healthlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by custord on 10/26/17.
 */

public class MyCustomBaseAdapter extends BaseAdapter {
    private static ArrayList<favResults> searchArrayList;

    private LayoutInflater mInflater;

    public MyCustomBaseAdapter(Context context, ArrayList<favResults> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtCompany = (TextView) convertView.findViewById(R.id.company);
            holder.txtCity = (TextView) convertView.findViewById(R.id.city);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtCompany.setText(searchArrayList.get(position).getCompany());
        holder.txtCity.setText(searchArrayList.get(position).getCity());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCompany;
        TextView txtCity;
    }
}