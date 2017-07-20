/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sam
 */
public class UtenteFactory {
    
    //Pattern Design Singleton
    private static UtenteFactory singleton;
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

   // private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    private UtenteFactory() {
        //Creazione utenti
/*
        //pino
        Utente user1 = new Utente();
        user1.setId(0);
        user1.setNome("Pino");
        user1.setCognome("scalas");
        user1.setFrase("faccio ridere");
        user1.setEmail("pino@gmail.com");
        user1.setPassword("123");
        user1.setUrlFotoProfilo("http://immagini.quotidiano.net/?url=http://p1014p.quotidiano.net:80/polopoly_fs/1.2587451.1476280032!/httpImage/image.jpg_gen/derivatives/wide_680/image.jpg&h=350&w=606");
        user1.setData("05/12/1991");
        
        
        //luca
        Utente user2 = new Utente();
        user2.setId(1);
        user2.setNome("luca");
        user2.setCognome("corongiu");
        user2.setFrase("lavoro a colorado");
        user2.setEmail("lucaCorongiu@gmail.com");
        user2.setPassword("123");
        user2.setUrlFotoProfilo("http://static.televisionando.it/televisionando/fotogallery/1200X0/96685/i-comici-luca-e-paolo.jpg");
        user2.setData("05/12/1991");
       
        //trump
        Utente user3 = new Utente();
        user3.setId(2);
        user3.setNome("Trump");
        user3.setCognome("lecca");
        user3.setEmail("carlolecca@tiscali.com");
        user3.setPassword("123");
        user3.setUrlFotoProfilo("https://images.kurier.at/46-70842816.jpg/620x930nocrop/139.066.898");
        user3.setData("05/12/1991");
        
        //enzo
        Utente user4 = new Utente();
        user4.setId(3);
        user4.setNome("Enzo");
        user4.setCognome("Ferrari");
        user4.setFrase("brum brum");
        user4.setEmail("EnzoFerrari@Ferrari.com");
        user4.setPassword("123");
        user4.setUrlFotoProfilo("http://www.emiliaromagna.programmafly.it/keyportal/uploads/enzo-ferrari-alla-guida-dell-alfa.jpg");
        user4.setData("05/12/1991");
        
        listaUtenti.add(user1);
        listaUtenti.add(user2);
        listaUtenti.add(user3);
        listaUtenti.add(user4);*/
    }

    public Utente getUtenteById(int id) {
       Utente currentUtente = new Utente(); 
        try{ 
          
        //percorso del dataBase
        //String dbPath="jdbc:derby://localhost:1527/ammdb";
        //creazione della connessione con il DB
        Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");  
          
        //Statement stmt=conn.createStatement();
        String sql="select * from Utente where " +"id=?";
        
        PreparedStatement stmt=conn.prepareStatement(sql);
        
        // Si associano i valori
        stmt.setInt(1, id);
            
        // Esecuzione query
        ResultSet res = stmt.executeQuery();
        
        
        // ciclo sulle righe restituite
        if (res.next()) {
            currentUtente.setId(res.getInt("id"));
            currentUtente.setNome(res.getString("nome"));
            currentUtente.setCognome(res.getString("cognome"));
            currentUtente.setData(res.getString("dataNascita"));
            currentUtente.setFrase(res.getString("frase"));
            currentUtente.setPassword(res.getString("password"));
            currentUtente.setEmail(res.getString("email"));
            currentUtente.setUrlFotoProfilo(res.getString("urlFoto"));
            
            stmt.close();
            conn.close();
            return currentUtente;
        }}catch(SQLException ex){
           //ex.printStackTrace();
           Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
       }
        return currentUtente;
        
        
        
        
        /*for (Utente utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
        */
    }
    
    public int getIdByUserAndPassword(String nome, String password){
        int currentId=-1;
        try{
            //percorso del dataBase
            //String dbPath="jdbc:derby://localhost:1527/ammdb";
            //creazione della connessione con il DB
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");   
            //Statement stmt=conn.createStatement();
            String sql="select id from Utente where " +"nome=? and password=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            // Si associano i valori
            stmt.setString(1, nome); 
            stmt.setString(2, password); 
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                currentId=res.getInt("id");

                stmt.close();
                conn.close();
                return currentId;
        }}catch(SQLException ex){
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
         return currentId;    
  
         
        /*for(Utente utente : this.listaUtenti){
            if(utente.getNome().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;*/
    }
    public void addNewUtente(String nome,String password){
         try{
            //percorso del dataBase
            //String dbPath="jdbc:derby://localhost:1527/ammdb";
            //creazione della connessione con il DB
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");   
            //Statement stmt=conn.createStatement();
            String sql="insert into Utente(id,nome,password)values(default,'?','?')";
            PreparedStatement stmt=conn.prepareStatement(sql);
            // Si associano i valori
            stmt.setString(1, nome); 
            stmt.setString(2, password); 
            
            // Esecuzione query
            int rows = stmt.executeUpdate(sql);
            if(rows == 1)
            System.out.println("Insert ok!");
            
        }catch(SQLException ex){
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public ArrayList<Utente> getListUtenti(){
        ArrayList<Utente> utentTmp = new ArrayList<>();
    
        //Utente currentUtente = new Utente(); 
        try{ 
          
        //percorso del dataBase
        //String dbPath="jdbc:derby://localhost:1527/ammdb";
        //creazione della connessione con il DB
        Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");  
          
        Statement stmt=conn.createStatement();
        //Statement stmt=conn.createStatement();
        String sql="select * from Utente";
        // Esecuzione query
        ResultSet set = stmt.executeQuery(sql);
        
        // ciclo sulle righe restituite
        while(set.next()) {
            Utente currentUtente=new Utente();
            
            currentUtente.setId(set.getInt("id"));
            currentUtente.setNome(set.getString("nome"));
            currentUtente.setCognome(set.getString("cognome"));
            currentUtente.setData(set.getString("dataNascita"));
            currentUtente.setFrase(set.getString("frase"));
            currentUtente.setPassword(set.getString("password"));
            currentUtente.setEmail(set.getString("email"));
            currentUtente.setUrlFotoProfilo(set.getString("urlFoto"));
            
            utentTmp.add(currentUtente);
        }
            stmt.close();
            conn.close();
            return utentTmp;
        }catch(SQLException ex){
           //ex.printStackTrace();
           Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
       }
        return utentTmp;
        
        
        
        //return this.listaUtenti;
    }
}
