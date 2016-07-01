package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/6/10.
 */
public class UnitsInfoPostEntity {
    private String msg;
    private boolean success;
    private String id;
    private String user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
