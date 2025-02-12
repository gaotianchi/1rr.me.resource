package com.gaotianchi.wtf.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaotianchi
 * @since 2025/2/12 10:54
 **/
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("短链接服务(wtf) API 文档")
                        .description("wtf 提供便捷的短链接生成服务，告别冗长，让您的关键链接焕然一新！")
                        .version("1.0.0")
                );
    }
}
