package cn.usm.tonge.app;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by google on 2017/8/30 0030.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }


    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
