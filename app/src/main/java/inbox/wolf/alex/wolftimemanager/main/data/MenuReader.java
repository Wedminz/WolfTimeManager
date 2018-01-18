package inbox.wolf.alex.wolftimemanager.main.data;

import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuReader {

    private NavigationView navigationView;
    private String userId;
    private String menuTitle;
    private Menu menu;

    public MenuReader(NavigationView navigationView, String userId) {
        this.navigationView = navigationView;
        this.userId = userId;
    }

    public void postListener() {
        menu = navigationView.getMenu();
        FirebaseDatabase.getInstance().getReference()
                .child("user")
                .child(userId)
                .child("project")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                menu.clear();
                menu.add(1, 0, 0, "All project").setChecked(true).setCheckable(true);
                for (DataSnapshot u : dataSnapshot.getChildren()){
                    menuTitle = u.getKey();
                    menu.add(1, 0, 1, menuTitle).setCheckable(true).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            menuTitle = menuItem.getTitle().toString();
                            return false;
                        }
                    });
                }
                menu.add(2, 0, 2, "Create new project");
                menu.add(2, 0, 2, "Settings");
                menu.add(2, 0, 2, "Sing in");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void menuCreator() {
        menu.add(1, 0, 1, "All project");
        menu.add(2, 0, 0, "Create new project");
        menu.add(2, 0, 0, "Settings");
        menu.add(2, 0, 0, "Sing in");
    }
}
