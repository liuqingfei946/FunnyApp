package learn.lqf.com.baselibrary.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import java.util.LinkedList;


/**
 * 本项目由
 * mvp
 * +dagger2
 * +retrofit
 * +rxjava
 * +butterknife组成
 */
public abstract class BaseApplication extends Application {
    static private BaseApplication mApplication;
    public LinkedList<BaseCommonActivity> mActivityList;

    protected final String TAG = this.getClass().getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

    }


    /**
     * 提供基础url给retrofit
     *
     * @return
     */
    protected abstract String getBaseUrl();


    /**
     * 返回上下文
     *
     * @return
     */
    public static Context getContext() {
        return mApplication;
    }

    /**
     * 返回一个存储所有存在的activity的列表
     *
     * @return
     */
    public LinkedList<BaseCommonActivity> getActivityList() {
        if (mActivityList == null) {
            mActivityList = new LinkedList<>();
        }
        return mActivityList;
    }
    /**
     * 退出所有activity
     */
    public static void killAll() {
        Intent intent = new Intent(BaseCommonActivity.ACTION_RECEIVER_ACTIVITY);
        intent.putExtra("type", "killAll");
        getContext().sendBroadcast(intent);
    }
}
