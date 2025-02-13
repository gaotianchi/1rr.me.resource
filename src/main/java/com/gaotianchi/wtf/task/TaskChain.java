package com.gaotianchi.wtf.task;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaotianchi
 * @since 2025/2/13 15:17
 **/
public class TaskChain {

    private final List<Task> tasks;

    public TaskChain() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void execute() throws Exception {
        for (Task task : tasks) {
            task.execute();
        }
    }
}
