package me._1rr.resource.config;

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
    private Init init;

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

    @Data
    public static class Init {
        private Boolean enable;
        private Resource path;
    }
}
