package com.baidu.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.baidu.activity.R;
import com.baidu.bean.VedioItem;

/**
 * Created by guotaige on 17/4/9.
 */
public class VedioCursorAdapter extends CursorAdapter{
    public VedioCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    public VedioCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    public VedioCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = View.inflate(context, R.layout.vedio_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        VedioItem vedioItem = VedioItem.instanceFromCursor(cursor);
        holder.vedio_item_title.setText(vedioItem.getTitle());
        holder.vedio_item_size.setText(vedioItem.getSize()+"");
        holder.vedio_item_duration.setText(vedioItem.getDuration()+"");
    }

    private class ViewHolder {
        private TextView vedio_item_title,vedio_item_duration,vedio_item_size;

        public ViewHolder(View view){
            this.vedio_item_title = (TextView) view.findViewById(R.id.vedio_item_title);
            this.vedio_item_duration = (TextView) view.findViewById(R.id.vedio_item_title);
            this.vedio_item_size = (TextView) view.findViewById(R.id.vedio_item_size);
        }

    }
}
