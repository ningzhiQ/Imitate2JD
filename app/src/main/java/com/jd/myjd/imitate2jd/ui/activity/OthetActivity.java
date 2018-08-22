package com.jd.myjd.imitate2jd.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.api.JDApi;
import com.jd.myjd.imitate2jd.bean.EventBean;
import com.jd.myjd.imitate2jd.bean.LoginBean;
import com.jd.myjd.imitate2jd.mvp.presenter.LoginPimpl;
import com.jd.myjd.imitate2jd.mvp.view.OtherView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OthetActivity extends Activity implements OtherView{

    @BindView(R.id.true_layout_cuo)
    ImageView trueLayoutCuo;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.regest)
    TextView regest;
    private String edusername;
    private String edpassword;
    private LoginPimpl loginPi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othet);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        //点击错号返回监听
        cuoListener();


        loginPi = new LoginPimpl(this);

        //点击登录进行post请求
        loginClickListener(JDApi.BaseApi);
    }
    //eventbus值
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventData(EventBean eventBean) {
        username.setText(eventBean.getMoblie());
    }

    private void loginClickListener(String baseApi) {
        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //获取用户名以及密码
                edusername = username.getText().toString();
                edpassword = password.getText().toString();
                if (!TextUtils.isEmpty(edusername) && !TextUtils.isEmpty(edpassword)) {
                    //登录
                    login(JDApi.BaseApi, edusername, edpassword);
                } else {
                    Toast.makeText(OthetActivity.this, "抱歉！登录内容不能为空", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void login(String path, String uname, String upwd) {
        loginPi.LoginPRequest(path, uname, upwd);
    }

    private void cuoListener() {
        trueLayoutCuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @OnClick(R.id.regest)
    public void onViewClicked() {
        startActivity(new Intent(OthetActivity.this, RegActivity.class));
    }

    @Override
    public void RequestNewsSuccess(LoginBean loginBean) {
        Toast.makeText(OthetActivity.this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
        if (loginBean.getCode().equals("0")){
            EventBus.getDefault().post(new EventBean(edusername,null));
            finish();
        }

    }

}
