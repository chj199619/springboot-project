package org.lanqiao.project.pojo;

public class YLRate {
    private int g_id;
    private int u_id;
    private String g_name;
    private  String t_type;
    private String r_news;
    private int o_id;
    private String huifu;
    private String news;

    public YLRate() {
    }

    public YLRate(int g_id, int u_id, String g_name, String r_news) {
        this.g_id = g_id;
        this.u_id = u_id;
        this.g_name = g_name;
        this.r_news = r_news;
    }

    public YLRate(int g_id, int u_id, String huifu) {
        this.g_id = g_id;
        this.u_id = u_id;
        this.huifu = huifu;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
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

    public String getR_news() {
        return r_news;
    }

    public void setR_news(String r_news) {
        this.r_news = r_news;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getHuifu() {
        return huifu;
    }

    public void setHuifu(String huifu) {
        this.huifu = huifu;
    }

    @Override
    public String toString() {
        return "YLRate{" +
                "g_id=" + g_id +
                ", u_id=" + u_id +
                ", g_name='" + g_name + '\'' +
                ", t_type='" + t_type + '\'' +
                ", r_news='" + r_news + '\'' +
                ", o_id=" + o_id +
                ", huifu='" + huifu + '\'' +
                '}';
    }
}
