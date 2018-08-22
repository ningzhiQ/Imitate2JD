package com.jd.myjd.imitate2jd.mvp.view;

import com.jd.myjd.imitate2jd.bean.ClassXqBean;

public interface XQView {
    void SuccessCallback(ClassXqBean vbean);
    void FailerCallback(int code);
}
