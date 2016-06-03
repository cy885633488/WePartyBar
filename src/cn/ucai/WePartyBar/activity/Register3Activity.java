/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ucai.WePartyBar.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.ucai.WePartyBar.R;

/**
 * 注册页
 *
 */
public class Register3Activity extends BaseActivity {
    private final static String TAG = Register1Activity.class.getName();
    EditText etPhoneNumber,etEmail,etPassword,etConfirmPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        etPhoneNumber = (EditText) findViewById(R.id.phone_number);
        etEmail = (EditText) findViewById(R.id.email);
        etPassword = (EditText) findViewById(R.id.password);
        etConfirmPwd = (EditText) findViewById(R.id.confirm_password);
        findViewById(R.id.register3_iv_images).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("main","you xiao");
            }
        });
    }

    /**
     * 注册
     *
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register1_btn_back:
                break;
            case R.id.register1_next:

                break;
            case R.id.register1_user_token:
                break;
        }
        final String phonenumber = etPhoneNumber.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String pwd = etPassword.getText().toString().trim();
        String confirm_pwd = etConfirmPwd.getText().toString().trim();
        if (TextUtils.isEmpty(phonenumber)) {
            Toast.makeText(this, getResources().getString(R.string.Phone_number_cannot_be_empty), Toast.LENGTH_SHORT).show();
            etPhoneNumber.requestFocus();
            return;
        }else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, getResources().getString(R.string.Email_cannot_be_empty), Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        }else if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, getResources().getString(R.string.Password_cannot_be_empty), Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return;
        } else if (TextUtils.isEmpty(confirm_pwd)) {
            Toast.makeText(this, getResources().getString(R.string.Confirm_password_cannot_be_empty), Toast.LENGTH_SHORT).show();
            etConfirmPwd.requestFocus();
            return;
        } else if (!pwd.equals(confirm_pwd)) {
            Toast.makeText(this, getResources().getString(R.string.Two_input_password), Toast.LENGTH_SHORT).show();
            return;
        }

        if (!TextUtils.isEmpty(phonenumber) && !TextUtils.isEmpty(pwd)) {
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setMessage(getResources().getString(R.string.Is_the_registered));
            pd.show();

//			new Thread(new Runnable() {
//				public void run() {
//					try {
//						// 调用sdk注册方法
//						EMChatManager.getInstance().createAccountOnServer(phonenumber, pwd);
//						runOnUiThread(new Runnable() {
//							public void run() {
//								if (!RegisterActivity.this.isFinishing())
//									pd.dismiss();
//								// 保存用户名
//								WePartyBarApplication.getInstance().setUserName(phonenumber);
//								Toast.makeText(getApplicationContext(), getResources().getString(R.string.Registered_successfully), Toast.LENGTH_SHORT).show();
//								finish();
//							}
//						});
//					} catch (final EaseMobException e) {
//						runOnUiThread(new Runnable() {
//							public void run() {
//								if (!RegisterActivity.this.isFinishing())
//									pd.dismiss();
//								int errorCode=e.getErrorCode();
//								if(errorCode==EMError.NONETWORK_ERROR){
//									Toast.makeText(getApplicationContext(), getResources().getString(R.string.network_anomalies), Toast.LENGTH_SHORT).show();
//								}else if(errorCode == EMError.USER_ALREADY_EXISTS){
//									Toast.makeText(getApplicationContext(), getResources().getString(R.string.User_already_exists), Toast.LENGTH_SHORT).show();
//								}else if(errorCode == EMError.UNAUTHORIZED){
//									Toast.makeText(getApplicationContext(), getResources().getString(R.string.registration_failed_without_permission), Toast.LENGTH_SHORT).show();
//								}else if(errorCode == EMError.ILLEGAL_USER_NAME){
//								    Toast.makeText(getApplicationContext(), getResources().getString(R.string.illegal_user_name),Toast.LENGTH_SHORT).show();
//								}else{
//									Toast.makeText(getApplicationContext(), getResources().getString(R.string.Registration_failed) + e.getMessage(), Toast.LENGTH_SHORT).show();
//								}
//							}
//						});
//					}
//				}
//			}).start();
        }
    }

    public void back(View view) {
        finish();
    }

}
