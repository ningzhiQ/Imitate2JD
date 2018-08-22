package com.jd.myjd.imitate2jd.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.ui.fragment.ClassificationFragment;
import com.jd.myjd.imitate2jd.ui.fragment.FindFragment;
import com.jd.myjd.imitate2jd.ui.fragment.HomeFragment;
import com.jd.myjd.imitate2jd.ui.fragment.MyFragment;
import com.jd.myjd.imitate2jd.ui.fragment.ShoppingFragment;

public class ReplaceActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private HomeFragment homeFragment;
    private ClassificationFragment classificationFragment;
    private FindFragment findFragment;
    private ShoppingFragment shoppingFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace);
        radioGroup = findViewById(R.id.radio_group);
        homeFragment= new HomeFragment();
        classificationFragment= new ClassificationFragment();
        findFragment= new FindFragment();
        shoppingFragment= new ShoppingFragment();
        myFragment= new MyFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_layout,homeFragment).commit();
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (checkedId) {
            case R.id.shouye_button:
                transaction.replace(R.id.fragment_layout, homeFragment).commit();
                break;
            case R.id.fenlei_button:
                transaction.replace(R.id.fragment_layout, classificationFragment).commit();
                break;
            case R.id.faxian_button:
                transaction.replace(R.id.fragment_layout, findFragment).commit();
                break;
            case R.id.gouwuche_button:
                transaction.replace(R.id.fragment_layout, shoppingFragment).commit();
                break;
            case R.id.wode_button:
                transaction.replace(R.id.fragment_layout, myFragment).commit();
                break;
        }
    }
}
