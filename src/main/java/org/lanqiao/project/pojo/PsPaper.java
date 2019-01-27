package org.lanqiao.project.pojo;

public class PsPaper {
    private Integer id;
    private Integer ddid;
    private String name;
    private double orgp;
    private double lastp;
    private String pscondition;
    private String kuaidi;
    private int u_id;
    private String adress;
    private String cond;

    public PsPaper() {
    }

    public PsPaper(Integer id, Integer ddid, String name, double orgp, double lastp, String pscondition, String kuaidi) {
        this.id = id;
        this.ddid = ddid;
        this.name = name;
        this.orgp = orgp;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
    }

    public PsPaper(Integer ddid, String name, double orgp, double lastp, String pscondition, String kuaidi) {
        this.ddid = ddid;
        this.name = name;
        this.orgp = orgp;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
    }

    public PsPaper(Integer id, String pscondition) {
        this.id = id;
        this.pscondition = pscondition;
    }


    public PsPaper(Integer id, int u_id, String pscondition) {
        this.id = id;
        this.u_id = u_id;
        this.pscondition = pscondition;
    }

    public String getAdress() {
        return adress;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
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

    public double getOrgp() {
        return orgp;
    }

    public void setOrgp(double orgp) {
        this.orgp = orgp;
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
                ", u_id=" + u_id +
                ", adress='" + adress + '\'' +
                ", cond='" + cond + '\'' +
                '}';
    }
}
