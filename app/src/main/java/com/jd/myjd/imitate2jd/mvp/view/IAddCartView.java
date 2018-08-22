package com.jd.myjd.imitate2jd.mvp.view;

import com.jd.myjd.imitate2jd.bean.AddCart;

public interface IAddCartView {
    void onFailure(String error);

    void onResponse(AddCart addCart);
}
