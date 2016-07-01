package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/6/17.
 */
public class UnitsInfoReturnEntity {
//    {"msg":null,"success":true,"id":"271e61f5cc2f48369cf58cd607f5067b","user":null}
    private String msg;
    private boolean success;
    private String id;
    private BasUserEntity user;

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

    public BasUserEntity getUser() {
        return user;
    }

    public void setUser(BasUserEntity user) {
        this.user = user;
    }
}
