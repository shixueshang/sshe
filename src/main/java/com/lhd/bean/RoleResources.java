package com.lhd.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lihongde on 2016/10/31 11:25.
 */
@Entity
@Table(name = "role_resources")
public class RoleResources implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "role_id", nullable = false, length = 11)
    private Integer roleId;

    @Column(name = "resource_id", nullable = false, length = 11)
    private Integer resourceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
