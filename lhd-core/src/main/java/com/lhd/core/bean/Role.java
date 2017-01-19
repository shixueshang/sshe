package com.lhd.core.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lihongde on 2016/10/28 15:21.
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "role_code", nullable = false)
    private String roleCode;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_valid")
    private boolean isValid = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
