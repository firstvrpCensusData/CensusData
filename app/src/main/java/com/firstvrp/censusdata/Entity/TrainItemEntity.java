package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 *  培训项目-丙表子表
 */
public class TrainItemEntity {


    private String item_code;
    /// <summary>
    /// 项目代号
    /// </summary>

    private String item_name;
    /// <summary>
    /// 项目名称
    /// </summary>


    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
