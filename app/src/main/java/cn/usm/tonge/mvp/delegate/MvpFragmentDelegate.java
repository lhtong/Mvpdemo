package cn.usm.tonge.mvp.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.usm.tonge.mvp.MvpPresenter;
import cn.usm.tonge.mvp.MvpView;

//写框架(重写Framework层)
public interface MvpFragmentDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    void onActivityCreated(@Nullable Bundle savedInstanceState);

    void onDestroy();

}