package com.tecsup.prj_educacion.modelo.daos.impl;

import com.tecsup.prj_educacion.modelo.daos.*;
import com.tecsup.prj_educacion.util.Tipo;

public class DaoFactory {

    public static UserDao getUserDao(Tipo tipo){
        switch (tipo){
            case MEM:
                //return new UserDaoMemory();
            case PST:
                //return new UserDaoPreparedStatement();
            case CST:
                return new UserDaoCallableStatement();
            default:
                return null;
        }
    }

    public static CursoDao getCursoDao(Tipo tipo){
        switch (tipo){
            case MEM:
                //return new CursoDaoMemory();
            case PST:
                //return new CursoDaoPreparedStatement();
            case CST:
                return new CursoDaoCallableStatement();
            default:
                return null;
        }
    }

    public static ProveedorDao getProveedorDao(Tipo tipo){
        switch (tipo){
            case MEM:
                //return new ProveedorDaoMemory();
            case PST:
                //return new ProveedorDaoPreparedStatement();
            case CST:
                return new ProveedorDaoCallableStatement();
            default:
                return null;
        }
    }

    public static VendedorDao getVendedorDao(Tipo tipo){
        switch (tipo){
            case MEM:
                //return new VendedorDaoMemory();
            case PST:
                //return new VendedorDaoPreparedStatement();
            case CST:
                return new VendedorDaoCallableStatement();
            default:
                return null;
        }
    }

    public static IAQuestionDao getIAQuestionDao (Tipo tipo){
        switch (tipo){
            case MEM:
                //return new VendedorDaoMemory();
            case PST:
                //return new VendedorDaoPreparedStatement();
            case CST:
                return new IAQuestionDaoCallableStatement();
            default:
                return null;
        }
    }

    public static IAAnswersDao getIAAnswersDao (Tipo tipo){
        switch (tipo){
            case MEM:
                //return new VendedorDaoMemory();
            case PST:
                //return new VendedorDaoPreparedStatement();
            case CST:
                return new IAAnswersDaoCallableStatement();
            default:
                return null;
        }
    }
}