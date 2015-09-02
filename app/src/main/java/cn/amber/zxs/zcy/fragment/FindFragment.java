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
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment {



    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    public static void jumpIn(AppCompatActivity appCompatActivity) {
        Fragment fragment = FindFragment.newInstance();
        FragmentManager manager = appCompatActivity.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.rl_container, fragment, null)
                .addToBackStack(null)
                .commit();

    }
    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle("发现");
    }
}
