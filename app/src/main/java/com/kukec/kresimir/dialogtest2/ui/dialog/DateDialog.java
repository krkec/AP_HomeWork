package com.kukec.kresimir.dialogtest2.ui.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.TimeZone;




public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DateDialogListener callbackListener;

    public void setDateDialogCallback(DateDialogListener dateDialogCallback) {
        this.callbackListener = dateDialogCallback;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        if (callbackListener != null) {
            callbackListener.onDialogActionFinished(year, monthOfYear, dayOfMonth);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog
                = new DatePickerDialog(getActivity(), this, year, month, day);
        return datePickerDialog;
    }


}
