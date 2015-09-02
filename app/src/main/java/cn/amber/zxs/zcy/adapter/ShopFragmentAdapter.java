package cn.amber.zxs.zcy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.amber.zxs.zcy.R;
import cn.amber.zxs.zcy.bean.Category;

/**
 * Created by dell on 2015/9/2.
 */
public class ShopFragmentAdapter extends RecyclerView.Adapter {

    private List<Category> mCategorys;
    private LayoutInflater mInflater;
    private Context mContext;

    public ShopFragmentAdapter(Context mContext, List<Category> mCategorys) {
        this.mContext = mContext;
        this.mCategorys = mCategorys;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_shop_category, null, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder= (ViewHolder) holder;
        Category category=mCategorys.get(position);
        String name=category.getName();
        viewHolder.mCbShops.setText(name);
        viewHolder.mCbShops.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    viewHolder.mIvArrow.setVisibility(View.VISIBLE);
                }else {
                    viewHolder.mIvArrow.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCategorys.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.cb_shops)
        CheckBox mCbShops;
        @InjectView(R.id.iv_arrow)
        ImageView mIvArrow;
        @InjectView(R.id.rg_second_category)
        RadioGroup mRgSecondCategory;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
