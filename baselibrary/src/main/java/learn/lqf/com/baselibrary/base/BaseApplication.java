package learn.lqf.com.baselibrary.base;

import android.app.Application;
import android.content.Context;


/**
 * 本项目由
 * mvp
 * +retrofit
 * +rxjava
 * +databinding
 */
public abstract class BaseApplication extends Application {
    static private BaseApplication mApplication;

    protected final String TAG = this.getClass().getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

    }

    /**
     * 返回上下文
     *
     * @return
     */
    public static Context getContext() {
        return mApplication;
    }

}
