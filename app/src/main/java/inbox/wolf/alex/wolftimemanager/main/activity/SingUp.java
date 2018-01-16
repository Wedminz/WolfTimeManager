package inbox.wolf.alex.wolftimemanager.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.main.auth.EmailRegistration;


public class SingUp extends AppCompatActivity {

    public static final int LAYOUT = R.layout.activity_sing_up;
    EmailRegistration registration;
    @BindView(R.id.email_edit_text)
    EditText emailEt;
    @BindView(R.id.first_last_edit_text)
    EditText userNameEt;
    @BindView(R.id.password_edit_text)
    EditText passwordEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
        registration = new EmailRegistration(this);
    }

    @OnClick(R.id.registration_btn)
    void onRegistration() {
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();

        if(!email.equals("") && !password.equals(""))
            registration.createUserWithEmailAndPassword(email, password);
        else if(email.equals(""))
            emailEt.setError(getString(R.string.required_field));
        else if(password.equals(""))
            passwordEt.setError(getString(R.string.required_field));
    }

    @OnClick(R.id.sing_in_btn)
    void onSingIn() {
        startActivity(new Intent(this, SingIn.class));
        finish();
    }
}
