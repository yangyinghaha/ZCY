package cn.amber.zxs.zcy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.amber.zxs.zcy.R;
import cn.amber.zxs.zcy.bean.Good;

/**
 * Created by dell on 2015/9/7.
 */
public class ShopGoodsAdapter extends RecyclerView.Adapter<ShopGoodsAdapter.ViewHolder> {

    private List<Good> mGoods;
    private Context mContext;

    public ShopGoodsAdapter(Context mContext, List<Good> mGoods) {
        this.mContext = mContext;
        this.mGoods = mGoods;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_goods, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Good good=mGoods.get(position);
        String name=good.getName();
        holder.mTvGoodsName.setText(name);
    }


    @Override
    public int getItemCount() {
        return mGoods.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.tv_goods_name)
        TextView mTvGoodsName;
        @InjectView(R.id.cb_goods_select)
        CheckBox mCbGoodsSelect;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
