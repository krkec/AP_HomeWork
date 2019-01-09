package com.kukec.kresimir.dialogtest2.ui.dialog;

/**
 * Example using interfaces to:
 * 1. Avoid activity cast
 * 2. Communicate over interface
 * 3. Make same Dialog usable by multiple activities
 */
public interface DialogCallback {

    void onDialogActionFinished(String result);
}
