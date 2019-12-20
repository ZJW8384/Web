package com.vo;

public class Teacher {
    private int id;
    private String tid;
    private String name;
    private String pass;
    private String age;
    private String sex;
    private String units;
    private String phone;
    private String balance;
    private String max;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", units='" + units + '\'' +
                ", phone='" + phone + '\'' +
                ", balance='" + balance + '\'' +
                ", max='" + max + '\'' +
                '}';
    }
}
