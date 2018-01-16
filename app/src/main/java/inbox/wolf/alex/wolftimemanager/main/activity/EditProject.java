package inbox.wolf.alex.wolftimemanager.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import inbox.wolf.alex.wolftimemanager.R;

public class EditProject extends AppCompatActivity {

    public static final int LAYOUT = R.layout.dialog_edit_project;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
    }
}
