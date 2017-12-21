package org.asialee.weex.demo;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import org.asialee.weex.component.WXLottie;
import org.asialee.weex.demo.adapter.ImageAdapter;

/**
 * Created by liyazhou on 2017/12/21.
 */

public class WXApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initWeex();
    }

    private void initWeex() {
        // 自定义相关配置
        InitConfig config=new InitConfig.Builder()
                .setImgAdapter(new ImageAdapter()) // 自定义图片适配器
                //.setHttpAdapter(new WXHttpdnsAdatper()) // 自定义HTTP请求适配器
                .build();
        WXSDKEngine.initialize(this,config);

        // register module
        try {
            WXSDKEngine.registerComponent("lottie", WXLottie.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}
