package com.jd.myjd.imitate2jd.mvp.presenter;

import com.jd.myjd.imitate2jd.bean.SelectBean;
import com.jd.myjd.imitate2jd.bean.UpdateBean;
import com.jd.myjd.imitate2jd.mvp.model.Shopp_Model;
import com.jd.myjd.imitate2jd.mvp.view.Shopp_Contract;
import com.jd.myjd.imitate2jd.ui.fragment.ShoppingFragment;

public class Shopp_Presenter implements Shopp_Contract.Presenter, Shopp_Contract.Model.ModelData{
    private Shopp_Contract.View view;
    private Shopp_Contract.Model model;
    private String uid;
    private String token;

    public Shopp_Presenter(ShoppingFragment view, String uid, String token) {
        this.view = view;
        this.model = new Shopp_Model();
        this.uid = uid;
        this.token = token;
    }

    @Override
    public void GetShoppAdd(String pid) {
        model.GetShoppAdd(uid, pid, token, this);
    }

    @Override
    public void GetShoppSelect() {
        model.GetShoppSelect(uid, token, this);
    }

    @Override
    public void GetShoppUpdate(String sellerid, String pid, String selected, String num) {
        model.GetShoppUpdate(uid, sellerid, pid, selected, num, this);
    }

    @Override
    public void GetShoppDelete(String pid) {
        model.GetShoppDelete(uid, pid, token, this);

    }

    @Override
    public void getadd(UpdateBean updateBean) {
        if (updateBean.getCode().equals("0")) {
            GetShoppSelect();
        } else {
            view.GetShoppAddBean(updateBean);
        }
    }

    @Override
    public void getSelect(SelectBean selectBean) {
        view.GetShoppSelectBean(selectBean);
    }
}
