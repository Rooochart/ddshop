package com.rooochart.service.impl.pratice;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyJob implements Job {
/** 延时任务 方法一
 * 优点，简单宜行
 * 缺点， 对服务器内存消耗大（2）存在延迟*/

    public void execute(JobExecutionContext context) {
        System.out.println("要去数据库扫描啦");
    }

    public static void main(String[] args) throws Exception{
        /*JobKey("job1","group1")   创建任务*/
        JobDetail jobDetail= JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build();
        //创建触发器 每3秒执行一次
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1","group3").
                withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();

        Scheduler scheduler=new StdSchedulerFactory().getScheduler();
        //将任务及触发器放入调度器
        scheduler.scheduleJob(jobDetail,trigger);
        //调度器开始调度任务
        scheduler.start();

    }

}
