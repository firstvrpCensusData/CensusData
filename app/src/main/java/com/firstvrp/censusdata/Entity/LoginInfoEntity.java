package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/6/2.
 */
public class LoginInfoEntity {
//    "msg": "登录成功",
//            "success": true,
    private String msg;
    private boolean success;

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

    public BasUserEntity getUser() {
        return user;
    }

    public void setUser(BasUserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginInfoEntity{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", user=" + user +
                '}';
    }
}
