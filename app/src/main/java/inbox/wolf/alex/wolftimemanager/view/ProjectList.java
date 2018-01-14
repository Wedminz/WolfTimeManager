package inbox.wolf.alex.wolftimemanager.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.view.adapter.AllProjectAdapter;
import inbox.wolf.alex.wolftimemanager.view.pojo.AllProject;

public class ProjectList extends AppCompatActivity {

    public static final int LAYOUT = R.layout.activity_project_list;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.rl_time_manager)
    RelativeLayout rlTimeManager;
    @BindView(R.id.all_project_list)
    RecyclerView allProjectList;
    AllProjectAdapter projectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

        barDrawerToggle();
        navigationItemSelected();
        initRecycler();
        loadProject();
    }


    private void initRecycler(){
        final Intent intent = new Intent(this, EditTimer.class);
        AllProjectAdapter.OnProjectClickListener onProjectClickListener = new AllProjectAdapter.OnProjectClickListener() {
            @Override
            public void onProjectClick(AllProject allProject) {
                intent.putExtra("description", allProject.getDescription());
                intent.putExtra("time", allProject.getTime());
                startActivity(intent);
            }
        };

        projectAdapter = new AllProjectAdapter(onProjectClickListener);
        allProjectList.setLayoutManager(new LinearLayoutManager(this));
        allProjectList.setAdapter(projectAdapter);
    }

    private void loadProject(){
        Collection<AllProject> allProjects = getProject();
        projectAdapter.setItem(allProjects);
    }

    private Collection<AllProject> getProject(){
        return Arrays.asList(
                new AllProject("11:00:00", "My First project", "title and title"),
                new AllProject("00:11:00", "My new project", "title and title"),
                new AllProject("11:00:00", "My First project", "title and title"),
                new AllProject("11:00:00", "My First project", "title and title"),
                new AllProject("11:00:00", "My First project", "title and title")
        );
    }

    private void navigationItemSelected() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.all_project_list:
                        ProjectList.super.onOptionsItemSelected(item);
                        break;
                    case R.id.create_new_project:
                        startActivity(new Intent(ProjectList.this, CreateProject.class));
                        break;
                    case R.id.settings_profile:
                        startActivity(new Intent(ProjectList.this, AppSettings.class));
                        break;
                    case R.id.sing_in_app:
                        startActivity(new Intent(ProjectList.this, SingUp.class));
                        break;
                }
                return true;
            }
        });
    }

    private void barDrawerToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open
                , R.string.view_navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @OnClick(R.id.create_timer_btn)
    void onCreateTimer(){
        startActivity(new Intent(ProjectList.this, CreateTimer.class));
    }

    @OnClick(R.id.project_setting_btn)
    void onProjectSetting(){
        startActivity(new Intent(ProjectList.this, EditProject.class));
    }

    public void setTimeCounter(final String time, final long longTime){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
}
