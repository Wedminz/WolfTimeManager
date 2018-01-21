package inbox.wolf.alex.wolftimemanager.main.data;

import com.google.firebase.database.DatabaseReference;

public class DeleteGroup {

    public void delete(final String k, final DatabaseReference databaseReference) {
        databaseReference.child(k).removeValue();
    }

}
