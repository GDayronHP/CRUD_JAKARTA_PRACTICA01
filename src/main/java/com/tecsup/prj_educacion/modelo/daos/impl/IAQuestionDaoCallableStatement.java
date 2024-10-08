package com.tecsup.prj_educacion.modelo.daos.impl;

import com.tecsup.prj_educacion.modelo.daos.IAQuestionDao;
import com.tecsup.prj_educacion.modelo.entities.IAQuestion;
import com.tecsup.prj_educacion.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IAQuestionDaoCallableStatement implements IAQuestionDao {

    @Override
    public void create(IAQuestion question) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_create_IAQuestion(?,?,?,?)}")) {
            cst.setString(1, question.getQuestionText());
            cst.setString(2, question.getTimeLimit());
            cst.setInt(3, question.getQuizId());
            cst.setInt(4, question.getQuestionTypeId());
            cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la inserción: " + e.getMessage());
        }
    }

    @Override
    public void update(IAQuestion question) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_update_IAQuestion(?,?,?,?,?)}")) {
            cst.setInt(1, question.getId());
            cst.setString(2, question.getQuestionText());
            cst.setString(3, question.getTimeLimit());
            cst.setInt(4, question.getQuizId());
            cst.setInt(5, question.getQuestionTypeId());
            cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la actualización: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_delete_IAQuestion(?)}")) {
            cst.setInt(1, id);
            cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la eliminación: " + e.getMessage());
        }
    }

    @Override
    public IAQuestion find(Integer id) {
        IAQuestion question = null;
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_get_IAQuestion_by_id(?)}")) {
            cst.setInt(1, id);
            try (ResultSet rs = cst.executeQuery()) {
                if (rs.next()) {
                    question = new IAQuestion(
                            rs.getInt("id"),
                            rs.getString("questionText"),
                            rs.getString("timeLimit"),
                            rs.getInt("Quizizz_id"),
                            rs.getInt("QuestionType_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
        return question;
    }

    @Override
    public List<IAQuestion> findAll() {
        List<IAQuestion> questions = new ArrayList<>();
        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall("{call sp_get_all_IAQuestions()}");
             ResultSet rs = cst.executeQuery()) {
            while (rs.next()) {
                questions.add(new IAQuestion(
                        rs.getInt("id"),
                        rs.getString("questionText"),
                        rs.getString("timeLimit"),
                        rs.getInt("Quizizz_id"),
                        rs.getInt("QuestionType_id")));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
        return questions;
    }
}
