package inbox.wolf.alex.wolftimemanager.main.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import inbox.wolf.alex.wolftimemanager.main.activity.SingIn;

public class EmailAuth {

    private FirebaseAuth auth;
    private Context context;

    public EmailAuth(Context context) {
        this.context = context;
    }

    private void getUser(){
        auth = FirebaseAuth.getInstance();
    }

    public void getCurrUser(){
        getUser();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null) {
            context.startActivity(new Intent(context, SingIn.class));
            ((Activity)context).finish();
        }
    }

    public void singOut(){
        auth.signOut();
        getCurrUser();
    }

}
