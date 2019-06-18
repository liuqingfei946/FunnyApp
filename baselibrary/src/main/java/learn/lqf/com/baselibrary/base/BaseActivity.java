package learn.lqf.com.baselibrary.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.hjq.toast.ToastUtils;

import learn.lqf.com.baselibrary.utils.ActivityTool;
import learn.lqf.com.baselibrary.utils.DialogUtils;
import learn.lqf.com.baselibrary.utils.KeyBoardUtils;


/**
 * @description :不带Presenter的Activity
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 11:24
 */


public abstract class BaseActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    protected DialogUtils dUtils;
    protected boolean refresh = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTool.addActivity(this);
        dUtils = new DialogUtils();
        setDataBinding();
        initData();
    }

    public void setLeft() {
    }

    public void setTitle(String title) {
    }

    public void setRight() {
    }

    public void showToast(String s) {
        ToastUtils.show(s);
    }

    public AppCompatActivity getActivity() {
        return this;
    }

    public void goTo(Class clazz) {
        startActivity(new Intent(getActivity(), clazz));
    }

    public void showProgressDialog(String title) {
        if (!this.isFinishing())
            dUtils.showProgressDialog(this, title);
    }

    public void showWarningDialog(String message) {

        if (!this.isFinishing())
            dUtils.showWarningDialog(this, message);
    }

    public void dissDialog() {
        dUtils.dissDialog();
    }

    @Override
    protected void onDestroy() {
        ActivityTool.removeActivity(this);
        dUtils.dissDialog();
        super.onDestroy();
    }

    protected abstract void setDataBinding();

    protected abstract void initData();


    public void FullScreencall() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    /**
     * 传入EditText的Id
     * 没有传入的EditText不做处理
     *
     * @return id 数组
     */
    public int[] hideSoftByEditViewIds() {
        return null;
    }
    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作
     *
     * @return id 数组
     */
    public View[] filterViewByIds() {
        return null;
    }
    /**
     * 是否开启隐藏输入法键盘
     */
    public boolean openHideSoft() {
        return true;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (openHideSoft()) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                if (KeyBoardUtils.isTouchView(filterViewByIds(), ev)) {
                    return super.dispatchTouchEvent(ev);
                }
                if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds().length == 0) {
                    return super.dispatchTouchEvent(ev);
                }
                View v = getCurrentFocus();
                if (KeyBoardUtils.isFocusEditText(v, hideSoftByEditViewIds())) {
                    if (KeyBoardUtils.isTouchView(this, hideSoftByEditViewIds(), ev))
                        return super.dispatchTouchEvent(ev);
                    //隐藏键盘
                    KeyBoardUtils.hideInputForce(this);
                    KeyBoardUtils.clearViewFocus(v, hideSoftByEditViewIds());
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

}
