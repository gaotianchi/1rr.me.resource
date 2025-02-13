package com.gaotianchi.wtf.task.startup;

import com.gaotianchi.wtf.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * @author gaotianchi
 * @since 2025/2/13
 **/
@Component
@Slf4j
public class RedisConnectionCheck implements Task {

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisConnectionCheck(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Override
    public void execute() throws Exception {
        log.info("正在检查 Redis 连接 ...");
        try (RedisConnection connection = redisConnectionFactory.getConnection()) {
            // 使用 ping 命令测试连接
            String pong = connection.ping();
            if ("PONG".equals(pong)) {
                log.info("Redis 连接正常");
            } else {
                throw new Exception("Redis 连接异常: 未收到 PONG 响应");
            }
        } catch (Exception e) {
            log.error("Redis 连接异常", e);
            throw new Exception("Redis 连接异常: " + e.getMessage());
        }
    }
}