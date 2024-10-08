package com.tecsup.prj_fastquiz.services;

import com.tecsup.prj_fastquiz.modelo.entities.User;

public interface UserService {
    public User validar(String u, String p);
}
