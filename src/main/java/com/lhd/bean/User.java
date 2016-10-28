package com.lhd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, length = 11)
    private Integer id;

    @Column(name = "LOGIN_NAME")
    private String loginName;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_VALID")
    private boolean isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
