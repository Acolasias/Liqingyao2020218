package com.bawei.hujintao.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity {
    protected P presenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        presenter=providePresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();

    protected abstract P providePresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
        if (bind != null) {
            bind.unbind();
        }

    }
}
