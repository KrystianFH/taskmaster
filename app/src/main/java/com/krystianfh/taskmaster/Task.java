package com.krystianfh.taskmaster;

public class Task {

    public String taskTitle;
    public String taskDetails;
    public String taskState;

    public Task (String taskTitle, String taskDetails, String taskState){
        this.taskTitle = taskTitle;
        this.taskDetails = taskDetails;
        this.taskState = taskState; // state should be one of "new", "assigned", "in progress", or "complete"
    }
}
