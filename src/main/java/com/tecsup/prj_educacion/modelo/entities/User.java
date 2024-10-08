package com.tecsup.prj_educacion.modelo.entities;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String email;
    private String password;
    private String nightmode;
    private int RolesidRoles;

    public User() {}

    public User(int id, String name, String email, String password, String nightmode, int RolesidRoles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nightmode = nightmode;
        this.RolesidRoles = RolesidRoles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNightmode() {
        return nightmode;
    }

    public void setNightmode(String nightmode) {
        this.nightmode = nightmode;
    }

    public int getRolesidRoles() {
        return RolesidRoles;
    }

    public void setRolesidRoles(int RolesidRoles) {
        this.RolesidRoles = RolesidRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nightmode='" + nightmode + '\'' +
                ", RolesidRoles=" + RolesidRoles +
                '}';
    }
}
