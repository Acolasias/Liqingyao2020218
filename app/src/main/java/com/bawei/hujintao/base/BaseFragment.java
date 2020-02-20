package com.bawei.hujintao.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public abstract class BaseFragment <P extends BasePresenter> extends Fragment {
    protected P presenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),layoutId(),null);
        presenter=prvidePresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        bind = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    protected abstract void initView(View view);

    protected abstract P prvidePresenter();

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detach();
        }
        if (bind != null) {
            bind.unbind();
        }
    }
}
