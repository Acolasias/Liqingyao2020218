package com.bawei.hujintao.presenter;

import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.ILoginContract;
import com.bawei.hujintao.model.LoginModel;
import com.bawei.hujintao.model.bean.LoginBean;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class LoginPresenter extends BasePresenter<ILoginContract.IView> implements ILoginContract.IPresenter {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void getLoginData(int page,String key) {
        loginModel.getLoginData(page,key, new ILoginContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                view.onSuccess(loginBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
