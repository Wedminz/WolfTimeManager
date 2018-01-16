package inbox.wolf.alex.wolftimemanager.main.timemanager;

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

    public void startTimer(long timer) {
        if(timeCounter == null) {
            timeCounter = new TimeCounter(context);
            thread = new Thread(timeCounter);
            thread.start();
            timeCounter.resume(timer);
        }
    }

    public void stopTimer() {
        if(timeCounter != null){
            timeCounter.stop();
            if(thread != null){
                thread.interrupt();
                thread = null;
            }
            timeCounter = null;
        }
    }

    public void pauseTimer() {
        if(timeCounter != null){
            timeCounter.stop();
            thread = null;
        }
    }

    public void pauseResumeTimer(){
        thread = new Thread(timeCounter);
        thread.start();
        timeCounter.pause();
    }

    public void customTimer(long timer){
        if(timer != 0){
            startTimer(timer);
        }else {
            startTimer();
        }
    }

}
