package cn.amber.zxs.zcy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.amber.zxs.zcy.fragment.FindFragment;
import cn.amber.zxs.zcy.fragment.HomeFragment;
import cn.amber.zxs.zcy.fragment.PersonFragment;
import cn.amber.zxs.zcy.fragment.ShopFragment;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.rl_container)
    RelativeLayout mRlContainer;
    @InjectView(R.id.rb_home)
    RadioButton mRbHome;
    @InjectView(R.id.rb_shop)
    RadioButton mRbShop;
    @InjectView(R.id.rb_find)
    RadioButton mRbFind;
    @InjectView(R.id.rb_person)
    RadioButton mRbPerson;
    @InjectView(R.id.rg_bottom)
    RadioGroup mRgBottom;
    @InjectView(R.id.rl_navi_bottom)
    RelativeLayout mRlNaviBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initToolbar();
        initEvent();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mRbHome.setChecked(true);
        HomeFragment.jumpIn(this);
    }

    private void initEvent() {

        mRgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        HomeFragment.jumpIn(MainActivity.this);
                        break;
                    case R.id.rb_shop:
                        ShopFragment.jumpIn(MainActivity.this);
                        break;
                    case R.id.rb_find:
                        FindFragment.jumpIn(MainActivity.this);
                        break;
                    case R.id.rb_person:
                        PersonFragment.jumpIn(MainActivity.this);
                        break;
                }
            }
        });
    }


    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    //退出时间
    private long currentBackPressTime=0;
    //退出间隔
    private static int BACK_PRESSED_INTERVAL=2000;

    //退出
    @Override
    public void onBackPressed() {
        Fragment homeFragment=getSupportFragmentManager().findFragmentByTag("HomeFragment");
        Fragment shopFragment=getSupportFragmentManager().findFragmentByTag("ShopFragment");
        Fragment findFragment=getSupportFragmentManager().findFragmentByTag("FindFragment");
        Fragment personment=getSupportFragmentManager().findFragmentByTag("PersonFragment");
        if (homeFragment!=null&&homeFragment.isVisible()){
            doExit();
        }else if (shopFragment!=null&&shopFragment.isVisible()){
            doExit();
        }else if (findFragment!=null&&findFragment.isVisible()){
            doExit();
        }else if (personment!=null&&personment.isVisible()){
            doExit();
        }else {
            super.onBackPressed();
        }
    }

    public void doExit(){
        if (System.currentTimeMillis()-currentBackPressTime>BACK_PRESSED_INTERVAL){
            currentBackPressTime=System.currentTimeMillis();
            Toast.makeText(this,getString(R.string.text_exit_app),Toast.LENGTH_SHORT).show();
        }else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
