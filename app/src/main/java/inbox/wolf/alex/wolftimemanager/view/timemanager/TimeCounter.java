package inbox.wolf.alex.wolftimemanager.view.timemanager;

import android.annotation.SuppressLint;
import android.content.Context;
import inbox.wolf.alex.wolftimemanager.view.ProjectList;

public class TimeCounter implements Runnable {

    public static final long MILLIS_TO_MINUTES = 60000;
    public static final long MILLIS_TO_HOURS = 3600000;
    private Context context;
    private long mStartTime, since;
    private boolean mIsRunning;

    public TimeCounter(Context context) {
        this.context = context;
    }

    public void start(){
        mStartTime = System.currentTimeMillis();
        mIsRunning = true;
    }

    public void stop(){
        mIsRunning = false;
    }

    public void pause(){
        mStartTime = System.currentTimeMillis() - since;
        mIsRunning = true;
    }
    public void resume (long mLong){
        mStartTime = System.currentTimeMillis() - mLong;
        mIsRunning = true;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void run() {

        while (mIsRunning){
            since = System.currentTimeMillis() - mStartTime;
            int seconds = (int)((since / 1000)%60);
            int minutes = (int)((since / MILLIS_TO_MINUTES)%60);
            int hours = (int)((since / MILLIS_TO_HOURS)%24);
            ((ProjectList)context).setTimeCounter(String.format(
                    "%02d : %02d : %02d", hours, minutes, seconds
            ), since);
        }

    }
}
