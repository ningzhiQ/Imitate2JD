package com.jd.myjd.imitate2jd.mvp.view;

import com.jd.myjd.imitate2jd.bean.SelectBean;
import com.jd.myjd.imitate2jd.bean.UpdateBean;

public class Shopp_Contract {
    public interface Model {
        //添加
        void GetShoppAdd(String uid,String pid,String token,ModelData data);
        //查询
        void GetShoppSelect(String uid,String token,ModelData data);
        //更新
        void GetShoppUpdate(String uid,String selleridm,String pid,String selected,String num,ModelData data );
        //删除
        void GetShoppDelete(String uid,String pid,String token,ModelData data);
        public interface ModelData{
            //添加
            void getadd(UpdateBean updateBean);
            //查询
            void getSelect(SelectBean selectBean);

        }
    }

    public interface View {
        //添加
        void GetShoppAddBean(UpdateBean updateBean);
        //查询
        void GetShoppSelectBean(SelectBean selectBean);

    }

    public interface Presenter {
        //添加
        void GetShoppAdd(String pid);
        //查询
        void GetShoppSelect();
        //更新
        void GetShoppUpdate(String sellerid,String pid,String selected,String num );
        //删除
        void GetShoppDelete(String pid);
    }
}
