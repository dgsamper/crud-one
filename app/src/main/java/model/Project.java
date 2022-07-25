/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author dgsamper
 */
public class Project {
    
    private int id;
    private String name;
    private String desc;
    private Date createdAt;
    private Date updatedAt;

    public Project(int id, String name, String desc, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Project() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", desc=" + desc + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
    
    
}

