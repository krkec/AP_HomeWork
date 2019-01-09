package com.kukec.kresimir.dialogtest2.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefDb {
    private static SharedPrefDb instance;
    private static SharedPreferences sp;
    private static final String KEY_LOG_MESSAGE = "KEY_LOG_MESSAGE";


    private SharedPrefDb() {
        super();
    }

    public static synchronized SharedPrefDb getInstance(final Context applicationContext){
        if (instance==null || sp==null){
            instance = new SharedPrefDb();
            sp = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        }
        return instance;
    }
    public String getMessageFromDB() {
        return sp.getString(KEY_LOG_MESSAGE, "");
    }
    public void addMessageToDb(final String msg){
        String oldValue = getMessageFromDB();
        String newValue;
        if (oldValue.length()==0){
            newValue =msg;
        } else {
            newValue= oldValue + "||"+msg;
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_LOG_MESSAGE, newValue);
    }
}
