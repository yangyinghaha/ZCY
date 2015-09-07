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
public class PersonFragment extends BaseFragment {

    public static final String TAG="PersonFragment";
    public static PersonFragment newInstance() {
        PersonFragment fragment = new PersonFragment();
        return fragment;
    }

    public static void jumpIn(AppCompatActivity appCompatActivity) {
        Fragment fragment = PersonFragment.newInstance();
        FragmentManager manager = appCompatActivity.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.rl_container, fragment, PersonFragment.TAG)
                .addToBackStack(null)
                .commit();

    }
    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(getString(R.string.text_person));
    }
}
