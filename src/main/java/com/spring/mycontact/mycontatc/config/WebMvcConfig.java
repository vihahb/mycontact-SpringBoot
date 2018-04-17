package com.spring.mycontact.mycontatc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //
        // Access Bootstrap static resource:
        //
        // http://somedomain/SomeContextPath/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css
        //
        registry.addResourceHandler("/resources/bootstrap/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/");
        registry.addResourceHandler("/resources/font-awesome/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/font-awesome/5.0.10/");
        registry.addResourceHandler("/resources/jquery/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/1.12.4/");
        registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
    }
}
