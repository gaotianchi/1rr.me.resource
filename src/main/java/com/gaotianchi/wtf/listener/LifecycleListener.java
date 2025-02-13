package com.gaotianchi.wtf.listener;

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

    @Override
    public void start() {
        isRunning = true;
        log.info("Spring boot 开始运行");
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
