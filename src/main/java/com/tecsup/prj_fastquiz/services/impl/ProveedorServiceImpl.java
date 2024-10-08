package com.tecsup.prj_fastquiz.services.impl;

import com.tecsup.prj_fastquiz.modelo.daos.ProveedorDao;
import com.tecsup.prj_fastquiz.modelo.daos.impl.DaoFactory;
import com.tecsup.prj_fastquiz.modelo.entities.Proveedor;
import com.tecsup.prj_fastquiz.services.ProveedorService;
import com.tecsup.prj_fastquiz.util.Util;


import java.util.List;

public class ProveedorServiceImpl implements ProveedorService {

    private ProveedorDao dao;
    public ProveedorServiceImpl() {
        dao = DaoFactory.getProveedorDao(Util.opc);
    }

    @Override
    public void grabar(Proveedor proveedor) {
        dao.create(proveedor);
    }

    @Override
    public Proveedor buscar(String id) {
        return dao.find(id);
    }

    @Override
    public List<Proveedor> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Proveedor curso) {
        dao.update(curso);
    }

    @Override
    public void borrar(String id) {
        dao.delete(id);
    }

    @Override
    public List<Proveedor> filterByCreditos(int min, int max) {
        return List.of();
    }
}
