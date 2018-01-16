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
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.main.activity.ProjectList;

public class EmailSingIn {

    private Context context;
    private final String TAG = "AppDevLog";

    public EmailSingIn(Context context) {
        this.context = context;
    }

    public void signInWithEmailAndPassword(String email, String password) {
        final ProgressDialog dialog = ProgressDialog.show(context, "Title",
                "Text", true);
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(((Activity)context), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if(task.isSuccessful()) {
                            context.startActivity(new Intent(context, ProjectList.class));
                            ((Activity)context).finish();
                        }else {
                            try{
                                throw task.getException();
                            } catch (FirebaseAuthEmailException | FirebaseAuthInvalidCredentialsException e){
                                Toast.makeText(context, R.string.validate_login_form, Toast.LENGTH_SHORT).show();
                            } catch (FirebaseAuthInvalidUserException e){
                                Toast.makeText(context, R.string.validate_login_form_no_exist_user, Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Log.d(TAG, e.getMessage() + " " + e.getClass() );
                            }
                        }
                    }
                });
    }

    public void sendPasswordResetEmail(String email) {
        final ProgressDialog dialog = ProgressDialog.show(context, "Title",
                "Text", true);
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                dialog.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(context, R.string.text_reset_password, Toast.LENGTH_SHORT).show();
                    ((Activity)context).finish();
                } else {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthEmailException | FirebaseAuthInvalidCredentialsException e){
                        Toast.makeText(context, R.string.wrong_email_format_reset_password, Toast.LENGTH_SHORT).show();
                    } catch (FirebaseAuthInvalidUserException e) {
                        Toast.makeText(context, R.string.validate_login_form_no_exist_user, Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.d(TAG, e.getMessage() + " " + e.getClass() );
                    }
                }
            }
        });
    }

}
