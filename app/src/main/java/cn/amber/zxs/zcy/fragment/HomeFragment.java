package cn.amber.zxs.zcy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.amber.zxs.zcy.R;

/**
 *
 */
public class HomeFragment extends BaseFragment {

    public static final String TAG="HomeFragment";
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {
    }

    public static void jumpIn(AppCompatActivity appCompatActivity){
        Fragment fragment=HomeFragment.newInstance();
        FragmentManager manager=appCompatActivity.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.rl_container,fragment,HomeFragment.TAG)
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle("首页");
    }
}
