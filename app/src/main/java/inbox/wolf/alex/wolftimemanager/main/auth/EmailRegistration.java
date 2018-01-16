package inbox.wolf.alex.wolftimemanager.main.auth;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.main.activity.SingIn;

public class EmailRegistration {

    private Context context;

    private final String TAG = "AppDevLog";

    public EmailRegistration(Context context) {
        this.context = context;

    }

    public void createUserWithEmailAndPassword(final String email, final String password){
        final ProgressDialog dialog = ProgressDialog.show(context, "Title",
                "Text", true);
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.trim(), password.trim())
                .addOnCompleteListener(((Activity)context), new OnCompleteListener<AuthResult>() {
                    @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if(task.isSuccessful()){
                            context.startActivity(new Intent(context, SingIn.class));
                            ((Activity)context).finish();
                        } else {
                            try {
                                throw task.getException();
                            } catch(FirebaseAuthWeakPasswordException e) {
                                Toast.makeText(context, R.string.week_password_validation, Toast.LENGTH_SHORT).show();
                            } catch(FirebaseAuthInvalidCredentialsException e) {
                                Toast.makeText(context, R.string.error_invalid_email_validation, Toast.LENGTH_SHORT).show();
                            } catch(FirebaseAuthUserCollisionException e) {
                                Toast.makeText(context, R.string.user_exists_validation, Toast.LENGTH_SHORT).show();
                            } catch(Exception e) {
                                Log.e(TAG, e.getMessage());
                            }
                        }
                    }
                });
    }

}
