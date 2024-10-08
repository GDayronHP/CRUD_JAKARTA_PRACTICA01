package com.tecsup.prj_fastquiz.modelo.daos.impl;

import com.tecsup.prj_fastquiz.modelo.daos.VendedorDao;
import com.tecsup.prj_fastquiz.modelo.entities.Vendedor;
import com.tecsup.prj_fastquiz.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDaoCallableStatement implements VendedorDao {

    private static final Logger logger = Logger.getLogger(VendedorDaoCallableStatement.class.getName());

    public List<Vendedor> findAll() {
        List<Vendedor> vendedores = new ArrayList<>();
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_findAll_vendedor()}");
             ResultSet rs = cst.executeQuery()) {

            while (rs.next()) {
                vendedores.add(new Vendedor(
                        rs.getString("Cod_ven"),
                        rs.getString("Nom_ven"),
                        rs.getString("Ape_ven"),
                        rs.getString("Sue_ven"),
                        rs.getString("Fec_ing"),
                        rs.getInt("Tip_ven"),
                        rs.getString("Usu_ven"),
                        rs.getString("Pas_ven")
                ));
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la consulta findAll", e);
        }
        return vendedores;
    }

    public void create(Vendedor vendedor) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_ins_vendedor(?,?,?,?,?,?,?,?)}")) {

            cst.setString(1, vendedor.getCod_ven());
            cst.setString(2, vendedor.getNom_ven());
            cst.setString(3, vendedor.getApe_ven());
            cst.setString(4, vendedor.getSue_ven());
            cst.setString(5, vendedor.getFec_ing());
            cst.setInt(6, vendedor.getTip_ven());
            cst.setString(7, vendedor.getUsu_ven());
            cst.setString(8, vendedor.getPas_ven());
            cst.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la inserción create", e);
        }
    }

    public Vendedor find(String id) {
        Vendedor vendedor = null;
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_find_vendedor(?)}")) {

            cst.setString(1, id);
            try (ResultSet rs = cst.executeQuery()) {
                if (rs.next()) {
                    vendedor = new Vendedor(
                            rs.getString("Cod_ven"),
                            rs.getString("Nom_ven"),
                            rs.getString("Ape_ven"),
                            rs.getString("Sue_ven"),
                            rs.getString("Fec_ing"),
                            rs.getInt("Tip_ven"),
                            rs.getString("Usu_ven"),
                            rs.getString("Pas_ven")
                    );
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la consulta find", e);
        }
        return vendedor;
    }

    public void update(Vendedor vendedor) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_upd_vendedor(?,?,?,?,?,?,?,?)}")) {

            cst.setString(1, vendedor.getCod_ven());
            cst.setString(2, vendedor.getNom_ven());
            cst.setString(3, vendedor.getApe_ven());
            cst.setString(4, vendedor.getSue_ven());
            cst.setString(5, vendedor.getFec_ing());
            cst.setInt(6, vendedor.getTip_ven());
            cst.setString(7, vendedor.getUsu_ven());
            cst.setString(8, vendedor.getPas_ven());
            cst.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la actualización update", e);
        }
    }

    public void delete(String id) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_del_vendedor(?)}")) {

            cst.setString(1, id);
            cst.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la eliminación delete", e);
        }
    }
}
