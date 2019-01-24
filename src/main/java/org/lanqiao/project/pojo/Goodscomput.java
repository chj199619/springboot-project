package org.lanqiao.project.pojo;

import lombok.*;


public class Goodscomput {
    private int g_id;
    private String g_img;
    private String g_name;
    private double g_price;
    private String g_xiangqing;
    private String g_color;
    private String t_type;
    private double g_oriprice;
    private String g_neicun;
    private int g_num;
    private String g_hiredate;

    public Goodscomput() {
    }

    public Goodscomput(int g_id, String g_img, String g_name, double g_price, String g_xiangqing, String g_color, String t_type, double g_oriprice, String g_neicun, int g_num, String g_hiredate) {
        this.g_id = g_id;
        this.g_img = g_img;
        this.g_name = g_name;
        this.g_price = g_price;
        this.g_xiangqing = g_xiangqing;
        this.g_color = g_color;
        this.t_type = t_type;
        this.g_oriprice = g_oriprice;
        this.g_neicun = g_neicun;
        this.g_num = g_num;
        this.g_hiredate = g_hiredate;
    }

    public Goodscomput(String g_img, String g_name,String g_xiangqing, double g_price,double g_oriprice, String g_color, String t_type,  String g_neicun, String g_hiredate,int g_num) {
        this.g_img = g_img;
        this.g_name = g_name;
        this.g_price = g_price;
        this.g_xiangqing = g_xiangqing;
        this.g_color = g_color;
        this.t_type = t_type;
        this.g_oriprice = g_oriprice;
        this.g_neicun = g_neicun;
        this.g_hiredate = g_hiredate;
        this.g_num = g_num;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_img() {
        return g_img;
    }

    public void setG_img(String g_img) {
        this.g_img = g_img;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public String getG_xiangqing() {
        return g_xiangqing;
    }

    public void setG_xiangqing(String g_xiangqing) {
        this.g_xiangqing = g_xiangqing;
    }

    public String getG_color() {
        return g_color;
    }

    public void setG_color(String g_color) {
        this.g_color = g_color;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public double getG_oriprice() {
        return g_oriprice;
    }

    public void setG_oriprice(double g_oriprice) {
        this.g_oriprice = g_oriprice;
    }

    public String getG_neicun() {
        return g_neicun;
    }

    public void setG_neicun(String g_neicun) {
        this.g_neicun = g_neicun;
    }

    public int getG_num() {
        return g_num;
    }

    public void setG_num(int g_num) {
        this.g_num = g_num;
    }

    public String getG_hiredate() {
        return g_hiredate;
    }

    public void setG_hiredate(String g_hiredate) {
        this.g_hiredate = g_hiredate;
    }

    @Override
    public String toString() {
        return "Goodscomput{" +
                "g_id=" + g_id +
                ", g_img='" + g_img + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_xiangqing='" + g_xiangqing + '\'' +
                ", g_color='" + g_color + '\'' +
                ", t_type='" + t_type + '\'' +
                ", g_oriprice=" + g_oriprice +
                ", g_neicun='" + g_neicun + '\'' +
                ", g_num=" + g_num +
                ", g_hiredate='" + g_hiredate + '\'' +
                '}';
    }
}
