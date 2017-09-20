package cn.usm.tonge.login;

import cn.usm.tonge.mvp.MvpPresenter;

/**
 * Created by google on 2017/9/7 0007.
 */

public class LoginPresenter extends MvpPresenter<LoginView> {

    private LoginModel loginModel;

    public LoginPresenter() {
        this.loginModel = new LoginModel();
    }

    public void login(String loginName) {
        String success = loginModel.login(loginName);
        if (getView() != null) {
            getView().loginSuccess(success);
        }
    }

}
