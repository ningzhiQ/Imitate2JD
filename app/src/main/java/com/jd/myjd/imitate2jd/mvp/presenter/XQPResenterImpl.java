package com.jd.myjd.imitate2jd.mvp.presenter;

import com.jd.myjd.imitate2jd.bean.ClassXqBean;
import com.jd.myjd.imitate2jd.mvp.model.XQModel;
import com.jd.myjd.imitate2jd.mvp.model.XQModelImpl;
import com.jd.myjd.imitate2jd.mvp.view.XQView;

public class XQPResenterImpl implements XQPresenter{
    private XQView xqView;
    private XQModelImpl xqModelimpl;

    public XQPResenterImpl(XQView xqView) {
        this.xqView = xqView;
        this.xqModelimpl = new XQModelImpl();
    }

    public void getdata(int pscid,int page){
        xqModelimpl.getdata(new XQModel() {
            @Override
            public void SuccessCallback(ClassXqBean mbean) {
                xqView.SuccessCallback(mbean);
            }

            @Override
            public void FailerCallback(int code) {
                xqView.FailerCallback(code);
            }
        },pscid,page);
    }
    @Override
    public void destroys() {
        if (xqView!=null) {
            xqView=null;
        }
    }
}
