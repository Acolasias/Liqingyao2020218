package com.bawei.hujintao.model;

import com.bawei.hujintao.contract.IOrderContract;
import com.bawei.hujintao.model.bean.OrderBean;
import com.bawei.hujintao.model.bean.PayBean;
import com.bawei.hujintao.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class OrderModel implements IOrderContract.IModel {
    @Override
    public void getOrderData(int status,int page, IModelCall iModelCall) {
        NetUtil.getInstance().getApi().or(28237,"158219885213028237",status,page,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderBean orderBean) {
                        iModelCall.onSuccess(orderBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCall.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getOrderPData(String orid, IModelCa iModelCa) {
        NetUtil.getInstance().getApi().pay(27823,"158166443136227823",orid,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayBean payBean) {
                        iModelCa.onOSuccess(payBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCa.onOFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
