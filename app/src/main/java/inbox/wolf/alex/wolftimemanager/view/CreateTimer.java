package inbox.wolf.alex.wolftimemanager.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import inbox.wolf.alex.wolftimemanager.R;

public class CreateTimer extends AppCompatActivity {

    public static final int LAYOUT = R.layout.dialog_create_timer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

    }
}
