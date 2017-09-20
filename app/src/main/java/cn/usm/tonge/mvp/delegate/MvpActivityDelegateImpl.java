package cn.usm.tonge.mvp.delegate;

import android.os.Bundle;

import cn.usm.tonge.mvp.MvpPresenter;
import cn.usm.tonge.mvp.MvpView;

//第二重代理->目标对象->针对的是Activity生命周期
public class MvpActivityDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements MvpActivityDelegate<V, P> {

    private ProxyMvpCallback<V, P> proxyMvpCallback;
    private MvpCallback<V, P> mvpCallback;

    public MvpActivityDelegateImpl(MvpCallback<V, P> mvpCallback) {
        this.mvpCallback = mvpCallback;
        if (mvpCallback == null) {
            throw new NullPointerException("不能够为空");
        }
        this.proxyMvpCallback = new ProxyMvpCallback<>(mvpCallback);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //绑定处理
        this.proxyMvpCallback.createPresenter();
        this.proxyMvpCallback.createView();
        this.proxyMvpCallback.attachView();
    }

    @Override
    public void onDestroy() {
        this.proxyMvpCallback.detachView();
    }

}
