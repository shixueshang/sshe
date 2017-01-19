package com.lhd.core.bean;

import javax.persistence.*;

/**
 * Created by lihongde on 2016/11/10 15:05.
 */
@Entity
@Table(name = "dictionary")
public class Dictionary {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "cat")
    private String cat;

    @Column(name = "name")
    private String name;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "is_valid")
    private boolean isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
