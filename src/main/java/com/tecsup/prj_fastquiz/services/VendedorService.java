package com.tecsup.prj_fastquiz.services;

import com.tecsup.prj_fastquiz.modelo.entities.Vendedor;

import java.util.List;

public interface VendedorService {
    public void grabar(Vendedor curso);
    public Vendedor buscar(String id);
    public List<Vendedor> listar();
    public void actualizar(Vendedor curso);
    public void borrar(String id);
    public List<Vendedor> filterByCreditos(int min, int max);
}


