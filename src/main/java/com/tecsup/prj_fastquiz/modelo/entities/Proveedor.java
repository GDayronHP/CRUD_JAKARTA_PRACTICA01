package com.tecsup.prj_fastquiz.modelo.entities;

public class Proveedor {

    private String Cod_prv;
    private String Raz_soc_prv;
    private String Dir_prv;
    private Integer Tel_prv;
    private String Cod_dis;
    private String Rep_ven;

    public Proveedor() {}

    public Proveedor(String cod_prv, String raz_soc_prv, String dir_prv, Integer tel_prv, String cod_dis, String rep_ven) {
        Cod_prv = cod_prv;
        Raz_soc_prv = raz_soc_prv;
        Dir_prv = dir_prv;
        Tel_prv = tel_prv;
        Cod_dis = cod_dis;
        Rep_ven = rep_ven;
    }

    public String getCod_prv() {
        return Cod_prv;
    }

    public void setCod_prv(String cod_prv) {
        Cod_prv = cod_prv;
    }

    public String getRaz_soc_prv() {
        return Raz_soc_prv;
    }

    public void setRaz_soc_prv(String raz_soc_prv) {
        Raz_soc_prv = raz_soc_prv;
    }

    public String getDir_prv() {
        return Dir_prv;
    }

    public void setDir_prv(String dir_prv) {
        Dir_prv = dir_prv;
    }

    public Integer getTel_prv() {
        return Tel_prv;
    }

    public void setTel_prv(Integer tel_prv) {
        Tel_prv = tel_prv;
    }

    public String getCod_dis() {
        return Cod_dis;
    }

    public void setCod_dis(String cod_dis) {
        Cod_dis = cod_dis;
    }

    public String getRep_ven() {
        return Rep_ven;
    }

    public void setRep_ven(String rep_ven) {
        Rep_ven = rep_ven;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "Cod_prv='" + Cod_prv +
                ", Raz_soc_prv='" + Raz_soc_prv +
                ", Dir_prv='" + Dir_prv +
                ", Tel_prv=" + Tel_prv +
                ", Cod_dis='" + Cod_dis +
                ", Rep_ven='" + Rep_ven +
                '}';
    }
}
