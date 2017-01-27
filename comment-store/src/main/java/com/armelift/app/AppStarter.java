package com.armelift.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages= {"com.armelift.app"})
@EnableTransactionManagement
public class AppStarter {
	
    public static void main( String[] args ) throws Exception{
    	SpringApplication.run(AppStarter.class, args);
    }
    
}
