package cn.usm.tonge.mvp.lce;


import cn.usm.tonge.mvp.MvpView;


/**
 * Created by google on 2017/9/7 0007.
 */

//目标接口
//UI层：交互接口(只要你集成了Lce，那么你先指定数据类型)
public interface MvpLceView<D> extends MvpView {

    /**
     * 开始加载
     *
     * @param isPullRefresh 普通页面、下拉刷新组件
     */
    void showLoading(boolean isPullRefresh);

    /**
     * 开始内容
     *
     * @param isPullRefresh 普通页面、下拉刷新组件
     */
    void showContent(boolean isPullRefresh);

    /**
     * 开始错误
     *
     * @param isPullRefresh 普通页面、下拉刷新组件
     */
    void showError(boolean isPullRefresh);

}
