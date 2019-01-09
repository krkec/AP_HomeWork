package com.kukec.kresimir.dialogtest2.ui.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kukec.kresimir.dialogtest2.R;
import com.kukec.kresimir.dialogtest2.database.SharedPrefDb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {
 @BindView(R.id.tv2)
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        getDataFromDb(tv2);
    }
    private void getDataFromDb(TextView tv){
        SharedPrefDb db = SharedPrefDb.getInstance(this);
        tv2.setText(db.getMessageFromDB());
    }

}
