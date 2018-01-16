package inbox.wolf.alex.wolftimemanager.main.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import inbox.wolf.alex.wolftimemanager.R;

public class CreateProject extends AppCompatActivity {


    public static final int LAYOUT = R.layout.dialog_create_project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
    }
}
