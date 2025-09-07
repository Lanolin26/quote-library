package ru.lanolin.quote.config;

import jakarta.servlet.ServletConfig;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import ru.lanolin.quote.velocity.SpringVelocityViewResolver;

@Configuration
public class WebMvcConfig extends DelegatingWebMvcConfiguration {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
    }

    @Bean
    public VelocityEngine velocityEngine() {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("resource.default_encoding", "UTF-8");
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
        velocityEngine.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
        velocityEngine.setProperty("resource.loader.classpath.cache", false);
        velocityEngine.setProperty("resource.loader.classpath.modification_check_interval", 2);
        velocityEngine.setProperty("velocimacro.library.autoreload", true);

//        velocityEngine.setProperty("resource.loader.file.class", FileResourceLoader.class.getName());
//        velocityEngine.setProperty("resource.loader.jar.class", JarResourceLoader.class.getName());
//        velocityEngine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "/templates/");
        return velocityEngine;
    }

    @Bean
    public ViewResolver viewResolver(VelocityEngine velocityEngine) {
        SpringVelocityViewResolver resolver = new SpringVelocityViewResolver(velocityEngine);
        resolver.setPrefix("/templates/page/");
        resolver.setSuffix(".vm");
        return resolver;
    }
}
