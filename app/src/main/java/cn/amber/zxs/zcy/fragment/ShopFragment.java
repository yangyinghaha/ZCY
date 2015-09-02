package cn.amber.zxs.zcy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.amber.zxs.zcy.R;
import cn.amber.zxs.zcy.adapter.ShopFragmentAdapter;
import cn.amber.zxs.zcy.bean.Category;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment {


    @InjectView(R.id.rv_shops)
    RecyclerView mRvShops;
    @InjectView(R.id.cb_all_check)
    CheckBox mCbAllCheck;
    @InjectView(R.id.rv_goods)
    RecyclerView mRvGoods;

    private ShopFragmentAdapter mShopFragmentAdapter;
    private List<Category> mCategorys;

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        return fragment;
    }


    public static void jumpIn(AppCompatActivity appCompatActivity) {
        Fragment fragment = ShopFragment.newInstance();
        FragmentManager manager = appCompatActivity.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.rl_container, fragment, null)
                .addToBackStack(null)
                .commit();

    }

    public ShopFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        initView(view);
        initData();
        initAdapter();
        bindData();
        return view;
    }

    private void bindData() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvShops.setLayoutManager(linearLayoutManager);
        mRvShops.setAdapter(mShopFragmentAdapter);
    }

    private void initData() {
        if (mCategorys==null){
            mCategorys=new ArrayList<>();
        }
        //测试数据（一级类目）
        setTestData();
    }

    private void setTestData(){
        for (int i = 0; i <30 ; i++) {
            String name="商铺"+i;
            Category category=new Category();
            category.setName(name);
            mCategorys.add(category);
        }
    }

    private void initAdapter() {
        mShopFragmentAdapter=new ShopFragmentAdapter(getActivity(),mCategorys);
    }

    private void initView(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle("店铺");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
