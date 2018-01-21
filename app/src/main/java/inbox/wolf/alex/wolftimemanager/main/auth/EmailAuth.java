package inbox.wolf.alex.wolftimemanager.main.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import inbox.wolf.alex.wolftimemanager.main.activity.SingIn;

public class EmailAuth {

    private FirebaseAuth auth;
    FirebaseUser user;
    private Context context;

    public EmailAuth(Context context) {
        this.context = context;
    }

    private void getUser(){
        auth = FirebaseAuth.getInstance();
    }

    private void getCurrUser() {
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public void getSingInUser(){
        getUser();
        getCurrUser();
        if(user == null) {
            context.startActivity(new Intent(context, SingIn.class));
            Log.d("myLog", "null!");
            ((Activity)context).finish();
        }
    }

    public String getUserUid() {
        getCurrUser();
        if(user == null)
            return "";
        else
            return user.getUid();
    }

    public void singOut(){
        auth.signOut();
        getCurrUser();
    }

}
