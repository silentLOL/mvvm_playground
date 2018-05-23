package stefanirndorfer.at.mvvm_playground.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import stefanirndorfer.at.mvvm_playground.R;
import stefanirndorfer.at.mvvm_playground.viewmodel.LiveDataMainActivityViewModel;

public class MainActivity extends AppCompatActivity implements GreetingDialogListener {

    private static final String GREETING_DIALOG_TAG = "greeting_dialog_tag";
    private LiveDataMainActivityViewModel viewModel;

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
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(LiveDataMainActivityViewModel.class);
        subscribe();
    }

    private void subscribe() {
        final Observer<String> fizzBuzzOutputObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                String newText = s + " it is!";
                ((TextView) findViewById(R.id.fizz_buzz_textview)).setText(newText);
            }
        };
        viewModel.getFizzBuzzOutput().observe(this, fizzBuzzOutputObserver);
    }
}
