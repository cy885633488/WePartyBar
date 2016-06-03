package cn.ucai.WePartyBar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.ucai.WePartyBar.R;

/**
 * Created by Administrator on 2016/6/2.
 */
public class WelcomeActivity extends BaseActivity {
    private final static String TAG = WelcomeActivity.class.getName();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.welcome_btnRegister:
                startActivity(new Intent(WelcomeActivity.this,Register1Activity.class));
                break;
            case R.id.welcome_btnLogin:
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                break;
        }
    }
}
