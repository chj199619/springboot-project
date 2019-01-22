package org.lanqiao.project.pojo;

public class psCar {
    private int g_id;
    private String g_img;
    private String g_name;
    private String g_color;
    private double c_price;
    private int c_num;
    private int u_id;
    private int p_id;

    public psCar(int g_id, String g_img, String g_name, String g_color, double c_price, int c_num, int u_id, int p_id) {
        this.g_id = g_id;
        this.g_img = g_img;
        this.g_name = g_name;
        this.g_color = g_color;
        this.c_price = c_price;
        this.c_num = c_num;
        this.u_id = u_id;
        this.p_id = p_id;
    }

    public psCar(String g_img, String g_name, String g_color, double c_price, int c_num, int u_id, int p_id) {
        this.g_img = g_img;
        this.g_name = g_name;
        this.g_color = g_color;
        this.c_price = c_price;
        this.c_num = c_num;
        this.u_id = u_id;
        this.p_id = p_id;
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

    public String getG_color() {
        return g_color;
    }

    public void setG_color(String g_color) {
        this.g_color = g_color;
    }

    public double getC_price() {
        return c_price;
    }

    public void setC_price(double c_price) {
        this.c_price = c_price;
    }

    public int getC_num() {
        return c_num;
    }

    public void setC_num(int c_num) {
        this.c_num = c_num;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "psCar{" +
                "g_id=" + g_id +
                ", g_img='" + g_img + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_color='" + g_color + '\'' +
                ", c_price=" + c_price +
                ", c_num=" + c_num +
                ", u_id=" + u_id +
                ", p_id=" + p_id +
                '}';
    }
}
