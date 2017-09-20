package cn.usm.tonge.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.usm.tonge.R;
import cn.usm.tonge.mvp.delegate.MvpCallback;
import cn.usm.tonge.mvp.delegate.MvpFragmentDelegateImpl;

/**
 * Created by google on 2017/9/14 0014.
 */

public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends Fragment implements MvpCallback<V, P> {
    private Unbinder mUnbinder;
    private P presneter;
    private V view;

    //代理Fragment的生命周期函数
    private MvpFragmentDelegateImpl<V, P> delegateImpl;

    public MvpFragmentDelegateImpl<V, P> getDelegateImpl() {
        if (delegateImpl == null) {
            this.delegateImpl = new MvpFragmentDelegateImpl<V, P>(this);
        }
        return delegateImpl;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDelegateImpl().onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.view_mvp, null);
        FrameLayout contentView = rootView.findViewById(R.id.contentView);
        contentView.addView(inflater.inflate(getContentLayoutId(), rootView, false));
        mUnbinder = ButterKnife.bind(rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
}
