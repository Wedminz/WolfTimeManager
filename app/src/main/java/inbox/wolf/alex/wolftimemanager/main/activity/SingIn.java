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
import inbox.wolf.alex.wolftimemanager.main.auth.EmailSingIn;


public class SingIn extends AppCompatActivity {

    public static final int LAYOUT = R.layout.activity_sing_in;

    @BindView(R.id.password_edit_text)
    EditText passwordEt;
    @BindView(R.id.email_edit_text)
    EditText emailEt;
    EmailSingIn emailSingIn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
        emailSingIn = new EmailSingIn(this);
    }

    @OnClick(R.id.sing_up)
    void onSingUp() {
        startActivity(new Intent(this, SingUp.class));
        finish();
    }

    @OnClick(R.id.sing_in_btn)
    void onSingIn(){
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();

        if(!email.equals("") && !password.equals(""))
            emailSingIn.signInWithEmailAndPassword(email, password);
        else if(email.equals(""))
            emailEt.setError(getString(R.string.required_field));
        else if(password.equals(""))
            passwordEt.setError(getString(R.string.required_field));
    }

    @OnClick(R.id.forgot_password)
    void onForgotPassword() {
        startActivity(new Intent(this, ResetPassword.class));
    }
}
