package com.jd.myjd.imitate2jd.mvp.presenter;

import com.jd.myjd.imitate2jd.bean.AddCart;
import com.jd.myjd.imitate2jd.mvp.model.AddCartModel;
import com.jd.myjd.imitate2jd.mvp.view.IAddCartView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AddCartPresenter {
    private AddCartModel addCartModel;
    IAddCartView mIAddCartView;
    public AddCartPresenter(IAddCartView iAddCartView) {
        mIAddCartView = iAddCartView;
        addCartModel = new AddCartModel();
    }
    public void addCart(int uid, int pid) {
        addCartModel.addCart("http://www.zhaoapi.cn/product/addCart", uid, pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddCart>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIAddCartView.onFailure(e.toString());
                    }

                    @Override
                    public void onNext(AddCart addCart) {
                        mIAddCartView.onResponse(addCart);
                    }
                });
    }
}
