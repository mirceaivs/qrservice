package qrcodeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import qrcodeapi.model.Image;

import java.awt.image.BufferedImage;

@Configuration
public class ImageConfig {

    @Bean
    public HttpMessageConverter<BufferedImage> imageHttpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }


}
