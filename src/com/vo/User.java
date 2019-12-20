package com.vo;

public class User {
   private String name;
   private String id;
   private  String pass;
   private  String sex;
   private  String units;
   private  String classes;
   private  String phone;
   private  String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pass='" + pass + '\'' +
                ", sex='" + sex + '\'' +
                ", units='" + units + '\'' +
                ", classes='" + classes + '\'' +
                ", phone='" + phone + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
