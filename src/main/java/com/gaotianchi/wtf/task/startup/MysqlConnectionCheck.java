package com.gaotianchi.wtf.task.startup;

import com.gaotianchi.wtf.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;


/**
 * @author gaotianchi
 * @since 2025/2/13 14:53
 **/
@Component
@Slf4j
public class MysqlConnectionCheck implements Task {

    private final DataSource dataSource;

    public MysqlConnectionCheck(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void execute() throws Exception {
        log.info("正在检查 Mysql 数据库连接 ...");
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1000)) {
                log.info("Mysql 数据库连接正常");
            } else {
                throw new Exception("Mysql 数据库连接异常");
            }
        }
    }
}
