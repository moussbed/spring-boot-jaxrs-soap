package com.mb.springbootjaxrssoap.config;

import com.mb.springbootjaxrssoap.connectors.rs.AccountRS;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxRsConfiguration {

    @Bean
    ResourceConfig resourceConfig() {

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(AccountRS.class);
        return resourceConfig;

    }
}
