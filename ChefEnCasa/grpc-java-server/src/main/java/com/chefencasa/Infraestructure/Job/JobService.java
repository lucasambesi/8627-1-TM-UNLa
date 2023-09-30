package com.chefencasa.Infraestructure.Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobService<T extends Job> implements Runnable {
    private static Scheduler scheduler;
    private static boolean jobScheduled = false;
    private Class<T> jobClass;
    private String jobName;
    private String jobGroup;
    private String triggerName;
    private String triggerGroup;
    private  String schedulerName;
    private int seconds;

    public JobService(Class<T> jobClass, String jobName, String jobGroup, String triggerName, String triggerGroup, int seconds, String schedulerName) {
        this.jobClass = jobClass;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.seconds = seconds;
        this.schedulerName = schedulerName;
    }

    @Override
    public void run() {
        if (!jobScheduled) {
            startJob();
            jobScheduled = true;
        }
    }

    public void startJob() {
        try {
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroup)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, triggerGroup)
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(seconds)
                            .repeatForever())
                    .build();
            
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void stopJob() {
        try {
            if (scheduler != null) {
                scheduler.shutdown();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}