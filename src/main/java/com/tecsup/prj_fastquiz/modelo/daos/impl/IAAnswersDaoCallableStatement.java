package com.tecsup.prj_fastquiz.modelo.daos.impl;

import com.tecsup.prj_fastquiz.modelo.daos.IAAnswersDao;
import com.tecsup.prj_fastquiz.modelo.entities.IAAnswers;
import com.tecsup.prj_fastquiz.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IAAnswersDaoCallableStatement implements IAAnswersDao {

    @Override
    public void create(IAAnswers answer) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_create_IAAnswer(?,?,?)}")) {
            cst.setString(1, answer.getAnswerText());
            cst.setBoolean(2, answer.isCorrect());
            cst.setInt(3, answer.getQuestionId());
            cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la inserción: " + e.getMessage());
        }
    }

    @Override
    public void update(IAAnswers answer) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_update_IAAnswer(?,?,?,?)}")) {
            cst.setInt(1, answer.getId());
            cst.setString(2, answer.getAnswerText());
            cst.setBoolean(3, answer.isCorrect());
            cst.setInt(4, answer.getQuestionId());
            cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la actualización: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_delete_IAAnswer(?)}")) {
            cst.setInt(1, id);
            cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la eliminación: " + e.getMessage());
        }
    }

    @Override
    public IAAnswers find(Integer id) {
        IAAnswers answer = null;
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_get_IAAnswer_by_id(?)}")) {
            cst.setInt(1, id);
            try (ResultSet rs = cst.executeQuery()) {
                if (rs.next()) {
                    answer = new IAAnswers(
                            rs.getInt("id"),               // Asegúrate de que este es el nombre correcto del campo
                            rs.getString("answerText"),    // Nombre correcto del campo para answerText
                            rs.getBoolean("isCorrect"),     // Nombre correcto del campo para isCorrect
                            rs.getInt("IAQuestion_id")      // Nombre correcto del campo para IAQuestion_id
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
        return answer;
    }


    @Override
    public List<IAAnswers> findAll() {
        List<IAAnswers> answers = new ArrayList<>();
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_get_all_IAAnswers()}");
             ResultSet rs = cst.executeQuery()) {
            while (rs.next()) {
                answers.add(new IAAnswers(
                        rs.getInt("id"),
                        rs.getString("answerText"),
                        rs.getBoolean("isCorrect"),
                        rs.getInt("IAQuestion_id")));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
        return answers;
    }
}
