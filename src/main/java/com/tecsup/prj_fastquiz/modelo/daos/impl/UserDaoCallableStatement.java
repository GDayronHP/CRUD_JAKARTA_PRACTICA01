package com.tecsup.prj_fastquiz.modelo.daos.impl;

import com.tecsup.prj_fastquiz.modelo.daos.UserDao;
import com.tecsup.prj_fastquiz.modelo.entities.User;
import com.tecsup.prj_fastquiz.util.DBConn;

import java.sql.*;

public class UserDaoCallableStatement implements UserDao {

    @Override
    public User validar(String name, String password) {
        User administrador = null;

        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_login_User(?,?)}")) {

            if (con == null) {
                throw new SQLException("No se pudo establecer la conexión a la base de datos.");
            }

            // Preparar la llamada al procedimiento almacenado
            cst.setString(1, name);
            cst.setString(2, password);

            // Ejecutar la consulta
            try (ResultSet rs = cst.executeQuery()) {
                // Verificar si hay resultados
                if (rs.next()) {
                    administrador = new User();
                    administrador.setId(rs.getInt("id"));          // ID del usuario
                    administrador.setName(rs.getString("name"));   // Nombre del usuario
                    administrador.setEmail(rs.getString("email")); // Correo del usuario
                    administrador.setPassword(rs.getString("password")); // Contraseña del usuario
                    administrador.setNightmode(rs.getString("nightMode")); // Preferencia de modo nocturno
                    administrador.setRolesidRoles(rs.getInt("Roles_id")); // ID del rol
                } else {
                    System.out.println("No se encontro ningun usuario con el nombre y la contraseña proporcionados.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al validar usuario: " + e.getMessage());
        }

        return administrador;
    }
}
