package com.dev.mendes.android_mytasks.dataBase;

/**
 * Created by tainaviriato on 21/06/17.
 */

public class Task {

    private  String taskName;
    private  String id;
    private  String taskPlace;
    private  String taskDate;
    private  String taskNote;
    private boolean isChecked;

    public Task(String id, String taskName, String taskPlace, String taskDate, String taskNote, boolean isChecked) {
        this.id = id;
        this.taskName = taskName;
        this.taskPlace = taskPlace;
        this.taskDate = taskDate;
        this.taskNote = taskNote;
        this.isChecked = isChecked;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getId() {
        return id;
    }

    public String getTaskPlace() {
        return taskPlace;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTaskPlace(String taskPlace) {
        this.taskPlace = taskPlace;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}
