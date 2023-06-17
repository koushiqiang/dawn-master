package com.neutrino.dawn.quartz.service.impl;

import cn.hutool.core.convert.Convert;
import com.dawn.common.constants.ScheduleConstants.Status;
import com.neutrino.dawn.quartz.mapper.SysJobMapper;
import com.neutrino.dawn.quartz.model.SysJob;
import com.neutrino.dawn.quartz.service.ISysJobService;
import com.neutrino.dawn.quartz.utils.CronUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.neutrino.dawn.quartz.service.impl Description:定时任务调度信息 服务层 Date:  2020/5/23 12:53 Author: kousq
 * Modified By:
 */
@Service
public class SysJobServiceImpl implements ISysJobService {


    private final Scheduler scheduler;

    private final SysJobMapper jobMapper;

    @Autowired
    public SysJobServiceImpl(Scheduler scheduler, SysJobMapper jobMapper) {
        this.scheduler = scheduler;
        this.jobMapper = jobMapper;
    }


    /**
     * 项目启动时，初始化定时器，被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
     * PostConstruct在构造函数之后执行，init（）方法之前执行。
     */
    @PostConstruct
    public void init() throws SchedulerException { //}, TaskException {
        List<SysJob> jobList = jobMapper.selectJobAll();
        for (SysJob sysJob : jobList){
//            ScheduleUtils.updateScheduleJob(scheduler, sysJob);
        }
    }

    /**
     * 获取quartz调度器的计划任务列表
     *
     * @param job 调度信息
     * @return 计划任务列表
     */
    @Override
    public List<SysJob> selectJobList(SysJob job) {
        return jobMapper.selectJobList(job);
    }

    /**
     * 通过调度任务ID查询调度信息
     *
     * @param jobId 调度任务ID
     * @return 调度任务对象信息
     */
    @Override
    public SysJob selectJobById(Long jobId) {
        return jobMapper.selectJobById(jobId);
    }

    /**
     * 暂停任务
     *
     * @param job 调度信息
     */
    @Override
    public int pauseJob(SysJob job) throws SchedulerException{
        job.setStatus(Status.PAUSE.getValue());
        int rows = jobMapper.updateJob(job);
        if (rows > 0) {
//            ScheduleUtils.pauseJob(scheduler, job.getJobId());
        }
        return rows;
    }

    /**
     * 恢复任务
     *
     * @param job 调度信息
     */
    @Override
    public int resumeJob(SysJob job) throws SchedulerException{
        job.setStatus(Status.NORMAL.getValue());
        int rows = jobMapper.updateJob(job);
        if (rows > 0) {
//            ScheduleUtils.resumeJob(scheduler, job.getJobId());
        }
        return rows;
    }

    /**
     * 删除任务后，所对应的trigger也将被删除
     *
     * @param job 调度信息
     */
    @Override
    public int deleteJob(SysJob job) throws SchedulerException{
        int rows = jobMapper.deleteJobById(job.getJobId());
        if (rows > 0) {
//            ScheduleUtils.deleteScheduleJob(scheduler, job.getJobId());
        }
        return rows;
    }

    /**
     * 批量删除调度信息
     *
     * @param ids 需要删除的数据ID
     */
    @Override
    public void deleteJobByIds(String ids) throws SchedulerException{
        Long[] jobIds = Convert.toLongArray(ids);
        for (Long jobId : jobIds) {
            SysJob job = jobMapper.selectJobById(jobId);
            deleteJob(job);
        }
    }

    /**
     * 任务调度状态修改
     *
     * @param job 调度信息
     */
    @Override
    public int changeStatus(SysJob job) throws SchedulerException{
        int rows = 0;
        String status = job.getStatus();
        if (Status.NORMAL.getValue().equals(status)) {
            rows = resumeJob(job);
        } else if (Status.PAUSE.getValue().equals(status)) {
            rows = pauseJob(job);
        }
        return rows;
    }

    /**
     * 立即运行任务
     *
     * @param job 调度信息
     */
    @Override
    public void run(SysJob job) throws SchedulerException{
//        ScheduleUtils.run(scheduler, selectJobById(job.getJobId()));
    }

    /**
     * 新增任务
     *
     * @param job 调度信息 调度信息
     */
    @Override
    public int insertJobCron(SysJob job) throws SchedulerException { //, TaskException{
        job.setStatus(Status.PAUSE.getValue());
        int rows = jobMapper.insertJob(job);
        if (rows > 0) {
//            createScheduleJob(scheduler, job);
        }
        return rows;
    }

    /**
     * 更新任务的时间表达式
     *
     * @param job 调度信息
     */
    @Override
    public int updateJobCron(SysJob job) throws SchedulerException { //, TaskException{
        int rows = jobMapper.updateJob(job);
        if (rows > 0) {
//            updateScheduleJob(scheduler, job);
        }
        return rows;
    }

    /**
     * 校验cron表达式是否有效
     *
     * @param cronExpression 表达式
     * @return 结果
     */
    @Override
    public boolean checkCronExpressionIsValid(String cronExpression) {
        return CronUtils.isValid(cronExpression);
    }
}
