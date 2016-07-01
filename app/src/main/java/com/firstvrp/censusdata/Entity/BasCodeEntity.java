package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 * 邀请码
 */
public class BasCodeEntity {
    private String id;
    /// 邀请码
    private String invite_code;

    /// 邀请人
    private String invite_people;

    /// 使用人
    private String use_people;


    /// 邀请码类型
    /// 1：普查员
    /// 2：区领导
    /// 3：市领导
    private int invite_type;

    /// 是否已使用
    /// 0：未使用
    /// 1：已使用
    private int is_use;


    /// 创建日期
    private String create_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public String getInvite_people() {
        return invite_people;
    }

    public void setInvite_people(String invite_people) {
        this.invite_people = invite_people;
    }

    public String getUse_people() {
        return use_people;
    }

    public void setUse_people(String use_people) {
        this.use_people = use_people;
    }

    public int getInvite_type() {
        return invite_type;
    }

    public void setInvite_type(int invite_type) {
        this.invite_type = invite_type;
    }

    public int getIs_use() {
        return is_use;
    }

    public void setIs_use(int is_use) {
        this.is_use = is_use;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "BasCodeEntity{" +
                "id='" + id + '\'' +
                ", invite_code='" + invite_code + '\'' +
                ", invite_people='" + invite_people + '\'' +
                ", use_people='" + use_people + '\'' +
                ", invite_type=" + invite_type +
                ", is_use=" + is_use +
                ", create_date='" + create_date + '\'' +
                '}';
    }
}
