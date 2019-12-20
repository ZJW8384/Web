package com.vo;

public class BookMager {
    private int id;
    private String bkid;
    private String bkname;
    private String ISBN;
    private String price;
    private String writer;
    private String press;
    private String language;
    private String subject;
    private String state;
    private String place;
    private String date;
    private String indexs;
    private String barcode;
    private String collection;
    private String collections;
    private String time;
    private  String number;
    private  String type;
    private String classify;

    public String getBkid() {
        return bkid;
    }

    public void setBkid(String bkid) {
        this.bkid = bkid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIndexs() {
        return indexs;
    }

    public void setIndexs(String indexs) {
        this.indexs = indexs;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getCollections() {
        return collections;
    }

    public void setCollections(String collections) {
        this.collections = collections;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BookMager{" +
                "id=" + id +
                ", bkid='" + bkid + '\'' +
                ", bkname='" + bkname + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price='" + price + '\'' +
                ", writer='" + writer + '\'' +
                ", press='" + press + '\'' +
                ", language='" + language + '\'' +
                ", subject='" + subject + '\'' +
                ", state='" + state + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", indexs='" + indexs + '\'' +
                ", barcode='" + barcode + '\'' +
                ", collection='" + collection + '\'' +
                ", collections='" + collections + '\'' +
                ", time='" + time + '\'' +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", classify='" + classify + '\'' +
                '}';
    }
}
