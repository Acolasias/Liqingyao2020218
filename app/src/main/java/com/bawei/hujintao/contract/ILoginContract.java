package com.bawei.hujintao.contract;

import com.bawei.hujintao.model.bean.LoginBean;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface ILoginContract {
    interface IView{
        void onSuccess(LoginBean loginBean);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void getLoginData(int page, String key);
    }
    interface IModel{
        void getLoginData(int page, String key, IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(LoginBean loginBean);
            void onFailure(Throwable throwable);
        }
    }
}
