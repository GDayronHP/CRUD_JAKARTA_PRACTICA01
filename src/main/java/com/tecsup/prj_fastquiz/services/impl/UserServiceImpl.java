package com.tecsup.prj_fastquiz.services.impl;

import com.tecsup.prj_fastquiz.modelo.daos.UserDao;
import com.tecsup.prj_fastquiz.modelo.daos.impl.DaoFactory;
import com.tecsup.prj_fastquiz.modelo.entities.User;
import com.tecsup.prj_fastquiz.services.UserService;
import com.tecsup.prj_fastquiz.util.Util;

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
