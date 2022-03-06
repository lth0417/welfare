package cn.com.sise.welfare.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lth
 * @Date: 2022/03/05/21:37
 * @Description:
 */
@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {
    @Value("${upload.file.path}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/uploadImage/");
    }
}
