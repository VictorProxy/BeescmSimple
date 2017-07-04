package cn.beescm.simple;

import android.app.Application;
import android.content.Context;

import com.chenenyu.router.Router;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.weex.sample.ImageAdapter;
import com.weex.sample.extend.compontent.RichText;
import com.weex.sample.extend.module.PhoneInfoModule;
import com.weex.sample.utils.WXSDKUtils;

/**
 * Created by zhangshaofang on 2017/6/30
 */
public class BeescmApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Router.initialize(this);
        WXSDKUtils.init(this);
    }


}
