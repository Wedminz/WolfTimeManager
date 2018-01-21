package inbox.wolf.alex.wolftimemanager.main.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import inbox.wolf.alex.wolftimemanager.main.pojo.ProjectGroup;

public class CreateGroupWriter {

    private DatabaseReference databaseReference;

    public void writePojoProject(final String userId,final String value) {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        String key = databaseReference.push().getKey();
        ProjectGroup projectGroup = new ProjectGroup(value, key);
        databaseReference.child("user")
                .child(userId)
                .child("project")
                .child(key)
                .setValue(projectGroup);
    }

}
