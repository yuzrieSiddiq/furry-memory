package com.reis.furrymemory.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.reis.furrymemory.R;

/**
 * Created by reis on 07/08/2017.
 */

public class IndexGridAdapter extends BaseAdapter {

    private Context context;

    public Integer [] thumbnailsID = {
            R.drawable.header, R.drawable.header2, R.drawable.header, R.drawable.header2, R.drawable.header, R.drawable.header2
    };

    public IndexGridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return thumbnailsID.length;
    }

    @Override
    public Object getItem(int i) {
        return thumbnailsID[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.markers_index_grid_fragment, parent, false);

        ImageView markerIcon = (ImageView) view.findViewById(R.id.marker_icon);
        TextView markerName = (TextView) view.findViewById(R.id.marker_name);

        return view;
    }
}
