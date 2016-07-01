package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/6/22.
 */
public class ForgetPasswordEntity {
    private Boolean success;
    private String msg;
    private String id;
    private BasUserEntity user;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BasUserEntity getUser() {
        return user;
    }

    public void setUser(BasUserEntity user) {
        this.user = user;
    }
}
