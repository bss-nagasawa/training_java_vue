package com.applications.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "admin_login_info")
public class Admin {
    @Id
    @Column(name = "login_id", nullable = false)
    private String loginId; 

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false) 
    private int id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "auth", nullable = false)
    private int auth;

    @Column(name = "regist_date", nullable = false)
    private Timestamp registDate;

    @Column(name = "register", nullable = false)
    private String register;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public Timestamp getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }
}
