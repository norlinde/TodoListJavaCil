package entity;

public class Task {
    public int ID;
    public String taskName;
    public String deadline;
    public boolean status;

    public Task(int ID, String taskName, String deadline, boolean status) {
        this.ID = ID;
        this.taskName = taskName;
        this.deadline = deadline;
        this.status = status;
    }

    public Task() {
    }

    public int getID() {
        return ID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatusText() {
        if (status) {
            return "Done";
        }
        return "Active";
    }

    public Boolean getStatus() {
        return status;
    }

}

