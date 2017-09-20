package cn.usm.tonge.mvp;

/**
 * Created by google on 2017/9/7 0007.
 */

public class MvpPresenter<V extends MvpView> implements IPresenter<V> {

    private V view;

    public V getView() {
        return view;
    }


    @Override
    public void attachView(V v) {
        this.view = v;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
