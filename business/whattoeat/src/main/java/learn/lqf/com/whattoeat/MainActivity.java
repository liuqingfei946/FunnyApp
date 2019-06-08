package learn.lqf.com.whattoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/eat/main")
public class MainActivity extends AppCompatActivity {

    @Autowired
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        if(ARouter.getInstance()!=null) {
            ARouter.getInstance().inject(this);
            ((TextView)findViewById(R.id.dd)).setText(a);

        }
    }
}
