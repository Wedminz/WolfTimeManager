package inbox.wolf.alex.wolftimemanager.view.timemanager;

import android.content.Context;

public class ManageTimer {

    private TimeCounter timeCounter;
    private Thread thread;
    private Context context;

    public ManageTimer(Context context){
        this.context = context;
    }

    public void startTimer() {
        if(timeCounter == null) {
            timeCounter = new TimeCounter(context);
            thread = new Thread(timeCounter);
            thread.start();
            timeCounter.start();
        }
    }

    public void stopTimer() {
        if(timeCounter != null){
            timeCounter.stop();
            thread.interrupt();
            thread = null;
            timeCounter = null;
        }
    }

    public void pauseTimer() {
        if(timeCounter != null){
            timeCounter.stop();
            thread = null;
        }
    }

}
