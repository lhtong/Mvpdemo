package cn.usm.tonge.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.usm.tonge.R;
import cn.usm.tonge.app.AppManager;
import cn.usm.tonge.mvp.delegate.MvpActivityDelegateImpl;
import cn.usm.tonge.mvp.delegate.MvpCallback;

/**
 * Created by google on 2017/9/7 0007.
 */

public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends AppCompatActivity implements MvpCallback<V, P> {

    protected LayoutInflater mLayoutInflater;
    private Unbinder mUnbinder;

    private P presneter;
    private V view;
    //代理Activity的生命周期函数
    private MvpActivityDelegateImpl<V, P> delegateImpl;

    public MvpActivityDelegateImpl<V, P> getDelegateImpl() {
        if (delegateImpl == null) {
            this.delegateImpl = new MvpActivityDelegateImpl<V, P>(this);
        }
        return delegateImpl;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutInflater = LayoutInflater.from(this);
        //添加到堆栈管理器
        AppManager.getAppManager().addActivity(this);
        //设置布局文件
        setBaseView();
        mUnbinder = ButterKnife.bind(this);
        getDelegateImpl().onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除管理
        AppManager.getAppManager().finishActivity(this);
        mUnbinder.unbind();
        getDelegateImpl().onDestroy();
    }

    @Override
    public P getPresneter() {
        return presneter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.presneter = presenter;
    }

    @Override
    public void setMvpView(V view) {
        this.view = view;
    }

    @Override
    public V getMvpView() {
        return this.view;
    }


    public abstract int getContentLayoutId();

    /**
     * 设置BaseView方法
     */
    public void setBaseView() {
        LinearLayout rootView = (LinearLayout) mLayoutInflater.inflate(getBaseViewLayoutId(), null);
        FrameLayout contentView = rootView.findViewById(R.id.contentView);
        contentView.addView(mLayoutInflater.inflate(getContentLayoutId(), rootView, false));
        setContentView(rootView);
    }

    /**
     * 获取基础布局文件
     *
     * @return
     */
    public int getBaseViewLayoutId() {
        return R.layout.view_mvp;
    }

}
