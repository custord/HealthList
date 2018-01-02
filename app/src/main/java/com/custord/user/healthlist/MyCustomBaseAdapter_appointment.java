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

public class MyCustomBaseAdapter_appointment extends BaseAdapter {
    private static ArrayList<appResults> searchArrayList;

    private LayoutInflater mInflater;

    public MyCustomBaseAdapter_appointment(Context context, ArrayList<appResults> results) {
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
            convertView = mInflater.inflate(R.layout.custom_row_view_appointment, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtCompany = (TextView) convertView.findViewById(R.id.company);
            holder.txtDate = (TextView) convertView.findViewById(R.id.date);
            holder.txtTime = (TextView) convertView.findViewById(R.id.time);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtCompany.setText(searchArrayList.get(position).getCompany());
        holder.txtDate.setText(searchArrayList.get(position).getDate());
        holder.txtTime.setText(searchArrayList.get(position).getTime());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCompany;
        TextView txtDate;
        TextView txtTime;
    }
}