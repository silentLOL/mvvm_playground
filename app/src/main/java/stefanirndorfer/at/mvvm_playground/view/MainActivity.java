package stefanirndorfer.at.mvvm_playground.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import stefanirndorfer.at.mvvm_playground.R;

public class MainActivity extends AppCompatActivity implements GreetingDialogListener {

    private static final String GREETING_DIALOG_TAG = "greeting_dialog_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        showGreetingDialogue();
    }

    private void showGreetingDialogue() {
        GreetingDialog greetingDialog = GreetingDialog.newInstance(this);
        greetingDialog.show(getSupportFragmentManager(), GREETING_DIALOG_TAG);
    }

    @Override
    public void onDialogDone() {

    }
}
