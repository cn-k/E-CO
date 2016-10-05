package edu.sfsu.cs.orange.ocr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by cenk.akdeniz on 02.08.2016.
 */
public class contentDiseasesAdapter extends BaseAdapter {


    private Context context;
    String[] list;


    public contentDiseasesAdapter(Context context , String [] list){

        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.content_diseases_list_item, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(list[position]);


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

}
