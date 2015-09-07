package cn.amber.zxs.zcy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.amber.zxs.zcy.R;
import cn.amber.zxs.zcy.adapter.HomeEntryPageAdapter;

/**
 *
 */
public class HomeFragment extends BaseFragment {

    public static final String TAG = "HomeFragment";
    @InjectView(R.id.tv_today_turnover)
    TextView mTvTodayTurnover;
    @InjectView(R.id.tv_today_earning)
    TextView mTvTodayEarning;
    @InjectView(R.id.tv_today_orders)
    TextView mTvTodayOrders;
    @InjectView(R.id.tv_today_complaint)
    TextView mTvTodayComplaint;
    @InjectView(R.id.gv_entry_page)
    GridView mGvEntryPage;

    private HomeEntryPageAdapter mEntryAdapter;
    private List<String> mEntrys;

    public static HomeFragment newInstance() {

        HomeFragment fragment = new HomeFragment();
        return fragment;


    }

    public HomeFragment() {
    }

    public static void jumpIn(AppCompatActivity appCompatActivity) {
        Fragment fragment = HomeFragment.newInstance();
        FragmentManager manager = appCompatActivity.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.rl_container, fragment, HomeFragment.TAG)
                .addToBackStack(null)
                .commitAllowingStateLoss();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initData();
        initAdapter();
        bindData();
        return view;

    }

    private void bindData() {
        //测试数据
        for (int i = 0; i <10; i++) {
            String entry;
            if (i!=9){
                 entry="入口"+i;
            }else {
                 entry="十";
            }
            mEntrys.add(entry);
        }
    }
//
//    //添加视图
//    private void addView(){
//        View view=LayoutInflater.from(getActivity()).inflate(R.layout.item_entry_page,null);
//        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(160,160);
//        mGvEntryPage.addView(view,mEntrys.size(),params);
//        mEntryAdapter.notifyDataSetChanged();
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }

    private void initData() {
        if (mEntrys==null){
            mEntrys=new ArrayList<>();
        }
    }

    private void initAdapter() {
        mEntryAdapter=new HomeEntryPageAdapter(getActivity(),mEntrys);
        mGvEntryPage.setAdapter(mEntryAdapter);
    }

    private void initView(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(getString(R.string.text_home));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
