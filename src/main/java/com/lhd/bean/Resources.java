package com.lhd.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lihongde on 2016/10/28 15:25.
 */
@Entity
@Table( name = "resources")
public class Resources  implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "url")
    private String url;

    @Column(name = "description")
    private String description;

    @Column(name = "is_valid")
    private boolean isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
