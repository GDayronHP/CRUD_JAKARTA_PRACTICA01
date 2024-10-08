package com.tecsup.prj_educacion.services.impl;

import com.tecsup.prj_educacion.modelo.daos.UserDao;
import com.tecsup.prj_educacion.modelo.daos.impl.DaoFactory;
import com.tecsup.prj_educacion.modelo.entities.User;
import com.tecsup.prj_educacion.services.UserService;
import com.tecsup.prj_educacion.util.Util;

public class UserServiceImpl implements UserService {

    private UserDao dao;

    public UserServiceImpl() {
        dao= DaoFactory.getUserDao(Util.opc);
    }


    @Override
    public User validar(String u, String p) {
        return dao.validar(u, p);
    }
}
