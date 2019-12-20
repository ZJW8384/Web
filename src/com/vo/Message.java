package com.vo;

public class Message {
    private int id;
    private String uid;
    private String mes;
    private String time;
    private String bkname;

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", mes='" + mes + '\'' +
                ", time='" + time + '\'' +
                ", bkname='" + bkname + '\'' +
                '}';
    }
}
