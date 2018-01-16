package inbox.wolf.alex.wolftimemanager.main.timemanager;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeConvertToLong {

    private int hours;
    private int minutes;
    private int seconds;

    public TimeConvertToLong(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String convertToLongMillis(){
        String t = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        String time = hours + ":" + minutes + ":" + seconds;
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
