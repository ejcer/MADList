package com.example.emcenrue.madlists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by emcenrue on 2/17/2015.
 */
public class GenericAdapter extends BaseAdapter{
    private LayoutInflater layoutInflater;
    ArrayList<String> list;
    private Context mContext;

    public GenericAdapter(Context context, int resources, ArrayList<String> list){
        layoutInflater = layoutInflater.from(context);
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GenericViewHolder genericViewHolder;

        if(convertView == null){
            LinearLayout rootView = (LinearLayout) layoutInflater.inflate(R.layout.item_row_generic, parent, false);
            genericViewHolder = GenericViewHolder.create(rootView);
            rootView.setTag(genericViewHolder);
        }else{
            genericViewHolder = (GenericViewHolder) convertView.getTag();
        }
        genericViewHolder.tv.setText(list.get(position));


        return genericViewHolder.rootView;
    }


    private static class GenericViewHolder {
        public final LinearLayout rootView;
        public final TextView tv;

        private GenericViewHolder(LinearLayout rv, TextView tv){
            this.rootView = rv;
            this.tv = tv;
        }

        public static GenericViewHolder create(LinearLayout rootView){
            TextView tv = (TextView) rootView.findViewById(R.id.rowTextView);
            return new GenericViewHolder(rootView, tv);
        }
    }

}
