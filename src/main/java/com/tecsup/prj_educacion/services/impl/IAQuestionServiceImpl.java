package com.tecsup.prj_educacion.services.impl;

import com.tecsup.prj_educacion.modelo.daos.IAQuestionDao;
import com.tecsup.prj_educacion.modelo.daos.impl.DaoFactory;
import com.tecsup.prj_educacion.modelo.entities.IAQuestion;
import com.tecsup.prj_educacion.services.IAQuestionService;
import com.tecsup.prj_educacion.util.Util;

import java.util.List;

public class IAQuestionServiceImpl implements IAQuestionService {

    private IAQuestionDao dao;

    public IAQuestionServiceImpl() {
        dao = DaoFactory.getIAQuestionDao(Util.opc); // Asegúrate de tener este método en tu fábrica
    }

    @Override
    public void grabar(IAQuestion question) {
        dao.create(question);
    }

    @Override
    public IAQuestion buscar(int id) {
        return dao.find(id);
    }

    @Override
    public List<IAQuestion> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(IAQuestion question) {
        dao.update(question);
    }

    @Override
    public void borrar(int id) {
        dao.delete(id);
    }
}
