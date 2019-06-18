package learn.lqf.com.baselibrary.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.blankj.ALog;
import com.hjq.toast.ToastUtils;

import learn.lqf.com.baselibrary.utils.DialogUtils;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/12 15:30
 */

public abstract class BaseFragment extends Fragment {

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    protected DialogUtils dUtils;
    protected boolean refresh = true;

    @Override
    public void onAttach(Context context) {
        if (context instanceof Activity) {

        } else {
            throw new ClassCastException("Activity can't cast to Activity");
        }
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dUtils = new DialogUtils();

        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            assert getFragmentManager() != null;
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ALog.e("savedInstanceState不为空", isSupportHidden ? "显示" : "隐藏");
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    public void setLeft() {
    }

    public void setTitle(String title) {
    }

    public void setRight() {
    }

    public void goTo(Class clazz) {
        startActivity(new Intent(getActivity(), clazz));
    }

    public void showToast(String msg) {
        ToastUtils.show(msg);
    }

    public void showProgressDialog(String title) {
        dUtils.showProgressDialog(getActivity(), title);
    }

    public void showWarningDialog(String message) {
        dUtils.showWarningDialog(getActivity(), message);
    }

    public void dissDialog() {
        dUtils.dissDialog();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}
