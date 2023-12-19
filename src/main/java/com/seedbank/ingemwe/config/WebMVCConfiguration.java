package com.seedbank.ingemwe.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry)  {
        registry.addViewController("/access-denied").setViewName("access-denied");
        registry.addViewController("/homepage").setViewName("homepage");
//        registry.addViewController("/home").setViewName("homepage");
        registry.addViewController("/about-us").setViewName("about-us");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/service").setViewName("service");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/product").setViewName("product");

    }
}
