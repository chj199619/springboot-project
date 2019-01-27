package org.lanqiao.project.pojo;

import lombok.*;

import java.util.Date;
//@Getter
//@Setter
//@ToString
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor

public class CUser {
    private int u_id;
    private String u_name;
    private String u_password;
    private String u_nickname;
    private String u_phone;
    private String u_email;
    private String u_hiredate;
    private String u_address;
    private String province;
    private String city;
    private String area;


    public CUser() {
    }

    public CUser(String u_name, String u_password, String u_nickname, String u_phone, String u_email, String u_hiredate, String province, String city, String area, String u_address) {
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
        this.u_address = u_address;
        this.province = province;
        this.city = city;
        this.area = area;
    }

    public CUser(int u_id, String u_password) {
        this.u_id = u_id;
        this.u_password = u_password;
    }

    public CUser(int u_id, String u_name, String u_password, String u_nickname, String u_phone, String u_email, String u_hiredate, String u_address, String province, String city, String area) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
        this.u_address = u_address;
        this.province = province;
        this.city = city;
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public CUser(String u_name, String u_password, String u_nickname, String u_phone, String u_email, String u_hiredate) {
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
    }

    public CUser(int u_id, String u_name, String u_password, String u_nickname, String u_phone, String u_email, String u_hiredate, String u_address) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
        this.u_address = u_address;
    }

    public CUser(String u_name, String u_password, String u_nickname, String u_phone, String u_email, String u_hiredate, String u_address) {
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_nickname = u_nickname;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_hiredate = u_hiredate;
        this.u_address = u_address;
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

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
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
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_nickname='" + u_nickname + '\'' +
                ", u_phone='" + u_phone + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_hiredate='" + u_hiredate + '\'' +
                ", u_address='" + u_address + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
