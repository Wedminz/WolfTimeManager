package inbox.wolf.alex.wolftimemanager.main.pojo;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class ProjectGroup implements Serializable {

    public String title;
    public String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectGroup() {
    }

    public ProjectGroup(String title, String id) {
        this.title = title;
        this.id = id;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap <String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("title", title);
        return result;
    }

}
