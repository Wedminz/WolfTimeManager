package inbox.wolf.alex.wolftimemanager.main.pojo;

import java.io.Serializable;

public class AllProject implements Serializable{

    private String time;
    private String projectName;
    private String description;
    private String aLongTime;
    private String key;

    public AllProject(String time, String projectName, String description) {
        this.time = time;
        this.projectName = projectName;
        this.description = description;
    }

    public AllProject() {
    }

    public String getTime() {
        return time;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public String getaLongTime() {
        return aLongTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllProject that = (AllProject) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (aLongTime != null ? !aLongTime.equals(that.aLongTime) : that.aLongTime != null)
            return false;
        return key != null ? key.equals(that.key) : that.key == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (aLongTime != null ? aLongTime.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        return result;
    }
}