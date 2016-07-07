package com.firstvrp.censusdata;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.firstvrp.censusdata.Entity.VersionEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import org.apache.http.Header;

import java.io.File;

import Utils.PromptManager;

/**
 * 欢迎页
 * Created by chenyuan on 16/5/25.
 */
public class WelcomeActivity extends SherlockActivity {
    private static final int ENTER_HOME = 0X11;
    private static final int SHOW_UPDATE_DIALOG = 0X12;
    private TextView ii_version, ii_update_info;
    private String version;
    private String description;
    private String apkurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);

        ii_version = (TextView) findViewById(R.id.ii_version);
        ii_update_info = (TextView) findViewById(R.id.ii_update_info);
        init();
    }

    private void init() {
        version = getVersionName();
        ii_version.setText("版本号：" + version);
        checkUpdate(version);
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setClass(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    public String getVersionName() {
        // 获取packagemanager的实例
        PackageManager packageManager = this.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        assert packInfo != null;
        return packInfo.versionName;
    }

    /**
     * 检查是否有新版本，如果有就升级
     */
    private void checkUpdate(final String version) {
        TwitterRestClient.get(getString(R.string.url_version), null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                VersionEntity versionEntity = gson.fromJson(new String(responseBody), VersionEntity.class);

                if (versionEntity != null) {
                    description = versionEntity.getDescription();
                    apkurl = versionEntity.getApkurl();
                    //versionEntity.getVersion()
                    if (version.equals(versionEntity.getVersion())) {
                        //版本一致
                        handler.sendEmptyMessage(ENTER_HOME);
                    } else {
                        //版本不一致
                        handler.sendEmptyMessage(SHOW_UPDATE_DIALOG);
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                handler.sendEmptyMessage(ENTER_HOME);
                PromptManager.showToast(WelcomeActivity.this, "版本验证失败");
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ENTER_HOME:
                    new Handler().postDelayed(r, 1000);// 1秒后关闭，并跳转到主页面
                    break;
                case SHOW_UPDATE_DIALOG:
                    new Handler().postDelayed(r, 1000);
                    //showUpdateDialog();
                    break;
            }
        }
    };


    private void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(WelcomeActivity.this);
        builder.setTitle("提示升级");
        builder.setMessage(description);
        //强制升级，点击返回时不起作用，必须点击一个按键
        builder.setCancelable(false);
        //监听点击取消事件
        builder.setOnCancelListener
                (new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        //进入主页面
                        handler.sendEmptyMessage(ENTER_HOME);
                        dialog.dismiss();
                    }
                });
        builder.setPositiveButton("立即升级", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    FinalHttp finalHttp = new FinalHttp();
                    finalHttp.download(apkurl, Environment.getExternalStorageDirectory().getAbsolutePath() + "/app.apk", new AjaxCallBack<File>() {
                        @Override
                        public void onLoading(long count, long current) {
                            super.onLoading(count, current);
                            ii_update_info.setVisibility(View.VISIBLE);
                            int progress = (int) (current * 100 / count);
                            ii_update_info.setText("下载进度" + progress + "%");
                        }

                        @Override
                        public void onFailure(Throwable t, int errorNo, String strMsg) {
                            t.printStackTrace();
                            PromptManager.showToast(WelcomeActivity.this, "下载失败了");
                            handler.sendEmptyMessage(ENTER_HOME);
                            super.onFailure(t, errorNo, strMsg);
                        }

                        @Override
                        public void onSuccess(File file) {
                            super.onSuccess(file);
                            installAPK(file);
                        }

                        private void installAPK(File file) {
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.addCategory("android.intent.category.DEFAULT");
                            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                            startActivity(intent);
                        }
                    });
                } else {
                    PromptManager.showToast(WelcomeActivity.this, "没有sdcard");
                    return;
                }
            }
        });

//        .setNegativeButton("下次再说", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //对话框消除，进行主页面
////                        dialog.dismiss();
////                        handler.sendEmptyMessage(ENTER_HOME);
//                    }
//                }
//        )
        builder.show();
    }

}
