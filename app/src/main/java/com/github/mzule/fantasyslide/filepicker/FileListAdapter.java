package com.github.mzule.fantasyslide.filepicker;

/**
 * Created by scheng on 3/11/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.mzule.fantasyslide.app.R;

import java.util.ArrayList;

/**<p>
 * Created by Angad Singh on 11-07-2016.
 * </p>
 */

public class FileListAdapter extends BaseAdapter{
    private ArrayList<ListItem> listItems;
    private Context context;

    public FileListAdapter(ArrayList<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public ListItem getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {   view=LayoutInflater.from(context).inflate(R.layout.file_list_item,viewGroup,false);
        }
        TextView name=(TextView)view.findViewById(R.id.name);
        TextView path=(TextView)view.findViewById(R.id.path);
        name.setText(listItems.get(i).getName());
        path.setText(listItems.get(i).getPath());
        return view;
    }

}