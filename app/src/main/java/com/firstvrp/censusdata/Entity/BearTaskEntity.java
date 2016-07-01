package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 * 在赛事中承担的任务-丙表子表
 */
public class BearTaskEntity {

    /// 任务代号
    private String task_code;

    /// 任务名称
    private String task_name;


    public String getTask_code() {
        return task_code;
    }

    public void setTask_code(String task_code) {
        this.task_code = task_code;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
}
