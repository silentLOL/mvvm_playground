package stefanirndorfer.at.mvvm_playground.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import stefanirndorfer.at.mvvm_playground.R;

public class GreetingDialog extends DialogFragment {

    private View rootView;
    private GreetingDialogListener listener;

    public static GreetingDialog newInstance(GreetingDialogListener listener) {
        GreetingDialog dialog = new GreetingDialog();
        dialog.listener = listener;
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        initViews();
        final AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(rootView)
                .setTitle(R.string.greeting_dialog_title)
                .setCancelable(false)
                .setPositiveButton(R.string.got_it, null)
                .create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setOnShowListener(dialog -> {
            onDialogShow(alertDialog);
        });
        return alertDialog;
    }

    private void onDialogShow(AlertDialog alertDialog) {
        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(v -> onDoneClicked());
    }

    private void onDoneClicked() {
        this.listener.onDialogDone();
        dismiss();
    }

    private void initViews() {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.greeting_dialog, null, false);
    }
}
