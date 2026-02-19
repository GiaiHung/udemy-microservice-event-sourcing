package com.eazybytes.customer;

import com.eazybytes.customer.command.interceptor.CustomerCommandInterceptor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.PropagatingErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class CustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }

    @Autowired
    public void registerInterceptor(ApplicationContext context, CommandGateway commandGateway) {
        commandGateway.registerDispatchInterceptor(context.getBean(CustomerCommandInterceptor.class));
    }

    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
        // With this config
        // We are trying to say if one event handling failed in the same processing group
        // Then propagate that error to the command layer too
        configurer.registerListenerInvocationErrorHandler(
                "customer-group",
                config -> PropagatingErrorHandler.instance()
        );
    }
}
