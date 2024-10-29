package com.applications.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.sql.Timestamp;

//DBのlogin_login_infoテーブルに接続し、操作するためのクラス
@Entity
@Table(name = "user_login_info")
public class User {
    //自動採番
    //項目名：ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    //プライマリーキー
    @Id
    //項目名：ログインID
    @Column(name = "login_id", nullable = false)
    private String loginId;

    //項目名：パスワード
    @Column(name = "password", nullable = false)
    private String password;

    //項目名：カテゴリ
    @Column(name = "category", nullable = true)
    private int category;

    //項目名：登録日
    @Column(name = "regist_date", nullable = false)
    private Timestamp registDate;

    //項目名：更新日
    @Column(name = "update_date", nullable = true)
    private Timestamp updateDate;

    // 各項目のgetterとsetter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Timestamp getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}