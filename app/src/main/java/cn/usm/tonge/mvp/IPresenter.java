package cn.usm.tonge.mvp;

/**
 * Created by google on 2017/9/5 0005.
 */

public interface IPresenter<V extends MvpView> {

    void attachView(V v);

    void detachView();

}
