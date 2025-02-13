package com.gaotianchi.wtf.task;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gaotianchi
 * @since 2025/2/13 15:18
 **/
@Slf4j
public class TaskManager {

    private final TaskChain taskChain;

    public TaskManager() {
        this.taskChain = new TaskChain();
    }

    public void addTask(Task task) {
        taskChain.addTask(task);
    }

    public void runTasks() {
        try {
            taskChain.execute();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
}
