package cn.usm.tonge.mvp.delegate;

import android.os.Bundle;

import cn.usm.tonge.mvp.MvpPresenter;
import cn.usm.tonge.mvp.MvpView;

//第二重代理->目标接口->针对Activity生命周期进行代理
public interface MvpActivityDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    void onCreate(Bundle savedInstanceState);

    void onDestroy();

}
