package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.bean.AdvertisingBean;

public interface HomeModel {
    void SuccessCallback(AdvertisingBean mbean);
    void FailerCallback(int code);
}
