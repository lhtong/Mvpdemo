package cn.usm.tonge.mvp.lce;

import android.view.View;

import cn.usm.tonge.R;



/**
 * Created by google on 2017/9/7 0007.
 */

//目标对象
public class MvpLceViewImpl<D> implements MvpLceView<D> {

    private MvpLceAnimator lceAnimator;

    public void setLceAnimator(MvpLceAnimator lceAnimator) {
        this.lceAnimator = lceAnimator;
    }

    public MvpLceAnimator getLceAnimator() {
        if (this.lceAnimator == null){
            this.lceAnimator = new MvpLceDefaultAnimator();
        }
        return lceAnimator;
    }

    private View loadingView;
    private View contentView;
    private View errorView;

    public void initView(View rootView){
        if (rootView == null){
            throw new NullPointerException("rootView不能够为空");
        }
        if (loadingView == null){
            this.loadingView = rootView.findViewById(R.id.loadingView);
        }
        if (contentView == null){
            this.contentView = rootView.findViewById(R.id.contentView);
        }
        if (errorView == null){
            this.errorView = rootView.findViewById(R.id.errorView);
        }
        if (loadingView == null){
            throw new NullPointerException("loadingView不能够为空");
        }
        if (contentView == null){
            throw new NullPointerException("contentVeiw不能够为空");
        }
        if (errorView == null){
            throw new NullPointerException("errorView不能够为空");
        }
    }

    @Override
    public void showLoading(boolean isPullRefresh) {
        if (!isPullRefresh){
            getLceAnimator().showLoadingView(loadingView, contentView, errorView);
        }
    }

    @Override
    public void showContent(boolean isPullRefresh) {
        if (!isPullRefresh){
            getLceAnimator().showContentView(loadingView, contentView, errorView);
        }
    }

    @Override
    public void showError(boolean isPullRefresh) {
        if (!isPullRefresh){
            getLceAnimator().showErrorView(loadingView, contentView, errorView);
        }
    }

}
