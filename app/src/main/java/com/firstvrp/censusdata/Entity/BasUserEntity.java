package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 */
public class BasUserEntity {
//    id=""
//            user_account="123"
//    mobile="13301017475"
//            user_name="三二一"
//    password="123"
//            user_type=1
//    create_date="2016-1-1"
//            is_use=1
//    isdelete=0
    public String id;
    /// 用户账号
    private String user_account;

    /// 手机号
    private String mobile;

    /// 用户名称
    private String user_name;

    /// 登录密码
    private String password;

    /// 用户类型
    /// 1：普查员
    /// 2：区领导
    /// 3：市领导
    private int user_type;
    /// 创建日期
    private String create_date;
    /// 是否启用
    /// 1：启用
    /// 2：未启用
    private int is_use;
    /// 是否删除
    /// 0：未删除
    /// 1：已删除
    private int isdelete;
    /// 邀请码
    /// 用户注册时使用，未存入用户数据表
    private String invite_code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getIs_use() {
        return is_use;
    }

    public void setIs_use(int is_use) {
        this.is_use = is_use;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    @Override
    public String toString() {
        return "BasUserEntity{" +
                "id='" + id + '\'' +
                ", user_account='" + user_account + '\'' +
                ", mobile='" + mobile + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", user_type=" + user_type +
                ", create_date='" + create_date + '\'' +
                ", is_use=" + is_use +
                ", isdelete=" + isdelete +
                ", invite_code='" + invite_code + '\'' +
                '}';
    }
}
