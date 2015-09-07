package cn.amber.zxs.zcy.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import cn.amber.zxs.zcy.R;

/**
 * Created by dell on 2015/9/7.
 */
public class HomeEntryPageAdapter extends BaseAdapter {

    private List<String> mEntrys;
    private Context mContext;
    private LinearLayout.LayoutParams params;

    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }
    private void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public HomeEntryPageAdapter(Context mContext, List<String> mEntrys) {
        this.mContext = mContext;
        this.mEntrys = mEntrys;
        params=new LinearLayout.LayoutParams(160,160);
        params.gravity= Gravity.CENTER;
    }

    @Override
    public int getCount() {
        return mEntrys.size();
    }

    @Override
    public Object getItem(int position) {
        return mEntrys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_entry_page, null, false);
            viewHolder.mTvEntry= (TextView) convertView.findViewById(R.id.tv_entry);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.mTvEntry.setLayoutParams(params);
        viewHolder.mTvEntry.setText(mEntrys.get(position));
        if (onItemClickListener!=null){

            viewHolder.mTvEntry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v, position);
                }
            });

        }
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.mTvEntry.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (finalViewHolder.mTvEntry.getText()!="十"){
                    AlertDialog dialog=new AlertDialog.Builder(mContext)
                            .setMessage("确认删除选项？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setNegativeButton("取消",null)
                            .show();
                }
                return true;
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView mTvEntry;
    }
}
