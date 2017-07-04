package com.weex.sample.utils;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.weex.sample.ImageAdapter;
import com.weex.sample.extend.compontent.RichText;
import com.weex.sample.extend.module.PhoneInfoModule;

/**
 * Created by zhangshaofang on 2017/7/4.
 */

public class WXSDKUtils {
    public static void init(Application application) {
        InitConfig config = new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
        WXSDKEngine.initialize(application, config);
        try {
            WXSDKEngine.registerModule("poneInfo", PhoneInfoModule.class);
            WXSDKEngine.registerComponent("rich", RichText.class, false);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}
