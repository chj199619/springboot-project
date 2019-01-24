package org.lanqiao.project.pojo;

public class Goodsmouse {
    private int g_id;
    private String g_img;
    private String g_name;
    private double g_oriprice;
    private double g_price;
    private String t_type;
    private int g_num;
    public Goodsmouse() {
    }

    public Goodsmouse(int g_id, String g_img, String g_name, double g_oriprice, double g_price, String t_type, int g_num) {
        this.g_id = g_id;
        this.g_img = g_img;
        this.g_name = g_name;
        this.g_oriprice = g_oriprice;
        this.g_price = g_price;
        this.t_type = t_type;
        this.g_num = g_num;
    }

    public Goodsmouse(String g_img, String g_name, double g_oriprice, double g_price, String t_type, int g_num) {
        this.g_img = g_img;
        this.g_name = g_name;
        this.g_oriprice = g_oriprice;
        this.g_price = g_price;
        this.t_type = t_type;
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

    public double getG_oriprice() {
        return g_oriprice;
    }

    public void setG_oriprice(double g_oriprice) {
        this.g_oriprice = g_oriprice;
    }
    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public int getG_num() {
        return g_num;
    }

    public void setG_num(int g_num) {
        this.g_num = g_num;
    }
    @Override
    public String toString() {
        return "Goodsmouse{" +
                "g_id=" + g_id +
                ", g_img='" + g_img + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_oriprice=" + g_oriprice +
                ", g_price=" + g_price +
                ", t_type='" + t_type + '\'' +
                ", g_num=" + g_num +
                '}';
    }
}
