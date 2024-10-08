package com.tecsup.prj_fastquiz.modelo.daos.impl;

import com.tecsup.prj_fastquiz.modelo.daos.ProveedorDao;
import com.tecsup.prj_fastquiz.modelo.entities.Proveedor;
import com.tecsup.prj_fastquiz.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedorDaoCallableStatement implements ProveedorDao {

    private static final Logger logger = Logger.getLogger(ProveedorDaoCallableStatement.class.getName());

    public List<Proveedor> findAll() {
        List<Proveedor> proveedores = new ArrayList<>();
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_findAll_proveedor()}");
             ResultSet rs = cst.executeQuery()) {

            while (rs.next()) {
                proveedores.add(new Proveedor(
                        rs.getString("Cod_prv"),     // Nombre de columnas según base de datos
                        rs.getString("Raz_soc_prv"),
                        rs.getString("Dir_prv"),
                        rs.getInt("Tel_prv"),
                        rs.getString("Cod_dis"),
                        rs.getString("Rep_ven")
                ));
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la consulta findAll", e);
        }
        return proveedores;
    }

    public void create(Proveedor proveedor) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_ins_proveedor(?,?,?,?,?,?)}")) {

            cst.setString(1, proveedor.getCod_prv());
            cst.setString(2, proveedor.getRaz_soc_prv());
            cst.setString(3, proveedor.getDir_prv());
            cst.setInt(4, proveedor.getTel_prv());
            cst.setString(5, proveedor.getCod_dis());
            cst.setString(6, proveedor.getRep_ven());
            cst.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la inserción create", e);
        }
    }

    public Proveedor find(String id) {
        Proveedor proveedor = null;
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_find_proveedor(?)}")) {

            cst.setString(1, id);
            try (ResultSet rs = cst.executeQuery()) {
                if (rs.next()) {
                    proveedor = new Proveedor(
                            rs.getString("Cod_prv"),
                            rs.getString("Raz_soc_prv"),
                            rs.getString("Dir_prv"),
                            rs.getInt("Tel_prv"),
                            rs.getString("Cod_dis"),
                            rs.getString("Rep_ven")
                    );
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la consulta find", e);
        }
        return proveedor;
    }

    public void update(Proveedor proveedor) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_upd_proveedor(?,?,?,?,?,?)}")) {

            cst.setString(1, proveedor.getCod_prv());
            cst.setString(2, proveedor.getRaz_soc_prv());
            cst.setString(3, proveedor.getDir_prv());
            cst.setInt(4, proveedor.getTel_prv());
            cst.setString(5, proveedor.getCod_dis());
            cst.setString(6, proveedor.getRep_ven());
            cst.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la actualización update", e);
        }
    }

    public void delete(String id) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_del_proveedor(?)}")) {

            cst.setString(1, id);
            cst.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la eliminación delete", e);
        }
    }
}
