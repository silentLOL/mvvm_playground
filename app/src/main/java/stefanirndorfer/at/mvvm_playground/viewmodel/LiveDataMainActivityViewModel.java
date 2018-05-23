package stefanirndorfer.at.mvvm_playground.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.SystemClock;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class LiveDataMainActivityViewModel extends ViewModel {

    private static final int ONE_SECOND = 1000;
    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String FIZZBUZZ = "fizz buzz";
    private static final String INITIAL_OUTPUT = "lets go!";

    private MutableLiveData<String> mFizzBuzzOutput = new MutableLiveData<>();
    private long initialTime;

    public LiveDataMainActivityViewModel() {
        initialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public final String TAG = LiveDataMainActivityViewModel.class.getName();

            @Override
            public void run() {
               final long newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000;
               mFizzBuzzOutput.postValue(getTheFizzBuzz(newValue));
                Log.d(TAG, "new Value " + mFizzBuzzOutput.getValue());
            }
        }, ONE_SECOND, ONE_SECOND);
    }

    private String getTheFizzBuzz(long newValue) {
        if (newValue % 3 == 0 && newValue % 5 == 0)
            return FIZZBUZZ;
        if (newValue % 3 == 0)
            return FIZZ;
        if (newValue % 5 == 0)
            return BUZZ;
        return String.valueOf(newValue);
    }

    public LiveData<String> getFizzBuzzOutput() {
        return mFizzBuzzOutput;
    }
}
