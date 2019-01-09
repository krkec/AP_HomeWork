package com.kukec.kresimir.dialogtest2.ui.screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kukec.kresimir.dialogtest2.R;
import com.kukec.kresimir.dialogtest2.task.BackgroundIntentService;
import com.kukec.kresimir.dialogtest2.ui.dialog.DateDialog;
import com.kukec.kresimir.dialogtest2.ui.dialog.DateDialogListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.kukec.kresimir.dialogtest2.utils.AppKeys.INTENT_EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv1)
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.tv1)
    public void dateD(){
        DateDialog dateDialog = new DateDialog();
        dateDialog.setDateDialogCallback(new DateDialogListener() {
            @Override
            public void onDialogActionFinished(int year, int month, int dayOfMonth) {
                tv1.setText(year+"."+month +"."+dayOfMonth);
            }
        });
        dateDialog.show(getFragmentManager(),"Date dialog");

    }
    @OnClick(R.id.btn1)
    public void btn1(){
        Intent intent = new Intent(this,BackgroundIntentService.class);
        intent.putExtra(INTENT_EXTRA_MESSAGE,15000);
        startService(intent);
    }
    @OnClick(R.id.btn2)
    public void btn2(){
        Intent intent = new Intent(this,Main2Activity.class);
        this.startActivity(intent);
    }
}
