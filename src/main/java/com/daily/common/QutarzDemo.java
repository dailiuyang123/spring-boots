package com.daily.common;


import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by json on 2018/5/16.
 * Describe:
 */
@Component
@EnableScheduling  //启用定时任务
public class QutarzDemo {

    public final static long SECOND = 1 * 1000;
    FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");


    @Scheduled(cron = "0/4 * * * * ?")
    public void cronJob() {
        System.out.println("[CronJob Execute]"+fdf.format(new Date()));
    }


}
