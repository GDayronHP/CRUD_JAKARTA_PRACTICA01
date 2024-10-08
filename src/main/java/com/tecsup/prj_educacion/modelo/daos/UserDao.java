package com.tecsup.prj_educacion.modelo.daos;

import com.tecsup.prj_educacion.modelo.entities.User;

public interface UserDao {

    public User validar(String user, String password);

}

