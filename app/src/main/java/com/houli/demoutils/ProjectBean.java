package com.houli.demoutils;

import java.io.Serializable;

/**
 * Created by stone on 2018/3/26.
 */

public class ProjectBean implements Serializable{
    private int id;
    private String ProjectName;

    public ProjectBean(int id, String projectName) {
        this.id = id;
        ProjectName = projectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    @Override
    public String toString() {
        return "ProjectBean{" +
                "id=" + id +
                ", ProjectName='" + ProjectName + '\'' +
                '}';
    }
}
