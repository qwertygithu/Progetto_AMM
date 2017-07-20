
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
class GruppoFactory {

   
     //Pattern Design Singleton
    private static GruppoFactory singleton;
    private String connectionString;
    
    private int id;
    private String nome;
    private String fondatore;
    
    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }
    private GruppoFactory(){
       
    }
   public void setConnectionString(String s){
	this.connectionString = s;
}
    public String getConnectionString(){
	return this.connectionString;
    }
    public Gruppo getGruppoById(int id){
        Gruppo currentGruppo = new Gruppo(); 
        try{ 
        //percorso del dataBase
        //String dbPath="jdbc:derby://localhost:1527/ammdb";
        //creazione della connessione con il DB
        Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");  
          
        //Statement stmt=conn.createStatement();
        String sql="select * from Gruppo where " +"id=?";
        
        PreparedStatement stmt=conn.prepareStatement(sql);
        
        // Si associano i valori
        stmt.setInt(1, id);
            
        // Esecuzione query
        ResultSet res = stmt.executeQuery();
        // ciclo sulle righe restituite
        if (res.next()) {
            currentGruppo.setId(res.getInt("id"));
            currentGruppo.setId_fondatore(res.getInt("id_fondatore"));
            currentGruppo.setNome(res.getString("nome"));
            currentGruppo.setUrlIcona(res.getString("urlIcona"));
            
            stmt.close();
            conn.close();
            return currentGruppo;
        }}catch(SQLException ex){
           //ex.printStackTrace();
           Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
       }
        return currentGruppo;
        
    
    }
    public ArrayList<Gruppo> getListaGruppi(){
        ArrayList<Gruppo> listGruppi=new ArrayList<>();
    
        
        try{ 
          
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");  
            Statement stmt = conn.createStatement();
            //Statement stmt=conn.createStatement();
            String sql="select * from Gruppi";
            // Esecuzione query
            ResultSet set = stmt.executeQuery(sql);

            // ciclo sulle righe restituite
            while (set.next()) {
                 Gruppo currentGruppo=new Gruppo();

                 currentGruppo.setId(set.getInt("id"));
                 currentGruppo.setId_fondatore(set.getInt("fondatore"));
                 currentGruppo.setNome(set.getString("nome"));
                 currentGruppo.setUrlIcona(set.getString("urlIcona"));

                 listGruppi.add(currentGruppo);
             }
                 stmt.close();
                 conn.close();
                 
            return listGruppi;
        }catch(SQLException ex){
            //ex.printStackTrace();
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listGruppi;
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
     * @return the fondatore
     */
    public String getFondatore() {
        return fondatore;
    }

    /**
     * @param fondatore the fondatore to set
     */
    public void setFondatore(String fondatore) {
        this.fondatore = fondatore;
    }
    

}
