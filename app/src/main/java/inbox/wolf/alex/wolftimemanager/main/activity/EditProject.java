package inbox.wolf.alex.wolftimemanager.main.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inbox.wolf.alex.wolftimemanager.R;

public class EditProject extends AppCompatActivity {

    public static final int LAYOUT = R.layout.dialog_edit_project;
    public static final int EDIT_PROJECT_NAME = 10;
    @BindView(R.id.set_project_name_edit_text)
    EditText projectTitle;
    String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        projectTitle.setText(title);
    }

    @OnClick(R.id.delete_group_btn)
    void onDeleteGroup() {
        alertDialog();
    }

    @OnClick(R.id.edit_group_btn)
    void onEditGroup() {
        String title = projectTitle.getText().toString();
        if(!title.equals("")) {
            Intent intent = new Intent(this, ProjectList.class);
            intent.putExtra("title", title);
            setResult(EDIT_PROJECT_NAME, intent);
            finish();
        } else {
            projectTitle.setError(getString(R.string.required_field));
        }
    }

    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(EditProject.this);
        builder.setMessage(R.string.delete_dialog_in_project_edit)
                .setPositiveButton(getString(R.string.yes_btn), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setResult(RESULT_OK);
                        Toast.makeText(EditProject.this, getString(R.string.project_notify) + " " + title + " " +
                                getString(R.string.success_delete_notify), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setNegativeButton(getString(R.string.no_btn), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setResult(RESULT_CANCELED);
                        finish();
                    }
                });
        builder.create().show();
    }
}
