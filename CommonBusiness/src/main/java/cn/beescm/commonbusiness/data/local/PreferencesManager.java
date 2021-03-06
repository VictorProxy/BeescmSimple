package cn.beescm.commonbusiness.data.local;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhangshaofang on 2017/6/30
 */
public class PreferencesManager {

    public static final String PREFERENCES_NAME = "cn.beescm.commonbusiness";
    private SharedPreferences sharedPreferences;


    public PreferencesManager(Application application) {
        sharedPreferences = application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void saveLoginInfo(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }


    public String getUserName() {
        return sharedPreferences.getString("username", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }

}
