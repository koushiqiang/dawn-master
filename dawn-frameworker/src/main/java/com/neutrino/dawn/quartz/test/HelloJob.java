package com.neutrino.dawn.quartz.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Package: com.neutrino.dawn.quartz.test Description: 这个类是编写我们的具体要实现任务
 * Date:  2020/5/21 16:42 Author: kousq Modified
 * By:
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //打印当前的执行时间 例如 2017-11-23 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("现在的时间是："+ sf.format(date));

        //具体的业务逻辑
//        System.out.println("Hello Quartz");

    }
}