package com.tecsup.prj_fastquiz.modelo.entities;

public class Vendedor {
    private String Cod_ven;
    private String Nom_ven;
    private String Ape_ven;
    private String Sue_ven;
    private String Fec_ing;
    private Integer Tip_ven;
    private String Usu_ven;
    private String Pas_ven;

    public Vendedor() {}

    public Vendedor(String cod_ven, String nom_ven, String ape_ven, String sue_ven, String fec_ing, Integer tip_ven, String usu_ven, String pas_ven) {
        Cod_ven = cod_ven;
        Nom_ven = nom_ven;
        Ape_ven = ape_ven;
        Sue_ven = sue_ven;
        Fec_ing = fec_ing;
        Tip_ven = tip_ven;
        Usu_ven = usu_ven;
        Pas_ven = pas_ven;
    }

    public String getCod_ven() {
        return Cod_ven;
    }

    public void setCod_ven(String cod_ven) {
        Cod_ven = cod_ven;
    }

    public String getNom_ven() {
        return Nom_ven;
    }

    public void setNom_ven(String nom_ven) {
        Nom_ven = nom_ven;
    }

    public String getApe_ven() {
        return Ape_ven;
    }

    public void setApe_ven(String ape_ven) {
        Ape_ven = ape_ven;
    }

    public String getSue_ven() {
        return Sue_ven;
    }

    public void setSue_ven(String sue_ven) {
        Sue_ven = sue_ven;
    }

    public String getFec_ing() {
        return Fec_ing;
    }

    public void setFec_ing(String fec_ing) {
        Fec_ing = fec_ing;
    }

    public Integer getTip_ven() {
        return Tip_ven;
    }

    public void setTip_ven(Integer tip_ven) {
        Tip_ven = tip_ven;
    }

    public String getUsu_ven() {
        return Usu_ven;
    }

    public void setUsu_ven(String usu_ven) {
        Usu_ven = usu_ven;
    }

    public String getPas_ven() {
        return Pas_ven;
    }

    public void setPas_ven(String pas_ven) {
        Pas_ven = pas_ven;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "Cod_ven='" + Cod_ven + '\'' +
                ", Nom_ven='" + Nom_ven + '\'' +
                ", Ape_ven='" + Ape_ven + '\'' +
                ", Sue_ven='" + Sue_ven + '\'' +
                ", Fec_ing='" + Fec_ing + '\'' +
                ", Tip_ven=" + Tip_ven +
                ", Usu_ven='" + Usu_ven + '\'' +
                ", Pas_ven='" + Pas_ven + '\'' +
                '}';
    }
}
