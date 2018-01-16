package inbox.wolf.alex.wolftimemanager.main.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.main.auth.EmailSingIn;

public class ResetPassword extends AppCompatActivity {

    public static final int LAYOUT = R.layout.dialog_reset_password;
    EmailSingIn emailSingIn;

    @BindView(R.id.user_email_reset)
    EditText userEmailEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
        emailSingIn = new EmailSingIn(this);
    }

    @OnClick(R.id.reset_password_btn)
    void onResetPassword() {
        String email = userEmailEt.getText().toString();
        if(!email.equals(""))
            emailSingIn.sendPasswordResetEmail(email);
        else
            userEmailEt.setError(getString(R.string.validation_text_empty));
    }
}
