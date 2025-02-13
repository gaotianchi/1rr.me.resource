package com.gaotianchi.wtf.listener;

import com.gaotianchi.wtf.task.TaskManager;
import com.gaotianchi.wtf.task.startup.MysqlConnectionCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author gaotianchi
 * @since 2025/2/13 15:36
 **/
@Component
@Slf4j
public class LifecycleListener implements SmartLifecycle {

    private boolean isRunning = false;
    private final TaskManager taskManager = new TaskManager();

    private final MysqlConnectionCheck mysqlConnectionCheck;
    public LifecycleListener(MysqlConnectionCheck mysqlConnectionCheck) {
        this.mysqlConnectionCheck = mysqlConnectionCheck;
    }


    @Override
    public void start() {
        isRunning = true;
        log.info("Spring boot 开始运行");

        taskManager.addTask(mysqlConnectionCheck);

        taskManager.runTasks();
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
