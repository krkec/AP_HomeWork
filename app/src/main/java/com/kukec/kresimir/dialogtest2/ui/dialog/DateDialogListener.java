package com.kukec.kresimir.dialogtest2.ui.dialog;

import android.widget.DatePicker;

public interface DateDialogListener {
    //void onDateSet(DatePicker view, int year, int month, int dayOfMonth);
    void onDialogActionFinished(int year, int month, int dayOfMonth);
}
