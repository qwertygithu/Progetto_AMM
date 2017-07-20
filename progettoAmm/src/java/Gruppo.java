/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class Gruppo {

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_fondatore
     */
    public int getId_fondatore() {
        return id_fondatore;
    }

    /**
     * @param id_fondatore the id_fondatore to set
     */
    public void setId_fondatore(int id_fondatore) {
        this.id_fondatore = id_fondatore;
    }

    /**
     * @return the urlIcona
     */
    public String getUrlIcona() {
        return urlIcona;
    }

    /**
     * @param urlIcona the urlIcona to set
     */
    public void setUrlIcona(String urlIcona) {
        this.urlIcona = urlIcona;
    }
    private String nome;
    private Integer id;
    private Integer id_fondatore;
    private String urlIcona;
    
}
