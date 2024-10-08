package com.tecsup.prj_educacion.services;

import com.tecsup.prj_educacion.modelo.entities.User;

public interface UserService {
    public User validar(String u, String p);
}
