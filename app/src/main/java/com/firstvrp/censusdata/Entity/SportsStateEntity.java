package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 * 承办省级及以上大型综合性运动会情况-丙表子表
 */
public class SportsStateEntity {
//    private int id;
//
//    private String place_id;
//    /// <summary>
//    /// 所属场地ID
//    /// </summary>

    private String type_code;
    /// <summary>
    /// 类型代号
    /// </summary>

    private String type_name;
    /// <summary>
    /// 类型名称
    /// </summary>


    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
