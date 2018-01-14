package inbox.wolf.alex.wolftimemanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import inbox.wolf.alex.wolftimemanager.R;

public class EditTimer extends AppCompatActivity {

    public static final int LAYOUT = R.layout.dialog_edit_timer;

    @BindView(R.id.set_description_timer_edit_text)
    EditText setDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

        readIntent();
    }

    private void readIntent() {
        Intent intent = getIntent();
        setDescription.setText(intent.getStringExtra("description"));
    }

}
