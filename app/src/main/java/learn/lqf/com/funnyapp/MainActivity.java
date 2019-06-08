package learn.lqf.com.funnyapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import learn.lqf.com.commonlibrary.constant.RouterConstant;
import learn.lqf.com.funnyapp.databinding.ActivityMainBinding;

@Route(path = "/app/main")
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setMain(this);
        ARouter.getInstance().inject(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main:
                ARouter.getInstance().build(RouterConstant.ACTIVITY_EAT_MAIN)
                .withString("a","jun").navigation();
                break;
        }
    }
}
