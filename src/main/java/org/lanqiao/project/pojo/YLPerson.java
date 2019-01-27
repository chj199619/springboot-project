package org.lanqiao.project.pojo;

public class YLPerson {
    public int u_id;
    public String u_name;
    public String u_password;
    public String u_nickname;
    public String u_phone;
    public String u_email;
    public String u_hiredate;
    public String u_address;
    public String province;
    public String ciyt;
    public String area;

    public YLPerson() {
    }

    public YLPerson(int u_id, String u_name, String u_password, String u_nickname, String u_phone, String u_email, String u_hiredate, String u_address) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
        this.u_address = u_address;
    }

    public YLPerson(int u_id, String u_name, String u_password, String u_nickname, String u_phone, String u_email, String u_hiredate, String u_address, String province, String ciyt, String area) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
        this.u_address = u_address;
        this.province = province;
        this.ciyt = ciyt;
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCiyt() {
        return ciyt;
    }

    public void setCiyt(String ciyt) {
        this.ciyt = ciyt;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_nickname() {
        return u_nickname;
    }

    public void setU_nickname(String u_nickname) {
        this.u_nickname = u_nickname;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_hiredate() {
        return u_hiredate;
    }

    public void setU_hiredate(String u_hiredate) {
        this.u_hiredate = u_hiredate;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    @Override
    public String toString() {
        return "YLPerson{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_nickname='" + u_nickname + '\'' +
                ", u_phone='" + u_phone + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_hiredate='" + u_hiredate + '\'' +
                ", u_address='" + u_address + '\'' +
                '}';
    }
}
