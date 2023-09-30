package com.chefencasa.Infraestructure.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class PopularityUserJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("PopularityUserJob ejecuted - " + new Date());
    }
}
