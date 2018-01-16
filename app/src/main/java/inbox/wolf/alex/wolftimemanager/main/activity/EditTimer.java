package inbox.wolf.alex.wolftimemanager.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.main.timemanager.TimeChanger;
import inbox.wolf.alex.wolftimemanager.main.timemanager.TimeConvertToLong;

public class EditTimer extends AppCompatActivity {

    public static final int LAYOUT = R.layout.dialog_edit_timer;
    private static long time, hr, min, sec;

    @BindView(R.id.hr_text_view)
    TextView hrTextView;
    @BindView(R.id.min_text_view)
    TextView minTextView;
    @BindView(R.id.sec_text_view)
    TextView secTextView;
    TimeChanger timeChanger;
    @BindView(R.id.set_description_timer_edit_text)
    EditText descriptionEditText;

    @BindView(R.id.add_hr)
    ImageView addHr;
    @BindView(R.id.reduce_hr)
    ImageView reduceHr;
    @BindView(R.id.add_min)
    ImageView addMin;
    @BindView(R.id.reduce_min)
    ImageView reduceMin;
    @BindView(R.id.add_sec)
    ImageView addSec;
    @BindView(R.id.reduce_sec)
    ImageView reduceSec;

    TimeConvertToLong convertToLong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

        readIntent();
        convertToLongTimer();
    }

    private void readIntent() {
        Intent intent = getIntent();
        descriptionEditText.setText(intent.getStringExtra("description"));
    }

    private void convertToLongTimer() {
        convertToLong = new TimeConvertToLong(Integer.valueOf(hrTextView.getText().toString()),
                Integer.valueOf(minTextView.getText().toString()),
                Integer.valueOf(secTextView.getText().toString()));
    }

    @OnClick(R.id.add_hr)
    void onAddHr(){
        timeChanger = new TimeChanger(hr);
        if(timeChanger.addTime(99, addHr, reduceHr)){
            timeChanger.setTime(++hr);
            hrTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.reduce_hr)
    void onReduceHr(){
        timeChanger = new TimeChanger(hr);
        if(timeChanger.reduceTime(reduceHr, addHr)){
            timeChanger.setTime(--hr);
            hrTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.add_min)
    void onAddMin(){
        timeChanger = new TimeChanger(min);
        if(timeChanger.addTime(60, addMin, reduceMin)){
            timeChanger.setTime(++min);
            minTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.reduce_min)
    void onReduceMin(){
        timeChanger = new TimeChanger(min);
        if(timeChanger.reduceTime(reduceMin, addMin)){
            timeChanger.setTime(--min);
            minTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.add_sec)
    void onAddSec(){
        timeChanger = new TimeChanger(sec);
        if(timeChanger.addTime(60, addSec, reduceSec)){
            timeChanger.setTime(++sec);
            secTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.reduce_sec)
    void onReduceSec(){
        timeChanger = new TimeChanger(sec);
        if(timeChanger.reduceTime(reduceSec, addSec)){
            timeChanger.setTime(--sec);
            secTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.resume_timer_btn)
    void onResumeTimer(){
        Intent intent = new Intent();
        String description = descriptionEditText.getText().toString();
        convertToLongTimer();
        String timeLong = convertToLong.convertToLongMillis();
        intent.putExtra("description", description);
        intent.putExtra("timeLong", timeLong);
        setResult(RESULT_OK, intent);
        finish();
    }

    @OnClick(R.id.delete_timer_btn)
    void onDeleteTimer(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hr = 0;
        min = 0;
        sec = 0;
    }

}
