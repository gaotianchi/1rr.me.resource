package com.gaotianchi.wtf.task;

/**
 * @author gaotianchi
 * @since 2025/2/13 15:17
 **/
public class TaskChain {

    private Task firstTask;

    public void addTask(Task task) {
        if (firstTask == null) {
            firstTask = task;
        } else {
            Task current = firstTask;
            while (current instanceof TaskChain taskChain) {
                if (taskChain.firstTask == null) {
                    taskChain.firstTask = task;
                    break;
                }
                current = taskChain.firstTask;
            }
        }
    }

    public void execute() throws Exception {
        Task current = firstTask;
        while (current != null) {
            current.execute();
            if (current instanceof TaskChain) {
                current = ((TaskChain) current).firstTask;
            } else {
                break;
            }
        }
    }
}
