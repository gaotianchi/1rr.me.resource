package com.gaotianchi.wtf.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * @author gaotianchi
 * @since 2025/2/14 8:57
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "sql")
public class DbInitialConfig {

    private Reset reset;
    private Mock mock;

    @Data
    public static class Reset {
        private Boolean enable;
        private Resource path;
    }

    @Data
    public static class Mock {
        private Boolean enable;
        private Resource path;
    }
}
