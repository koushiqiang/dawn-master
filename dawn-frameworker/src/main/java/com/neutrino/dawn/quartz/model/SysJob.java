package com.neutrino.dawn.quartz.model;


import cn.hutool.core.util.StrUtil;
import com.dawn.common.annotation.Excel;
import com.dawn.common.constants.ScheduleConstants;
import com.neutrino.dawn.model.BaseEntity;
import com.neutrino.dawn.quartz.utils.CronUtils;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: com.neutrino.dawn.model Description:定时任务调度表 sys_job
 * Date:  2020/5/21 15:19 Author: kousq
 * Modified By:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysJob extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Excel(name = "任务序号")
    private Long jobId;

    @Excel(name = "任务名称")
    private String jobName;

    @Excel(name = "任务组名")
    private String jobGroup;

    @Excel(name = "任务方法")
    private String methodName;

    @Excel(name = "方法参数")
    private String methodParams;

    @Excel(name = "执行表达式 ")
    private String cronExpression;

    @Excel(name = "计划策略 ")
    private String misfirePolicy = ScheduleConstants.MISFIRE_DEFAULT;

    @Excel(name = "是否并发执行" , readConverterExp = "0=允许,1=禁止")
    private String concurrent;

    @Excel(name = "任务状态" , readConverterExp = "0=正常,1=暂停")
    private String status;

    /**
     * 下次执行时间
     * @return 下次执行时间
     */
    public Date getNextValidTime(){
        if (StrUtil.isNotEmpty(cronExpression)){
            return CronUtils.getNextExecution(cronExpression);
        }
        return null;
    }
}
