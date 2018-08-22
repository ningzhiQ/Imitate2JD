package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.bean.ClassXqBean;

public interface XQModel {
    void SuccessCallback(ClassXqBean mbean);
    void FailerCallback(int code);
}
