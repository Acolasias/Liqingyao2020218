package com.bawei.hujintao.widget;
import com.bawei.hujintao.model.bean.LoginBean;
import com.bawei.hujintao.model.bean.OrderBean;
import com.bawei.hujintao.model.bean.PayBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface Api {
    //首页
    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<LoginBean> login(@Query("keyword") String key, @Query("page") int page, @Query("count") int count);
    //订单状态
    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<OrderBean> or(@Header("userId") int uid, @Header("sessionId") String sid,
                             @Query("status") int status, @Query("page") int page, @Query("count") int count);
    @FormUrlEncoded
    @POST("small/order/verify/v1/pay")
    Observable<PayBean> pay(@Header("userId") int uid, @Header("sessionId") String sid, @Field("orderId") String orderId, @Field("payType") int type);
}
