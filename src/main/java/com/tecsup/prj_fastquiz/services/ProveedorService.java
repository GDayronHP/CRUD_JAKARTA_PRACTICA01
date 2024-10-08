package com.tecsup.prj_fastquiz.services;

import com.tecsup.prj_fastquiz.modelo.entities.Proveedor;

import java.util.List;

public interface ProveedorService {
    public void grabar(Proveedor proveedor);
    public Proveedor buscar(String id);
    public List<Proveedor> listar();
    public void actualizar(Proveedor curso);
    public void borrar(String id);
    public List<Proveedor> filterByCreditos(int min, int max);
}


