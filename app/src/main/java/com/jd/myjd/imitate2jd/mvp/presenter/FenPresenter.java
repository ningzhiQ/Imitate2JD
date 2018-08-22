package com.jd.myjd.imitate2jd.mvp.presenter;

//实现M层的接口

import com.jd.myjd.imitate2jd.bean.Yean;
import com.jd.myjd.imitate2jd.bean.Zean;
import com.jd.myjd.imitate2jd.mvp.model.FenModel;
import com.jd.myjd.imitate2jd.mvp.view.IFenView;

public class FenPresenter implements FenModel.ScuMod {
    IFenView view;

    FenModel model;
    public FenPresenter(IFenView view) {

        this.view = view;

        model = new FenModel();

        model.setScuMod(this);

    }
    @Override

    public void Zc(Zean bean) {

        view.onZuo(bean);

    }



    @Override

    public void Yc(Yean yean) {

        view.onYou(yean);

    }
    //左侧调用

    public void  ShowPer(){

        model.ZuoChen();

    }

    // 右侧调用

    public void FlShowYou(int cont){

        model.YuoChen(cont);

    }

}
