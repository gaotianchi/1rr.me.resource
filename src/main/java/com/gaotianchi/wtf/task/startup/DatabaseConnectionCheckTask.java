package com.gaotianchi.wtf.task.startup;

import com.gaotianchi.wtf.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.concurrent.CompletableFuture;

/**
 * @author gaotianchi
 * @since 2025/2/13 19:26
 **/
@Component
@Slf4j
public class DatabaseConnectionCheckTask implements Task {

    private final DataSource dataSource;
    private final RedisConnectionFactory redisConnectionFactory;

    public DatabaseConnectionCheckTask(
            DataSource dataSource,
            RedisConnectionFactory redisConnectionFactory
    ) {
        this.dataSource = dataSource;
        this.redisConnectionFactory = redisConnectionFactory;
    }

    // - 检查 MYSQL 连接
    public String checkMysqlConnection() {
        log.info("正在检查 Mysql 数据库连接 ...");
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1000)) {
                log.info("Mysql 数据库连接正常");
                return null;
            } else {
                return "Mysql 数据库连接异常";
            }
        } catch (Exception e) {
            log.error("Mysql 数据库连接检查失败", e);
            return "Mysql 数据库连接异常: " + e.getMessage();
        }
    }

    // - 检查 REDIS 连接
    public String checkRedisConnection() {
        log.info("正在检查 Redis 数据库连接 ...");
        try (RedisConnection connection = redisConnectionFactory.getConnection()) {
            // 使用 ping 命令测试连接
            String pong = connection.ping();
            if ("PONG".equals(pong)) {
                log.info("Redis 数据库连接正常");
                return null;
            } else {
                return "Redis 连接异常: 未收到 PONG 响应";
            }
        } catch (Exception e) {
            log.error("Redis 连接检查失败", e);
            return "Redis 连接异常: " + e.getMessage();
        }
    }

    @Override
    public void execute() throws Exception {
        // 使用 CompletableFuture 进行异步执行，保证每个数据库连接测试是独立的
        CompletableFuture<String> mysqlCheckFuture = CompletableFuture.supplyAsync(this::checkMysqlConnection);
        CompletableFuture<String> redisCheckFuture = CompletableFuture.supplyAsync(this::checkRedisConnection);

        // 等待所有数据库连接检查完成
        CompletableFuture
                .allOf(mysqlCheckFuture, redisCheckFuture)
                .join();

        // 打印出每个测试的结果
        String mysqlResult = mysqlCheckFuture.get();
        if (mysqlResult != null) {
            log.error(mysqlResult);
        }

        String redisResult = redisCheckFuture.get();
        if (redisResult != null) {
            log.error(redisResult);
        }
    }
}
