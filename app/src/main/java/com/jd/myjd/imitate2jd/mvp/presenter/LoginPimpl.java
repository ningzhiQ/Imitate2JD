package com.jd.myjd.imitate2jd.mvp.presenter;

import com.jd.myjd.imitate2jd.bean.LoginBean;
import com.jd.myjd.imitate2jd.mvp.model.LoginMimpl;
import com.jd.myjd.imitate2jd.mvp.model.LoginModel;
import com.jd.myjd.imitate2jd.mvp.view.OtherView;

public class LoginPimpl implements LoginPresener {
    private OtherView loginView;
    private LoginMimpl loginMi;

    public LoginPimpl(OtherView loginView) {
        this.loginView = loginView;
        this.loginMi = new LoginMimpl();
    }
    public void LoginPRequest(String path,String uname,String upwd){
        loginMi.login(new LoginModel() {
            @Override
            public void ModelNewsSuccess(LoginBean loginBean) {
                loginView.RequestNewsSuccess(loginBean);
            }
        },path,uname,upwd);
    }

    @Override
    public void destroy() {

    }
}
