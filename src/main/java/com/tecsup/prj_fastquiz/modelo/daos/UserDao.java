package com.tecsup.prj_fastquiz.modelo.daos;

import com.tecsup.prj_fastquiz.modelo.entities.User;

public interface UserDao {

    public User validar(String user, String password);

}

