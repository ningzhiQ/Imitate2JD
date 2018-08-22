package com.jd.myjd.imitate2jd.mvp.view;

import com.jd.myjd.imitate2jd.bean.Yean;
import com.jd.myjd.imitate2jd.bean.Zean;

public interface IFenView {
    void onZuo(Zean zean);//左侧请求成功
    void onYou(Yean yean);//右侧请求成功
}
