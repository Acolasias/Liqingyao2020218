package com.bawei.hujintao.contract;

import com.bawei.hujintao.model.bean.OrderBean;
import com.bawei.hujintao.model.bean.PayBean;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface IOrderContract {
    interface IView{
        void onSuccess(OrderBean orderBean);
        void onFailure(Throwable throwable);
        void onOSuccess(PayBean payBean);
        void onOFailure(Throwable throwable);
    }
    interface IPresenter{
        void getOrderData(int status, int page);
        void getOrderPData(String orid);
    }
    interface IModel{
        void getOrderData(int status, int page, IModelCall iModelCall);
        interface IModelCall{
            void onSuccess(OrderBean orderBean);
            void onFailure(Throwable throwable);
        }
        void getOrderPData(String orid, IModelCa iModelCa);
        interface IModelCa{
            void onOSuccess(PayBean payBean);
            void onOFailure(Throwable throwable);
        }
    }
}
