package cn.amber.zxs.zcy.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import cn.amber.zxs.zcy.BaseActivity;
import cn.amber.zxs.zcy.MainActivity;
import cn.amber.zxs.zcy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {
//
//    public BaseFragment() {
//        // Required empty public constructor
//    }

    public BaseActivity baseActivity;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        baseActivity= (BaseActivity) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean createMenu(int menuId, Menu menu, MenuInflater inflater) {
        inflater.inflate(menuId, menu);
        return false;
    }

    public MainActivity getMainActivity() {
        if(baseActivity instanceof MainActivity){
            return (MainActivity) baseActivity;
        }
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                getFragmentManager().popBackStack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setTitle(String name) {
        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
        ActionBar actionBar=appCompatActivity.getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setTitle(name);
        }
    }

    public void setTitle(SpannableString name) {
        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
        ActionBar actionBar=appCompatActivity.getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setTitle(name);
        }
    }

    public void setTitle(int id) {
        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
        ActionBar actionBar=appCompatActivity.getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setTitle(id);
        }
    }

}
