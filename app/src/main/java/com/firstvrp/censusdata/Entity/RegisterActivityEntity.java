package com.firstvrp.censusdata.Entity;

/**
 * 注册返回值使用
 * Created by chenyuan on 16/6/7.
 */
public class RegisterActivityEntity {
    private String msg;
    private Boolean success;
    private BasUserEntity user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public BasUserEntity getUser() {
        return user;
    }

    public void setUser(BasUserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RegisterActivityEntity{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", user=" + user +
                '}';
    }
}
