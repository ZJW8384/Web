package com.vo;

public class SelfMessage {
    private String bkid;
    private String bkname;
    private  String number;
    private String time;
    private  String money;
    private String bktime;

    public String getBktime() {
        return bktime;
    }

    public void setBktime(String bktime) {
        this.bktime = bktime;
    }

    public String getBkid() {
        return bkid;
    }

    public void setBkid(String bkid) {
        this.bkid = bkid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "SelfMessage{" +
                "bkid='" + bkid + '\'' +
                ", bkname='" + bkname + '\'' +
                ", number='" + number + '\'' +
                ", time='" + time + '\'' +
                ", money='" + money + '\'' +
                ", bktime='" + bktime + '\'' +
                '}';
    }
}
