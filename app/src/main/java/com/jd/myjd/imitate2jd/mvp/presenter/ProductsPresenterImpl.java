package com.jd.myjd.imitate2jd.mvp.presenter;

import com.jd.myjd.imitate2jd.bean.ProductsBean;
import com.jd.myjd.imitate2jd.mvp.model.ProductsModel;
import com.jd.myjd.imitate2jd.mvp.model.ProductsModelImpl;
import com.jd.myjd.imitate2jd.mvp.view.ProductsView;

public class ProductsPresenterImpl implements ProductsPresenter{
    private ProductsView productsView;
    private ProductsModelImpl productsModelimpl;

    public ProductsPresenterImpl(ProductsView productsView) {
        this.productsView = productsView;
        this.productsModelimpl = new ProductsModelImpl();
    }

    public void getdata(String keywords,int page){
        productsModelimpl.getdata(new ProductsModel() {
            @Override
            public void SuccessCallback(ProductsBean mbean) {
                productsView.SuccessCallback(mbean);
            }

            @Override
            public void FailerCallback(int code) {
                productsView.FailerCallback(code);
            }
        },keywords,page);
    }
    @Override
    public void destroys() {
        if (productsView!=null) {
            productsView=null;
        }
    }
}
