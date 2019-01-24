package org.lanqiao.project.pojo;

public class Rate {
    private int rate_id;
    private int g_id;
    private int o_id;
    private String u_name;
    private String g_name;
    private String t_type;
    private String news;
    private String answernews;

    public Rate() {
    }

    public Rate(int rate_id, int g_id, int o_id, String u_name, String g_name, String t_type, String news, String answernews) {
        this.rate_id = rate_id;
        this.g_id = g_id;
        this.o_id = o_id;
        this.u_name = u_name;
        this.g_name = g_name;
        this.t_type = t_type;
        this.news = news;
        this.answernews = answernews;
    }

    public int getRate_id() {
        return rate_id;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getAnswernews() {
        return answernews;
    }

    public void setAnswernews(String answernews) {
        this.answernews = answernews;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rate_id=" + rate_id +
                ", g_id=" + g_id +
                ", o_id=" + o_id +
                ", u_name='" + u_name + '\'' +
                ", g_name='" + g_name + '\'' +
                ", t_type='" + t_type + '\'' +
                ", news='" + news + '\'' +
                ", answernews='" + answernews + '\'' +
                '}';
    }
}
