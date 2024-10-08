package com.tecsup.prj_fastquiz.services.impl;

import com.tecsup.prj_fastquiz.modelo.daos.IAAnswersDao;
import com.tecsup.prj_fastquiz.modelo.daos.impl.DaoFactory;
import com.tecsup.prj_fastquiz.modelo.entities.IAAnswers;
import com.tecsup.prj_fastquiz.services.IAAnswersService;
import com.tecsup.prj_fastquiz.util.Util;

import java.util.List;

public class IAAnswersServiceImpl implements IAAnswersService {

    private IAAnswersDao dao;

    public IAAnswersServiceImpl() {
        dao = DaoFactory.getIAAnswersDao(Util.opc); // Inicializa el DAO correspondiente
    }

    @Override
    public void grabar(IAAnswers answer) {
        dao.create(answer);
    }

    @Override
    public IAAnswers buscar(int id) {
        return dao.find(id);
    }

    @Override
    public List<IAAnswers> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(IAAnswers answer) {
        dao.update(answer);
    }

    @Override
    public void borrar(int id) {
        dao.delete(id);
    }
}
