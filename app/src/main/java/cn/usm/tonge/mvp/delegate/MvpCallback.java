package cn.usm.tonge.mvp.delegate;

import cn.usm.tonge.mvp.MvpPresenter;
import cn.usm.tonge.mvp.MvpView;

//第一重代理->目标接口->抽象解绑和绑定(MvpCallback)
public interface MvpCallback<V extends MvpView, P extends MvpPresenter<V>> {

    //创建Presenter
    P createPresenter();

    //创建View
    V createView();

    void setPresenter(P presenter);

    P getPresneter();

    void setMvpView(V view);

    V getMvpView();
}
