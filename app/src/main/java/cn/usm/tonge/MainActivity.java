package cn.usm.tonge;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.usm.tonge.login.LoginPresenter;
import cn.usm.tonge.login.LoginView;
import cn.usm.tonge.mvp.lce.MvpLceActivity;

public class MainActivity extends MvpLceActivity<String, LoginView, LoginPresenter> implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showContent(false);
    }

    public void login(View v) {
        getPresneter().login("lht");
    }

    @Override
    public void loginSuccess(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }


    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

}
