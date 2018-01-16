package inbox.wolf.alex.wolftimemanager.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inbox.wolf.alex.wolftimemanager.R;
import inbox.wolf.alex.wolftimemanager.main.pojo.AllProject;

public class AllProjectAdapter extends RecyclerView.Adapter<AllProjectAdapter.AllProjectViewHolder> {

    private List<AllProject> allProjectList = new ArrayList<>();
    private OnProjectClickListener onProjectClickListener;

    public AllProjectAdapter(OnProjectClickListener onProjectClickListener){
        this.onProjectClickListener = onProjectClickListener;
    }

    @Override
    public AllProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new AllProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllProjectViewHolder holder, int position) {
        holder.bind(allProjectList.get(position));
    }

    @Override
    public int getItemCount() {
        return allProjectList.size();
    }

    public void setItem(Collection<AllProject> allProjects){
        allProjectList.addAll(allProjects);
        notifyDataSetChanged();
    }

    public void clearItems(){
        allProjectList.clear();
        notifyDataSetChanged();
    }

    class AllProjectViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.time_text_view)
        TextView time;
        @BindView(R.id.project_text_view)
        TextView project;
        @BindView(R.id.description_text_view)
        TextView description;

        AllProjectViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AllProject allProject = allProjectList.get(getLayoutPosition());
                    onProjectClickListener.onProjectClick(allProject);
                }
            });
        }

        void bind(AllProject allProject){
            time.setText(allProject.getTime());
            project.setText(allProject.getProjectName());
            description.setText(allProject.getDescription());
        }

    }

    public interface OnProjectClickListener {
        void onProjectClick(AllProject allProject);
    }

}
