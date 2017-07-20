/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class Post {

    private Integer idPost;
    private Integer idAutore;
    private Integer idGruppi;
    private String text;
    private String urlFoto;
    private String link;
    private Integer destinazione;
    private Utente utentePost;
    
    public Post(){
        idAutore=null;
        idGruppi=null;
    }
    
    /**
     * @return the utentePost
     */
    public Utente getUtentePost() {
        return utentePost;
    }

    /**
     * @param u the utentePost to set
     */
    public void setUtentePost(Utente u) {
        this.utentePost = u;
    }
/**
     * @return the idPost
     */
    public Integer getIdPost() {
        return idPost;
    }

    /**
     * @param idPost the idPost to set
     */
    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    /**
     * @return the idAutore
     */
    public Integer getIdAutore() {
        return idAutore;
    }

    /**
     * @param idAutore the idAutore to set
     */
    public void setIdAutore(Integer idAutore) {
        this.idAutore = idAutore;
    }

    /**
     * @return the idGruppi
     */
    public Integer getIdGruppi() {
        return idGruppi;
    }

    /**
     * @param idGruppi the idGruppi to set
     */
    public void setIdGruppi(Integer idGruppi) {
        this.idGruppi = idGruppi;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the urlFoto
     */
    public String getUrlFoto() {
        return urlFoto;
    }

    /**
     * @param urlFoto the urlFoto to set
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the destinazione
     */
    public Integer getDestinazione() {
        return destinazione;
    }

    /**
     * @param destinazione the destinazione to set
     */
    public void setDestinazione(Integer destinazione) {
        this.destinazione = destinazione;
    }
   
}
