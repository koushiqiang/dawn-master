package com.neutrino.dawn.controller;

import com.dawn.common.basemodel.AjaxResult;
import com.neutrino.dawn.quartz.model.SysJob;
import com.neutrino.dawn.quartz.service.ISysJobService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package: com.neutrino.dawn.controller Description: 调度任务信息操作处理
 * Date:  2020/5/21 16:07 Author: kousq Modified
 * By:
 */
@Controller
@RequestMapping("/monitor/job")
@Slf4j
public class SystemJobController extends BaseController{

    private String prefix = "monitor/job";

    private final ISysJobService jobService;

    @Autowired
    public SystemJobController(ISysJobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public String job() {
        return prefix + "/job";
    }

    @PostMapping("/list")
    @ResponseBody
    public List<SysJob> list(SysJob job) {
        List<SysJob> list = jobService.selectJobList(job);
        return list;
    }

    /**
     * 新增调度
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存调度
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysJob job) throws SchedulerException{

        return toAjax(jobService.insertJobCron(job));
    }

    /**
     * 新增调度
     */
    @GetMapping("/edit")
    public String edit() {
        return prefix + "/edit";
    }


    /**
     * 任务调度立即执行一次
     */
    @PostMapping("/run")
    @ResponseBody
    public AjaxResult run(SysJob job) throws SchedulerException {
        jobService.run(job);
        return AjaxResult.success();
    }

    /**
     * 校验cron表达式是否有效
     */
    @PostMapping("/checkCronExpressionIsValid")
    @ResponseBody
    public boolean checkCronExpressionIsValid(SysJob job) {
        return jobService.checkCronExpressionIsValid(job.getCronExpression());
    }


}
