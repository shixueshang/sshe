package com.lhd.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lihongde on 2016/10/31 10:56.
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "user_id", nullable = false, length = 11)
    private Integer userId;

    @Column(name = "role_id", nullable = false, length = 11)
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
