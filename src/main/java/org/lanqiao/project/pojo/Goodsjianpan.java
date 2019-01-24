package org.lanqiao.project.pojo;

public class Goodsjianpan {
    private int id;
    private String jpicture;
    private String jname;
    private double jlastprice;
    private double jorgprice;
    private String t_type;
    private String jhiredate;
    private int jnum;


    public Goodsjianpan() {
    }

    public Goodsjianpan(int id, String jpicture, String jname, double jlastprice, double jorgprice, String t_type, String jhiredate, int jnum) {
        this.id = id;
        this.jpicture = jpicture;
        this.jname = jname;
        this.jlastprice = jlastprice;
        this.jorgprice = jorgprice;
        this.t_type = t_type;
        this.jhiredate = jhiredate;
        this.jnum = jnum;
    }

    public Goodsjianpan(String jpicture, String jname, double jlastprice, double jorgprice, String t_type, String jhiredate, int jnum) {
        this.jpicture = jpicture;
        this.jname = jname;
        this.jlastprice = jlastprice;
        this.jorgprice = jorgprice;
        this.t_type = t_type;
        this.jhiredate = jhiredate;
        this.jnum = jnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJpicture() {
        return jpicture;
    }

    public void setJpicture(String jpicture) {
        this.jpicture = jpicture;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public double getJlastprice() {
        return jlastprice;
    }

    public void setJlastprice(double jlastprice) {
        this.jlastprice = jlastprice;
    }

    public double getJorgprice() {
        return jorgprice;
    }

    public void setJorgprice(double jorgprice) {
        this.jorgprice = jorgprice;
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

    public int getJnum() {
        return jnum;
    }

    public void setJnum(int jnum) {
        this.jnum = jnum;
    }

    @Override
    public String toString() {
        return "Goodsjianpan{" +
                "id=" + id +
                ", jpicture='" + jpicture + '\'' +
                ", jname='" + jname + '\'' +
                ", jlastprice=" + jlastprice +
                ", jorgprice=" + jorgprice +
                ", t_type='" + t_type + '\'' +
                ", jhiredate='" + jhiredate + '\'' +
                ", jnum=" + jnum +
                '}';
    }
}
