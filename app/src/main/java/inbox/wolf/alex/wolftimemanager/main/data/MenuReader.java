package inbox.wolf.alex.wolftimemanager.main.data;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import inbox.wolf.alex.wolftimemanager.main.menu.MenuCreate;
import inbox.wolf.alex.wolftimemanager.main.pojo.ProjectGroup;

public class MenuReader{

    private Menu menu;
    private NavigationView navigationView;
    private String menuTitle, userUid, key;
    private MenuCreate menuCreate;
    private DrawerLayout drawerLayout;
    private Context context;
    private int requestCreateGroup;
    private TextView titleList;
    private Button button;

    public MenuReader(Button button, Context context) {
        this.button = button;
        this.context = context;
    }

    public MenuReader(NavigationView navigationView,
                      DrawerLayout drawerLayout, Context context, int requestCreateGroup,
                      String userUid, TextView titleList) {
        this.navigationView = navigationView;
        this.drawerLayout = drawerLayout;
        this.context = context;
        this.requestCreateGroup = requestCreateGroup;
        this.userUid = userUid;
        this.titleList = titleList;
    }

    public void postListener() {
        menu = navigationView.getMenu();
        menuCreate = new MenuCreate();

        FirebaseDatabase.getInstance().getReference()
                .child("user")
                .child(userUid)
                .child("project").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                menu.clear();
                menuCreate.menuCreator(menu, navigationView, drawerLayout, context, requestCreateGroup, titleList);
                for (DataSnapshot u : dataSnapshot.getChildren()){
                    ProjectGroup projectGroup = new ProjectGroup();
                    projectGroup.setTitle(u.getValue(ProjectGroup.class).getTitle());
                    menuTitle = projectGroup.getTitle();

                    menu.add(1, 0, 1, menuTitle).setCheckable(true).
                            setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            menuTitle = menuItem.getTitle().toString();
                            titleList.setText(menuItem.toString());
                            return false;
                        }
                    });
                    key = u.getKey();


                }
                menuCreate.defaultClick(menu, titleList);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void delete() {
        DeleteGroup deleteGroup = new DeleteGroup();
        deleteGroup.delete(key, FirebaseDatabase.getInstance().getReference()
                .child("user")
                .child(userUid)
                .child("project"));
    }

    public void update(String title) {
        ProjectGroup projectGroup = new ProjectGroup(title, key);
        Map<String, Object> value = projectGroup.toMap();
        Map<String, Object> childUpdate = new HashMap<>();
        childUpdate.put(key, value);
        FirebaseDatabase.getInstance().getReference()
                .child("user")
                .child(userUid)
                .child("project")
                .updateChildren(childUpdate);
    }






}
