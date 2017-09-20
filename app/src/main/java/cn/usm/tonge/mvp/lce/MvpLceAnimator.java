package cn.usm.tonge.mvp.lce;

import android.view.View;


/**
 * Created by google on 2017/9/7 0007.
 */

//策略接口
public interface MvpLceAnimator {

    /**
     * 显示加载页面
     * @param loadingView
     * @param conotentView
     * @param errorView
     */
    void showLoadingView(View loadingView, View conotentView, View errorView);

    /**
     * 显示内容页面
     * @param loadingView
     * @param conotentView
     * @param errorView
     */
    void showContentView(View loadingView, View conotentView, View errorView);

    /**
     * 显示错误页面
     * @param loadingView
     * @param conotentView
     * @param errorView
     */
    void showErrorView(View loadingView, View conotentView, View errorView);

}
