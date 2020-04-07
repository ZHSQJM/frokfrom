package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.QrtzJobDetails;
import com.zhs.entity.QuartzEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QrtzJobDetailsMapper extends MyMapper<QrtzJobDetails> {


    @Select("SELECT job.JOB_NAME as jobName,job.JOB_GROUP as jobGroup,job.DESCRIPTION as description,job.JOB_CLASS_NAME as jobClassName,cron.CRON_EXPRESSION as cronExpression,tri.TRIGGER_NAME as triggerName,tri.TRIGGER_STATE as triggerState,\n" +
            "job.JOB_NAME as oldJobName,job.JOB_GROUP as oldJobGroup \n" +
            "\tFROM qrtz_job_details AS job LEFT JOIN qrtz_triggers AS tri ON job.JOB_NAME = tri.JOB_NAME \n" +
            "LEFT JOIN qrtz_cron_triggers AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME\n" +
            "WHERE tri.TRIGGER_TYPE = 'CRON'")
    List<QuartzEntity> listQuartzEntity();



    @Select("SELECT COUNT(*) FROM qrtz_job_details AS job LEFT JOIN qrtz_triggers AS tri ON job.JOB_NAME = tri.JOB_NAME LEFT JOIN qrtz_cron_triggers AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME WHERE tri.TRIGGER_TYPE = 'CRON'\n")
    Long listQuartzEntityCount();
}