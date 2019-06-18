package learn.lqf.com.baselibrary.utils;


import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.ALog;

import java.util.List;

import learn.lqf.com.baselibrary.R;


/**
 * CCreated by TU on 2018/12/7.
 */

public class DialogUtils {
    private static DialogUtils instance;

    public static DialogUtils getInstance() {
        return instance;
    }

    public DialogUtils() {
        instance = this;
    }

    private MaterialDialog mDialog;

    public void showProgressDialog(Context context, String title) {
        dissDialog();
        try {
            mDialog = new MaterialDialog.Builder(context)
                    .title(title)
                    .content("请稍等...")
                    .cancelable(false)
                    .widgetColor(context.getResources().getColor(R.color.dialog))
                    .progress(true, 0)
                    .progressIndeterminateStyle(false)
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showWarningDialog(Context context, String message) {
        dissDialog();
        try {
            mDialog = new MaterialDialog.Builder(context)
                    .content(message)
                    .cancelable(false)
                    .negativeText("确定")
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showAboutDialog(Context context, String title, String msg) {
        dissDialog();
        mDialog = new MaterialDialog.Builder(context)
                .title(title)
                .content(msg)
                .cancelable(false)
                .negativeText("确定")
                .show();
    }

    public void showAlertDialog(Context context, String msg, String cancelText, MaterialDialog.SingleButtonCallback positiveCallback) {
        dissDialog();
        mDialog = new MaterialDialog.Builder(context)
                .content(msg)
                .cancelable(false)
                .negativeText(cancelText)
                .positiveText("确定")
                .onPositive(positiveCallback)
                .show();
    }

    public void showAlertDialog(Context context, String title, String msg, String cancelText, MaterialDialog.SingleButtonCallback positiveCallback) {
        dissDialog();
        mDialog = new MaterialDialog.Builder(context)
                .title(title)
                .content(msg)
                .cancelable(false)
                .negativeText(cancelText)
                .positiveText("确定")
                .onPositive(positiveCallback)
                .show();
    }

    public void showNormalDialog(Context context, String title, String msg, MaterialDialog.SingleButtonCallback positiveCallback) {
        dissDialog();
        mDialog = new MaterialDialog.Builder(context)
                .title(title)
                .content(msg)
                .cancelable(false)
                .negativeText("取消")
                .positiveText("确定")
                .onPositive(positiveCallback)
                .show();
    }

    public void showPictureDialog(Context context, MaterialDialog.ListCallback callback) {
        dissDialog();

        mDialog = new MaterialDialog.Builder(context)
                .title("请选择")
                .items("相册", "拍照")
                .itemsCallback(callback)
                .negativeText("取消")
                .show();
    }

    public void showListDialog(Context context, List<String> items, MaterialDialog.ListCallback callback) {
        dissDialog();
        mDialog = new MaterialDialog.Builder(context)
                .items(items)
                .itemsCallback(callback)
                .negativeText("取消")
                .show();

    }

    public void dissDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        } else {
            ALog.e("MaterialDialog", mDialog == null);
        }
    }

}

