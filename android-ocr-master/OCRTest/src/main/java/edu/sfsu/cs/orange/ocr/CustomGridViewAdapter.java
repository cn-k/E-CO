package edu.sfsu.cs.orange.ocr;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cenk.akdeniz on 03.08.2016.
 */
public class CustomGridViewAdapter extends ArrayAdapter<String> {

    Context context;
    int layoutResourceId;
    ArrayList<String> data = new ArrayList<String>();

    public CustomGridViewAdapter(Context context, int layoutResourceId, ArrayList<String> data)
    { super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.grid_item_label);
            row.setTag(holder);
        }
        else {
            holder = (RecordHolder) row.getTag();
        } String str = data.get(position);
        holder.txtTitle.setText(str);
        return row;
    }

    static class RecordHolder {
        TextView txtTitle;

    }





}
