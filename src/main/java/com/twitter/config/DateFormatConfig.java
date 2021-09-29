package com.twitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class DateFormatConfig {
    private String TIME_STAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat(TIME_STAMP_PATTERN);
    }
}
