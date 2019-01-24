package org.lanqiao.project.pojo;

public class Type {
    private int id;
    private String t_type;
    private String zhuangtai;
    private String s_time;
    private String x_time;
    private String t_herf;

    public Type() {
    }

    public String getT_herf() {
        return t_herf;
    }


    public void setT_herf(String t_herf) {
        this.t_herf = t_herf;
    }

    public Type(int id, String t_type, String zhuangtai) {
        this.id = id;
        this.t_type = t_type;
        this.zhuangtai = zhuangtai;
    }

    public Type(String t_type, String zhuangtai) {
        this.t_type = t_type;
        this.zhuangtai = zhuangtai;
    }

    public Type(String t_type, String zhuangtai, String s_time) {
        this.t_type = t_type;
        this.zhuangtai = zhuangtai;
        this.s_time = s_time;
    }


    public Type(int id, String t_type, String zhuangtai, String s_time, String x_time) {
        this.id = id;
        this.t_type = t_type;
        this.zhuangtai = zhuangtai;
        this.s_time = s_time;
        this.x_time = x_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public String getX_time() {
        return x_time;
    }

    public void setX_time(String x_time) {
        this.x_time = x_time;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", t_type='" + t_type + '\'' +
                ", zhuangtai='" + zhuangtai + '\'' +
                ", s_time='" + s_time + '\'' +
                ", x_time='" + x_time + '\'' +
                '}';
    }
}
