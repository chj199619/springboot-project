package org.lanqiao.project.pojo;

public class Paper {
    private Integer id;
    private Integer ddid;
    private String name;
    private double orgp;
    private double lastp;
    private String pscondition;
    private String kuaidi;
    private String adress;
    private Integer uid;

    public Paper() {
    }

    public Paper(Integer id, Integer ddid, String name, double orgp, double lastp, String pscondition, String kuaidi) {
        this.id = id;
        this.ddid = ddid;
        this.name = name;
        this.orgp = orgp;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
    }

    public Paper(Integer ddid, String name, double lastp, String pscondition, String kuaidi, String adress, Integer uid) {
        this.ddid = ddid;
        this.name = name;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
        this.adress = adress;
        this.uid = uid;
    }

    public Paper(Integer ddid, String name, double lastp, String pscondition, String kuaidi, Integer uid) {
        this.ddid = ddid;
        this.name = name;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
        this.uid = uid;
    }

    public Paper(Integer id, Integer ddid, String name, double lastp, String pscondition, String kuaidi, String adress) {
        this.id = id;
        this.ddid = ddid;
        this.name = name;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
        this.adress = adress;
    }

    public Paper(Integer ddid, String name, double lastp, String pscondition, String kuaidi, String adress) {
        this.ddid = ddid;
        this.name = name;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
        this.adress = adress;
    }

    public Paper(Integer ddid, String name, double lastp, String pscondition, String kuaidi) {
        this.ddid = ddid;
        this.name = name;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDdid() {
        return ddid;
    }

    public void setDdid(Integer ddid) {
        this.ddid = ddid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLastp() {
        return lastp;
    }

    public void setLastp(double lastp) {
        this.lastp = lastp;
    }

    public String getPscondition() {
        return pscondition;
    }

    public void setPscondition(String pscondition) {
        this.pscondition = pscondition;
    }

    public String getKuaidi() {
        return kuaidi;
    }

    public void setKuaidi(String kuaidi) {
        this.kuaidi = kuaidi;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getOrgp() {
        return orgp;
    }

    public void setOrgp(double orgp) {
        this.orgp = orgp;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", ddid=" + ddid +
                ", name='" + name + '\'' +
                ", orgp=" + orgp +
                ", lastp=" + lastp +
                ", pscondition='" + pscondition + '\'' +
                ", kuaidi='" + kuaidi + '\'' +
                ", adress='" + adress + '\'' +
                ", uid=" + uid +
                '}';
    }
}
