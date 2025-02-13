package com.gaotianchi.wtf.listener;

import com.gaotianchi.wtf.task.Task;
import com.gaotianchi.wtf.task.startup.DatabaseConnectionCheckTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaotianchi
 * @since 2025/2/13 15:36
 **/
@Component
@Slf4j
public class LifecycleListener implements SmartLifecycle {

    private boolean isRunning = false;

    private final DatabaseConnectionCheckTask databaseConnectionCheckTask;

    public LifecycleListener(DatabaseConnectionCheckTask databaseConnectionCheckTask) {
        this.databaseConnectionCheckTask = databaseConnectionCheckTask;
    }

    @Override
    public void start() {
        isRunning = true;
        log.info("Spring boot 开始运行");

        List<Task> taskList = new ArrayList<>();
        taskList.add(databaseConnectionCheckTask);


        for (Task task : taskList) {
            if (task != null) {
                try {
                    task.execute();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void stop() {
        log.info("Spring boot 停止运行");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
