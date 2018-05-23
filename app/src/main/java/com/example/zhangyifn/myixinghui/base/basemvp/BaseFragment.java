package com.example.zhangyifn.myixinghui.base.basemvp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangyifn.myixinghui.App;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import java.util.List;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public abstract class BaseFragment<V extends BaseView,P extends BasePresenter> extends MvpFragment {

    public View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         if (rootView==null){
             rootView=getView(inflater,container,savedInstanceState);
             initUI();
         }
        return rootView;
    }



    public View getRootView() {
        return rootView;
    }

    public App getApp() {
        return (App) getActivity().getApplication();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }



   /*          通用方法              */
    public void replaceChildFragment(@IdRes int id, Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(id, fragment).commit();
    }



    public <T> void  toSetList(List<T> list, List<T> newList, boolean isMore){

        if(list!=null && newList!=null){
            synchronized (BaseFragment.class){
                if(!isMore){
                    list.clear();
                }
                list.addAll(newList);
            }
        }
    }


    /*子fragment必须需要实现的方法*/
    protected abstract View getView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initDatas();

    protected abstract void initUI();
}
