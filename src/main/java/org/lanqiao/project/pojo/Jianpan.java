package org.lanqiao.project.pojo;

import java.math.BigDecimal;

public class Jianpan {
    private int id;
    private String jname;
    private BigDecimal jorgprice;
    private BigDecimal jlastprice;
    private int jnum;
    private String jpicture;
    private String t_type;
    private String jhiredate;

    public Jianpan() {
    }

    public Jianpan(String jname, BigDecimal jorgprice, BigDecimal jlastprice, int jnum, String jpicture, String t_type, String jhiredate) {
        this.jname = jname;
        this.jorgprice = jorgprice;
        this.jlastprice = jlastprice;
        this.jnum = jnum;
        this.jpicture = jpicture;
        this.t_type = t_type;
        this.jhiredate = jhiredate;
    }

    public Jianpan(int id, String jname, BigDecimal jorgprice, BigDecimal jlastprice, int jnum, String jpicture, String t_type, String jhiredate) {
        this.id = id;
        this.jname = jname;
        this.jorgprice = jorgprice;
        this.jlastprice = jlastprice;
        this.jnum = jnum;
        this.jpicture = jpicture;
        this.t_type = t_type;
        this.jhiredate = jhiredate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public BigDecimal getJorgprice() {
        return jorgprice;
    }

    public void setJorgprice(BigDecimal jorgprice) {
        this.jorgprice = jorgprice;
    }

    public BigDecimal getJlastprice() {
        return jlastprice;
    }

    public void setJlastprice(BigDecimal jlastprice) {
        this.jlastprice = jlastprice;
    }

    public int getJnum() {
        return jnum;
    }

    public void setJnum(int jnum) {
        this.jnum = jnum;
    }

    public String getJpicture() {
        return jpicture;
    }

    public void setJpicture(String jpicture) {
        this.jpicture = jpicture;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getJhiredate() {
        return jhiredate;
    }

    public void setJhiredate(String jhiredate) {
        this.jhiredate = jhiredate;
    }

    @Override
    public String toString() {
        return "Jianpan{" +
                "id=" + id +
                ", jname='" + jname + '\'' +
                ", jorgprice=" + jorgprice +
                ", jlastprice=" + jlastprice +
                ", jnum=" + jnum +
                ", jpicture='" + jpicture + '\'' +
                ", t_type='" + t_type + '\'' +
                ", jhiredate='" + jhiredate + '\'' +
                '}';
    }
}
