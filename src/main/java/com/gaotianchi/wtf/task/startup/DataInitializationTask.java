package com.gaotianchi.wtf.task.startup;

import com.gaotianchi.wtf.config.DbInitialConfig;
import com.gaotianchi.wtf.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author gaotianchi
 * @since 2025/2/13 21:09
 **/
@Component
@Slf4j
public class DataInitializationTask implements Task {

    private final DataSource dataSource;
    private final DbInitialConfig dbInitialConfig;

    public DataInitializationTask(
            DataSource dataSource,
            DbInitialConfig dbInitialConfig
    ) {
        this.dataSource = dataSource;
        this.dbInitialConfig = dbInitialConfig;
    }

    @Override
    public void execute() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            if (dbInitialConfig
                    .getReset()
                    .getEnable()) {
                log.info("正在重置数据库 ...");
                ScriptUtils.executeSqlScript(connection, dbInitialConfig
                        .getReset()
                        .getPath());
                log.info("重置数据库完成");
            }

            if (dbInitialConfig
                    .getMock()
                    .getEnable()) {
                log.info("正在加载数据库模拟数据 ...");
                ScriptUtils.executeSqlScript(connection, dbInitialConfig
                        .getMock()
                        .getPath());
                log.info("加载数据库模拟数据完成");
            }
        }
    }
}
