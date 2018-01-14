package inbox.wolf.alex.wolftimemanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.view.timemanager.TimeChanger;
import inbox.wolf.alex.wolftimemanager.view.timemanager.TimeConvertToLong;

public class CreateTimer extends AppCompatActivity {

    private static final int LAYOUT = R.layout.dialog_create_timer;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        timeChanger = new TimeChanger(time);
        convertToLong = new TimeConvertToLong(Integer.valueOf(hrTextView.getText().toString()),
                Integer.valueOf(minTextView.getText().toString()),
                Integer.valueOf(secTextView.getText().toString()));
    }

    @OnClick(R.id.add_hr)
    void onAddHr(){
        if(timeChanger.addTime(99, addHr, reduceHr)){
            timeChanger.setTime(++hr);
            hrTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.reduce_hr)
    void onReduceHr(){
        if(timeChanger.reduceTime(reduceHr, addHr)){
            timeChanger.setTime(--hr);
            hrTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.add_min)
    void onAddMin(){
        if(timeChanger.addTime(60, addMin, reduceMin)){
            timeChanger.setTime(++min);
            minTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.reduce_min)
    void onReduceMin(){
        if(timeChanger.reduceTime(reduceMin, addMin)){
            timeChanger.setTime(--min);
            minTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.add_sec)
    void onAddSec(){
        if(timeChanger.addTime(60, addSec, reduceSec)){
            timeChanger.setTime(++sec);
            secTextView.setText(timeChanger.getFormatTime());
        }
    }

    @OnClick(R.id.reduce_sec)
    void onReduceSec(){
        if(timeChanger.reduceTime(reduceSec, addSec)){
            timeChanger.setTime(--sec);
            secTextView.setText(timeChanger.getFormatTime());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hr = 0;
        min = 0;
        sec = 0;
    }

    @OnClick(R.id.create_time_btn)
    void onCreateTimer(){
        Intent intent = new Intent();
        String description = descriptionEditText.getText().toString();
        String timeLong = convertToLong.convertToLongMillis();
        intent.putExtra("description", description);
        intent.putExtra("timeLong", timeLong);
        setResult(RESULT_OK, intent);
        finish();
    }
}
