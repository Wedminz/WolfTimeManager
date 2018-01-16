package inbox.wolf.alex.wolftimemanager.main.timemanager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.ImageView;

public class TimeChanger extends Activity{

    private long time;
    private String formatTime;

    public static final int TIME_MIN_VALUE = 0;

    public TimeChanger(long time) {
        this.time = time;
    }

    @SuppressLint("DefaultLocale")
    public String getFormatTime() {
        formatTime = String.format("%02d",  time);
        return formatTime;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeChanger that = (TimeChanger) o;

        if (time != that.time) return false;
        return formatTime != null ? formatTime.equals(that.formatTime) : that.formatTime == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (time ^ (time >>> 32));
        result = 31 * result + (formatTime != null ? formatTime.hashCode() : 0);
        return result;
    }

    public boolean addTime(int maxTime, ImageView add, ImageView reduce){
        if(time < maxTime) {
            reduce.setEnabled(true);
            return true;
        } else{
            add.setEnabled(false);
            return false;
        }
    }

    public boolean reduceTime(ImageView reduce, ImageView add){
        if (time > TIME_MIN_VALUE) {
            add.setEnabled(true);
            return true;
        } else {
            reduce.setEnabled(false);
            return false;
        }
    }

}
