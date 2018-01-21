package inbox.wolf.alex.wolftimemanager.main.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.main.activity.AppSettings;
import inbox.wolf.alex.wolftimemanager.main.activity.CreateProject;

public class MenuCreate {

    public void menuCreator(Menu menu, NavigationView navigationView,
                            DrawerLayout drawerLayout, Context context, int requestCodeCreateProject, TextView titleList) {
        menu.clear();
        menu.add(1, 1, 0, "All project").setChecked(true).setCheckable(true);
        menu.add(2, 2, 2, "Create new project");
        menu.add(2, 3, 2, "Settings");
        menu.add(2, 4, 2, "Sing in");

        setNavigationItemSelectedListener(navigationView, drawerLayout, context, requestCodeCreateProject, titleList);
    }

    private void setNavigationItemSelectedListener(NavigationView navigationView,
                                                   final DrawerLayout drawerLayout, final Context context,
                                                   final int requestCodeCreateProject, final TextView titleList) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case 1:
                        titleList.setText(R.string.all_group_time);
                        break;
                    case 2:
                        ((Activity)context).startActivityForResult(new Intent(context, CreateProject.class), requestCodeCreateProject);
                        break;
                    case 3:
                        context.startActivity(new Intent(context, AppSettings.class));
                        break;
                    case 4:

                        break;
                }
                return true;
            }
        });
    }

    public void defaultClick(Menu menu, TextView titleList) {
        if(menu.getItem(0).isChecked())
            titleList.setText(R.string.all_group_time);
    }
}
