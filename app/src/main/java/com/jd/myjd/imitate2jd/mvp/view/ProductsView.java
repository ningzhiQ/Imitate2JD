package com.jd.myjd.imitate2jd.mvp.view;

import com.jd.myjd.imitate2jd.bean.ProductsBean;

public interface ProductsView {
    void SuccessCallback(ProductsBean vbean);
    void FailerCallback(int code);
}
