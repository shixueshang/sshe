package com.lhd.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "password")
    private String password;

    @Column(name = "is_valid")
    private boolean isValid = true;

    @Transient
    private List<Integer> roleIds;

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

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
