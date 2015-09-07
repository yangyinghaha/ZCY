package cn.amber.zxs.zcy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    private List<Category> mSecondCategory;
    private Context mContext;
    private SparseArray firstCagRecord;

    public ShopFragmentAdapter(Context mContext, List<Category> mCategorys,List<Category> mSecondCategory) {
        this.mContext = mContext;
        this.mCategorys = mCategorys;
        this.mSecondCategory=mSecondCategory;
        firstCagRecord=new SparseArray();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_shop_category, null, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder= (ViewHolder) holder;

        boolean isChecked= (boolean) firstCagRecord.get(position,false);
        Log.i("first-",isChecked+"---->");
        viewHolder.mCbShops.setChecked(isChecked);
        showSecondCateg(viewHolder,isChecked);
        Category category=mCategorys.get(position);
        String name=category.getName();
        viewHolder.mCbShops.setText(name);
        recordData(viewHolder, position);
    }

    private void recordData(final ViewHolder viewHolder, final int position){
        viewHolder.mCbShops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = viewHolder.mCbShops.isChecked();
                showSecondCateg(viewHolder, isCheck);
                if (isCheck) {
                    setCategoryVisibility(position);
                    for (int i = 0; i < firstCagRecord.size(); i++) {
                        int key = firstCagRecord.keyAt(i);
                        if (key != position) {
                            firstCagRecord.put(i, false);
                        }
                    }
                    notifyDataSetChanged();
                }
            }
        });

    }

    private void addSecondCategory(ViewHolder holder){
        for (Category secodCateg : mSecondCategory){
            RadioButton rb= (RadioButton) LayoutInflater.from(mContext).inflate(R.layout.rationbutton,null);
            RadioGroup.LayoutParams params=new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT,RadioGroup.LayoutParams.WRAP_CONTENT);
            rb.setLayoutParams(params);
            holder.mRgSecondCategory.addView(rb);
            String name=secodCateg.getName();
            rb.setText(name);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO:加载对应商品

                }
            });
        }

    }

    private void setCategoryVisibility(int position){
        firstCagRecord.put(position,true);
    }

    //控制二级类目的显示隐藏
    private void showSecondCateg(ViewHolder holder,boolean b){
        holder.mIvArrow.setVisibility(b ? View.VISIBLE : View.GONE );
        holder.mRgSecondCategory.setVisibility(b ? View.VISIBLE : View.GONE);
        holder.mRgSecondCategory.removeAllViews();
        addSecondCategory(holder);
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
