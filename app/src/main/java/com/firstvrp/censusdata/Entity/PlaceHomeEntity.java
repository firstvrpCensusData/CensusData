package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 */
public class PlaceHomeEntity {
//    private int id;
//
//    private String place_id;
//    /// <summary>
//    /// 所属场地ID
//    /// </summary>

    private String index_name;
    /// <summary>
    /// 指标名称
    /// </summary>

    private String index_code;
    /// <summary>
    /// 指标代码
    /// </summary>


    public String getIndex_name() {
        return index_name;
    }

    public void setIndex_name(String index_name) {
        this.index_name = index_name;
    }

    public String getIndex_code() {
        return index_code;
    }

    public void setIndex_code(String index_code) {
        this.index_code = index_code;
    }

    @Override
    public String toString() {
        return "PlaceHomeEntity{" +
                ", index_name='" + index_name + '\'' +
                ", index_code='" + index_code + '\'' +
                '}';
    }
}
