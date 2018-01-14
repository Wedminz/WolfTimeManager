package inbox.wolf.alex.wolftimemanager.view.timemanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public static String convertToLongMillis(int h, int m, int s){
        String t = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        String time = h + ":" + m + ":" + s;
        try {
            Date date = f.parse("1970-01-01 " + time);
            t = String.valueOf(date.getTime());
        } catch (ParseException e) {
            Log.d("myLog", "Error!" + e.getMessage());
            e.printStackTrace();
        }
        return t;
    }
}
