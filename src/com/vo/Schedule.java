package com.vo;

public class Schedule {
    private  String msg;
    private int id;
    private String time;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "msg='" + msg + '\'' +
                ", id=" + id +
                ", time='" + time + '\'' +
                '}';
    }
}
