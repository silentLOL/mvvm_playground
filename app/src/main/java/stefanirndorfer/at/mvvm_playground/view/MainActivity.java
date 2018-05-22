package stefanirndorfer.at.mvvm_playground.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import stefanirndorfer.at.mvvm_playground.R;
import stefanirndorfer.at.mvvm_playground.databinding.ActivityMainBinding;
import stefanirndorfer.at.mvvm_playground.viewmodel.ActivityMainViewModel;

public class MainActivity extends AppCompatActivity implements GreetingDialogListener {

    private static final String GREETING_DIALOG_TAG = "greeting_dialog_tag";
    //private ActivityMainViewModel activityMainViewModel;

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
        initDataBinding();
    }

    private void initDataBinding() {
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel
    }
}
