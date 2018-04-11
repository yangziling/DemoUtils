package com.houli.demoutils;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import pub.devrel.easypermissions.EasyPermissions;

public class TestActivity extends BaseActivity implements OnClickListener {

    private static final int REQUEST_CODE = 0;
    private static final int REQUEST_CAMERA_PERM = 101;

    private Button mBtnScan;
    private TextView mTvScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();

    }



    private void initView() {
        mBtnScan = (Button) findViewById(R.id.btn_scan);
        mTvScan = (TextView) findViewById(R.id.tv_scan);
        mBtnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_scan) {
            if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
                Intent intent = new Intent(TestActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            } else {
                EasyPermissions.requestPermissions(this, "需要请求相机权限", REQUEST_CAMERA_PERM, Manifest.permission.CAMERA);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    mTvScan.setText(result);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(TestActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }




}
