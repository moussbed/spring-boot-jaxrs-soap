package com.mb.springbootjaxrssoap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class SoapConfiguration {

    @Bean
    SimpleJaxWsServiceExporter exporter(){

        SimpleJaxWsServiceExporter jaxWsServiceExporter = new SimpleJaxWsServiceExporter();
        jaxWsServiceExporter.setBaseAddress("http://0.0.0.0:8090/");

        return jaxWsServiceExporter;

    }
}
