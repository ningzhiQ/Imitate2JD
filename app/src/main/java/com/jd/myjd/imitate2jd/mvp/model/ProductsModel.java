package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.bean.ProductsBean;

public interface ProductsModel {
    void SuccessCallback(ProductsBean mbean);
    void FailerCallback(int code);
}
