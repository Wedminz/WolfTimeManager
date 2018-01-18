package inbox.wolf.alex.wolftimemanager.main.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateGroupWriter {

    private DatabaseReference databaseReference;

    public void writeProject(final String userId,final String value) {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        String id = databaseReference.push().getKey();
        databaseReference.child("user")
                .child(userId)
                .child("project")
                .child(value)
                .setValue(id);
    }

}
