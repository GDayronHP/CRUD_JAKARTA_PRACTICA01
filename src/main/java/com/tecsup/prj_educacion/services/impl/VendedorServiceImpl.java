package com.tecsup.prj_educacion.services.impl;

import com.tecsup.prj_educacion.modelo.daos.VendedorDao;
import com.tecsup.prj_educacion.modelo.daos.impl.DaoFactory;
import com.tecsup.prj_educacion.modelo.entities.Vendedor;
import com.tecsup.prj_educacion.services.CursoService;
import com.tecsup.prj_educacion.services.VendedorService;
import com.tecsup.prj_educacion.util.Util;


import java.util.List;

public class VendedorServiceImpl implements VendedorService {

    private VendedorDao dao;
    public VendedorServiceImpl() {
        dao = DaoFactory.getVendedorDao(Util.opc);
    }

    @Override
    public void grabar(Vendedor proveedor) {
        dao.create(proveedor);
    }

    @Override
    public Vendedor buscar(String id) {
        return dao.find(id);
    }

    @Override
    public List<Vendedor> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Vendedor curso) {
        dao.update(curso);
    }

    @Override
    public void borrar(String id) {
        dao.delete(id);
    }

    @Override
    public List<Vendedor> filterByCreditos(int min, int max) {
        return List.of();
    }
}
