package com.armelift.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.armelift.app.service.CommentService;
import com.armelift.app.service.CommentServiceImpl;

@Configuration
public class BeanConfig {

    @Bean
    public CommentService commentService() {
        return new CommentServiceImpl();
    }
}
