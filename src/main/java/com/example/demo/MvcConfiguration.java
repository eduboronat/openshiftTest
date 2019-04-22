package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfiguration extends WebMvcConfigurerAdapter
{
	@Value("${spring.view.prefix}")
    private String prefix;

    @Value("${spring.view.suffix}")
    private String suffix;

    @Value("${spring.view.view-names}")
    private String viewNames;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                
                "/img/**","/css/**","/fonts/**","/images/**","/js/**")
                .addResourceLocations(
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/fonts/",
                        "classpath:/static/images/",
                        "classpath:/static/js/");
    }
	@Bean
    InternalResourceViewResolver jspViewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(prefix);
        viewResolver.setSuffix(suffix);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setViewNames(viewNames);
        return viewResolver;
    }
	
	
}


