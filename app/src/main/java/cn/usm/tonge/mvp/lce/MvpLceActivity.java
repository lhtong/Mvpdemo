package cn.usm.tonge.mvp.lce;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.usm.tonge.R;
import cn.usm.tonge.mvp.MvpActivity;
import cn.usm.tonge.mvp.MvpPresenter;
import cn.usm.tonge.mvp.MvpView;

/**
 * Created by google on 2017/9/7 0007.
 */

public abstract class MvpLceActivity<D, V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> implements MvpLceView<D> {

    //持有目标对象引用
    private MvpLceViewImpl<D> lceView;

    private MvpLceViewImpl<D> getLceView() {
        if (lceView == null) {
            lceView = new MvpLceViewImpl<D>();
        }
        return lceView;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化View
        getLceView().initView(getWindow().getDecorView());
    }

    //动态指定动画策略
    public void setLceAnimator(MvpLceAnimator mvpLceAnimator) {
        getLceView().setLceAnimator(mvpLceAnimator);
    }

    @Override
    public void showContent(boolean isPullRefresh) {
        getLceView().showContent(isPullRefresh);
    }

    @Override
    public void showLoading(boolean isPullRefresh) {
        getLceView().showLoading(isPullRefresh);
    }

    @Override
    public void showError(boolean isPullRefresh) {
        getLceView().showError(isPullRefresh);
    }

    public int getBaseViewLayoutId() {
        return R.layout.view_mvp_lce;
    }

}
