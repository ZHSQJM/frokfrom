//package com.zhs.quartz;
//
//import org.quartz.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * @project: formwork
// * @author: zhs
// * @date: 2020/3/16 11:03
// * @package: com.zhs.quartz
// * @description:
// */
//@DisallowConcurrentExecution
//public class ChickenJob implements Job,Serializable {
//
//    private static final Logger logger = LoggerFactory.getLogger(ChickenJob.class);
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println("大吉大利、今晚吃鸡-01-测试集群模式");
//
//        System.out.println("Hello!  NewJob is executing."+new Date() );
//        //取得job详情
//        JobDetail jobDetail = context.getJobDetail();
//        // 取得job名称
//        String jobName = jobDetail.getClass().getName();
//        logger.info("Name: " + jobDetail.getClass().getSimpleName());
//        //取得job的类
//        logger.info("Job Class: " + jobDetail.getJobClass());
//        //取得job开始时间
//        logger.info(jobName + " fired at " + context.getFireTime());
//        //取得job下次触发时间
//        logger.info("Next fire time " + context.getNextFireTime());
//
//        JobDataMap dataMap =  jobDetail.getJobDataMap();
//
//        logger.info("itstyle: " + dataMap.getString("itstyle"));
//        logger.info("blog: " + dataMap.getString("blog"));
////        String[] array = (String[]) dataMap.get("data");
////        for(String str:array){
////            logger.info("data: " + str);
////        }
//        //测试效果 保证上一个任务执行完后，再去执行下一个任务
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
