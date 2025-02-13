package com.gaotianchi.wtf.listener;

import com.gaotianchi.wtf.task.Task;
import com.gaotianchi.wtf.task.startup.MysqlConnectionCheck;
import com.gaotianchi.wtf.task.startup.RedisConnectionCheck;
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

    private final RedisConnectionCheck redisConnectionCheck;
    private final MysqlConnectionCheck mysqlConnectionCheck;

    public LifecycleListener(RedisConnectionCheck redisConnectionCheck, MysqlConnectionCheck mysqlConnectionCheck) {
        this.redisConnectionCheck = redisConnectionCheck;
        this.mysqlConnectionCheck = mysqlConnectionCheck;
    }


    @Override
    public void start() {
        isRunning = true;
        log.info("Spring boot 开始运行");

        List<Task> taskList = new ArrayList<>();
        taskList.add(redisConnectionCheck);
        taskList.add(mysqlConnectionCheck);

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
