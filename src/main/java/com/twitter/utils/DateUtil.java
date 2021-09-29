package com.twitter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {
    private final SimpleDateFormat simpleDateFormat;

    public DateUtil(@Autowired SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public String createTimeStamp() {
        return simpleDateFormat.format(new Date());
    }


}
