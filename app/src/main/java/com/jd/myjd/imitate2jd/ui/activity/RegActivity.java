package com.jd.myjd.imitate2jd.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.api.JDApi;
import com.jd.myjd.imitate2jd.bean.EventBean;
import com.jd.myjd.imitate2jd.bean.RegestBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import server.LoginInterface;

public class RegActivity extends Activity {


    @BindView(R.id.regest_back)
    ImageView regestBack;
    @BindView(R.id.regest_name)
    EditText regestName;
    @BindView(R.id.regest_password)
    EditText regestPassword;
    @BindView(R.id.regest_but)
    Button regestBut;
    private String Rename;
    private String Repwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        //注册按钮点击事件
        regestButListener();
        //点击返回箭头进行返回
        regestBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void regestButListener() {
        regestBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rename = regestName.getText().toString();
                Repwd = regestPassword.getText().toString();
                if (!TextUtils.isEmpty(Rename) && !TextUtils.isEmpty(Repwd)) {
                    //进行注册
                    Regest(JDApi.BaseApi,Rename,Repwd);
                }else{
                    Toast.makeText(RegActivity.this,"抱歉！注册内容不能为空",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    //注册方法
    private void Regest(String path, final String rename, String repwd) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginInterface loginInterface = retrofit.create(LoginInterface.class);
        Call<RegestBean> regest = loginInterface.getRegest(rename, repwd);
        regest.enqueue(new Callback<RegestBean>() {
            @Override
            public void onResponse(Call<RegestBean> call, Response<RegestBean> response) {
                EventBus.getDefault().post(new EventBean(rename,null));
                Toast.makeText(RegActivity.this,"注册成功,将为您自动跳转到登录页面",Toast.LENGTH_LONG).show();

                finish();
            }

            @Override
            public void onFailure(Call<RegestBean> call, Throwable t) {

            }
        });
    }

}
