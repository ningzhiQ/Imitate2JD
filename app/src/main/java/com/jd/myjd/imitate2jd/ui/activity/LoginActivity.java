package com.jd.myjd.imitate2jd.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jd.myjd.imitate2jd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {


    @BindView(R.id.otherlogin)
    TextView otherlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Fresco.initialize(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.otherlogin)
    public void onViewClicked() {
        startActivity(new Intent(LoginActivity.this, OthetActivity.class));
        finish();
    }


}
