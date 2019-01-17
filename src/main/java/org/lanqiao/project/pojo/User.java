package org.lanqiao.project.pojo;

import java.util.Date;

public class User {
    private int u_id;
    private String u_name;
    private String u_password;
    private String u_nickname;
    private String u_phone;
    private String u_email;
    private Date u_hiredate;

    public User() {
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

    public Date getU_hiredate() {
        return u_hiredate;
    }

    public void setU_hiredate(Date u_hiredate) {
        this.u_hiredate = u_hiredate;
    }

    public User(int u_id, String u_name, String u_password, String u_nickname, String u_phone, String u_email, Date u_hiredate) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
    }

    public User(String u_name, String u_password, String u_nickname, String u_phone, String u_email, Date u_hiredate) {
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_nickname='" + u_nickname + '\'' +
                ", u_phone='" + u_phone + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_hiredate=" + u_hiredate +
                '}';
    }
}
