package inbox.wolf.alex.wolftimemanager.main.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inbox.wolf.alex.wolftimemanager.R;

public class CreateProject extends AppCompatActivity {

    public static final int LAYOUT = R.layout.dialog_create_project;

    @BindView(R.id.set_project_name_edit_text)
    EditText projectEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.create_group_btn)
    void onCreateGroup() {
        String projectName = projectEt.getText().toString();
        if(!projectName.equals("")){
            Intent intent = new Intent(this, ProjectList.class);
            intent.putExtra("projectName", projectName);
            setResult(RESULT_OK, intent);
            finish();
        }else {
            projectEt.setError(getString(R.string.validation_text_empty));
        }

    }
}
