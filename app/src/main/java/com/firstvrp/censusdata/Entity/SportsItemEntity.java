package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 * 场地专项指标-开展的体育项目-乙表子表
 */
public class SportsItemEntity {
    private int _id;

    private String _place_id;
    /// <summary>
    /// 所属场地ID
    /// </summary>

    private String _item_code;
    /// <summary>
    /// 项目代号
    /// </summary>

    private String _item_name;
    /// <summary>
    /// 项目名称
    /// </summary>


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_place_id() {
        return _place_id;
    }

    public void set_place_id(String _place_id) {
        this._place_id = _place_id;
    }

    public String get_item_code() {
        return _item_code;
    }

    public void set_item_code(String _item_code) {
        this._item_code = _item_code;
    }

    public String get_item_name() {
        return _item_name;
    }

    public void set_item_name(String _item_name) {
        this._item_name = _item_name;
    }
}
