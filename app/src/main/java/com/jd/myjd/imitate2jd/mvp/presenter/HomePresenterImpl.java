package com.jd.myjd.imitate2jd.mvp.presenter;

import com.jd.myjd.imitate2jd.bean.AdvertisingBean;
import com.jd.myjd.imitate2jd.mvp.model.HomeModel;
import com.jd.myjd.imitate2jd.mvp.model.HomeModelImpl;
import com.jd.myjd.imitate2jd.mvp.view.HomeView;

public class HomePresenterImpl implements HomePresenter{
    private HomeView homeView;
    private HomeModelImpl homeModelImpl;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        this.homeModelImpl = new HomeModelImpl();
    }



    public void getdata(){
        homeModelImpl.getdata(new HomeModel() {
            @Override
            public void SuccessCallback(AdvertisingBean mbean) {
                homeView.SuccessCallback(mbean);
            }

            @Override
            public void FailerCallback(int code) {
                homeView.FailerCallback(code);
            }
        });
    }
    @Override
    public void destroys() {
        if (homeView!=null) {
            homeView=null;
        }
    }
}
