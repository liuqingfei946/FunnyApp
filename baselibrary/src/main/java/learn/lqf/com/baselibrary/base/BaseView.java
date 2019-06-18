package learn.lqf.com.baselibrary.base;


/**
 *  * Created by TU on 2018/12/7.
 * BaseView
 */
public interface BaseView {
    void initData();

    void setLeft();

    void setTitle(String title);

    void setRight();

    void goTo(Class clazz);

    void showToast(String msg);

    void showWarningDialog(String message);

    void showProgressDialog(String title);

    void dissDialog();


}
