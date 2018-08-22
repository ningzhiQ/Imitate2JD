package com.jd.myjd.imitate2jd.bean;

public class EventBean {
    private String moblie;
    private String pwd;

    public EventBean(String moblie, String pwd) {
        this.moblie = moblie;
        this.pwd = pwd;
    }



    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
