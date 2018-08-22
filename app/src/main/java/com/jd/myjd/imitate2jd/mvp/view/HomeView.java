package com.jd.myjd.imitate2jd.mvp.view;

import com.jd.myjd.imitate2jd.bean.AdvertisingBean;

public interface HomeView {
    void SuccessCallback(AdvertisingBean vbean);
    void FailerCallback(int code);
}
