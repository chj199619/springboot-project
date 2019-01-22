
package org.lanqiao.project.pojo;
public class Paper {
    private Integer id;
    private Integer ddid;
    private String name;
    private double orgp;
    private double lastp;
    private String pscondition;
    private String kuaidi;
    private int u_id;

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

    public Paper(Integer ddid, String name, double orgp, double lastp, String pscondition, String kuaidi) {
        this.ddid = ddid;
        this.name = name;
        this.orgp = orgp;
        this.lastp = lastp;
        this.pscondition = pscondition;
        this.kuaidi = kuaidi;
    }

    public Paper(Integer id, String pscondition) {
        this.id = id;
        this.pscondition = pscondition;
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
                '}';
    }
}
