package inbox.wolf.alex.wolftimemanager.main.pojo;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class ProjectGroup implements Serializable {

    public String title;
    public ProjectGroup() {
    }

    public ProjectGroup(String title) {
        this.title = title;
    }

    public Map<String, Object> toMap() {
        HashMap <String, Object> result = new HashMap<>();
        result.put("title", title);
        return result;
    }

}
