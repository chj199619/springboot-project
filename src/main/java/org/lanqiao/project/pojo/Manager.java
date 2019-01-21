package org.lanqiao.project.pojo;

public class Manager {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String role;
    private String email;
    private String jointime;

    public Manager() {
    }

    public Manager(int id, String username, String password, String phone, String role, String email, String jointime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.email = email;
        this.jointime = jointime;
    }

    public Manager(String username, String password, String phone, String role, String email, String jointime) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.email = email;
        this.jointime = jointime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", jointime='" + jointime + '\'' +
                '}';
    }
}
