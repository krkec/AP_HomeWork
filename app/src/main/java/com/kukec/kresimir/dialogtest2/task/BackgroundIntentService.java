package com.kukec.kresimir.dialogtest2.task;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.kukec.kresimir.dialogtest2.database.SharedPrefDb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackgroundIntentService extends IntentService {
    public static final String DURATION_PARAMETER_NAME = "TASK_DURATION";
    private static int DURATION = 15000;
    private Handler handler = new Handler(); // Used for accessing the Main Thread (because it is created on Main Thread)


    public BackgroundIntentService() {
        super("BackgroundIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent!=null){
            DURATION=intent.getIntExtra(DURATION_PARAMETER_NAME,DURATION);
            performLongTask();
        }
    }
    private void performLongTask() {
        try {
            Thread.sleep(DURATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onDestroy() {
        SharedPrefDb db = SharedPrefDb.getInstance(this);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        db.addMessageToDb(dateFormat.format(date));
        Toast.makeText(getApplicationContext(), "Data is saved to database.", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
