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
public class PostFactory {
    
    private int idPost;
    private Integer idAutore;
    private Integer idGruppi;
    private String text;
    private String urlFoto;
    private String link;
    private int destinazione;
    private Utente utPost;
    
    //Pattern Design Singleton
    private static PostFactory singleton;
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
   ArrayList <Post> listaPost= new ArrayList<Post>();
   
    private PostFactory(){
       /*Post post=new Post();
        post.setDestinazione(0);
        post.setIdPost(0);
        post.setText("questo è il mio primo post");
        post.setUrlFoto("https://cdn.pixabay.com/user/2015/01/20/20-56-42-330_250x250.jpg");
        post.setUtente(UtenteFactory.getInstance().getUtenteById(0));
        
        Post post1=new Post();
        post1.setDestinazione(1);
        post1.setIdPost(0);
        post1.setText("la mia prima immagine");
        post1.setUrlFoto("http://lightstorage.ecodibergamo.it/mediaon/cms.newecodibergamo/storage/site_media/media/photologue/2016/4/21/photos/cache/case-reali-in-festa-auguri-elisabettala-foto-ufficiale-di-4-generazioni-_1a40321e-06e9-11e6-848e-81a64c104ff9_700_455_big_story_linked_ima.jpg");
        post1.setUtente(UtenteFactory.getInstance().getUtenteById(1));
        
        Post post2=new Post();
        post2.setDestinazione(1);
        post2.setIdPost(1);
        post2.setText("io sono il secondo");
        post2.setUrlFoto("");
        post2.setLink("www.google.it");
        post2.setUtente(UtenteFactory.getInstance().getUtenteById(1));
        
        Post post3=new Post();
        post3.setDestinazione(1);
        post3.setIdPost(2);
        post3.setText("ciao terzo");
        post3.setUrlFoto("https://i1.wp.com/favfitness.com/wp-content/uploads/2013/06/3sxouc.jpg");
        post3.setLink("https://www.google.it");
        post3.setUtente(UtenteFactory.getInstance().getUtenteById(1));
        
        Post post4=new Post();
        post4.setDestinazione(3);
        post4.setIdPost(0);
        post4.setText("ciao come stai?? e da molto che non ci sentiamo!!");
        post4.setUrlFoto("");
        post4.setLink("");
        post4.setUtente(UtenteFactory.getInstance().getUtenteById(0));
        
        //POST DEI GRUPPI
        Post post5=new Post();
        post5.setDestinazione(45);
        post5.setIdPost(0);
        post5.setText("heilaaa mongolfieristii!!");
        post5.setUrlFoto("");
        post5.setLink("");
        post5.setUtente(UtenteFactory.getInstance().getUtenteById(1));
        
        Post post6=new Post();
        post6.setDestinazione(45);
        post6.setIdPost(1);
        post6.setText("vola vola vola");
        post6.setUrlFoto("http://all-kinds-of-photos.myblog.it/wp-content/uploads/sites/302177/2012/11/1880753956.jpg");
        post6.setLink("");
        post6.setUtente(UtenteFactory.getInstance().getUtenteById(3));
        
        Post post7=new Post();
        post7.setDestinazione(46);
        post7.setIdPost(0);
        post7.setText("siamo in ritardo!! dfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtrdfds garg ar gar gra ga fgdaf gadf g dfg dsf g adfghgfasergwtr wtrb rtgr gfsd gs b");
        post7.setUrlFoto("");
        post7.setLink("");
        post7.setUtente(UtenteFactory.getInstance().getUtenteById(0));
        
        Post post8=new Post();
        post8.setDestinazione(47);
        post8.setIdPost(0);
        post8.setText("ROOOOOCK!!");
        post8.setUrlFoto("http://eyeonwebzine.altervista.org/wp-content/uploads/2016/08/Dimebag-Darrell.jpg");
        post8.setLink("");
        post8.setUtente(UtenteFactory.getInstance().getUtenteById(2));
        
        Post post9=new Post();
        post9.setDestinazione(47);
        post9.setIdPost(1);
        post9.setText("buon san'paganino raga");
        post9.setUrlFoto("https://upload.wikimedia.org/wikipedia/commons/7/73/Niccolo_Paganini01.jpg");
        post9.setLink("");
        post9.setUtente(UtenteFactory.getInstance().getUtenteById(3));
        
        Post post10=new Post();
        post10.setDestinazione(47);
        post10.setIdPost(2);
        post10.setText("a chi piace corey? ");
        post10.setUrlFoto("http://loudwire.com/files/2013/06/167973965.jpg");
        post10.setLink("");
        post10.setUtente(UtenteFactory.getInstance().getUtenteById(0));
        
        Post post11=new Post();
        post11.setDestinazione(47);
        post11.setIdPost(3);
        post11.setText("ROCK RIO ");
        post11.setUrlFoto("http://www.billboard.com/files/media/rock-in-rio-usa-650.jpg");
        post11.setLink("");
        post11.setUtente(UtenteFactory.getInstance().getUtenteById(2));
        
        Post post12=new Post();
        post12.setDestinazione(48);
        post12.setIdPost(0);
        post12.setText("e anche oggi leggiamo domani!");
        post12.setUrlFoto("http://www.fmach.it/var/fem/storage/images/servizi-generali/biblioteca/leggi-con-noi/la-promozione-della-lettura/259098-14-ita-IT/La-promozione-della-lettura_popup.jpg");
        post12.setLink("");
        post12.setUtente(UtenteFactory.getInstance().getUtenteById(3));
        
        
        listaPost.add(post);
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);
        listaPost.add(post6);
        listaPost.add(post7);
        listaPost.add(post8);
        listaPost.add(post9);
        listaPost.add(post10);
        listaPost.add(post11);
        listaPost.add(post12);
        */
    }
    
    public Post getPostById(int id){
        
        Post currentPost = new Post(); 
        try{ 
          
        //percorso del dataBase
        //String dbPath="jdbc:derby://localhost:1527/ammdb";
        //creazione della connessione con il DB
        Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");  
          
        //Statement stmt=conn.createStatement();
        String sql="select * from Post where " +"id=?";
        
        PreparedStatement stmt=conn.prepareStatement(sql);
        
        // Si associano i valori
        stmt.setInt(1, id);
            
        // Esecuzione query
        ResultSet res = stmt.executeQuery();
        
        
        // ciclo sulle righe restituite
        if (res.next()) {
            currentPost.setIdPost(res.getInt("idPost"));
            currentPost.setIdAutore(res.getInt("idAutore"));
            currentPost.setIdGruppi(res.getInt("idGruppi"));
            currentPost.setText(res.getString("text"));
            currentPost.setUrlFoto(res.getString("urlFoto"));
            currentPost.setLink(res.getString("link"));
            currentPost.setDestinazione(res.getInt("destinazione"));
            
            stmt.close();
            conn.close();
            return currentPost;
        }}catch(SQLException ex){
           //ex.printStackTrace();
           Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
        return currentPost;
        
        /*for (Post p : this.listaPost) {
            if (p.getIdPost() == id) {
                return p;
            }
        }
        return null;
        */
    } 
    
    public void addNewPost(Post tmpPost){
         try{
            //percorso del dataBase
            //String dbPath="jdbc:derby://localhost:1527/ammdb";
            //creazione della connessione con il DB
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");   
            //Statement stmt=conn.createStatement();
            String sql="insert into Post(id,id_autore,id_gruppi,text,urlFoto,linkpost,destinazione)"+"values(default,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            
            // Si associano i valori
            if(tmpPost.getIdAutore()== null)    
                stmt.setNull(1,java.sql.Types.INTEGER);
            else    
                stmt.setInt(1, tmpPost.getIdAutore()); 
            
            if(tmpPost.getIdGruppi()== null)
                stmt.setNull(2,java.sql.Types.INTEGER);
            else
                stmt.setInt(2, tmpPost.getIdGruppi()); 
            
            stmt.setString(3, tmpPost.getText()); 
            stmt.setString(4, tmpPost.getUrlFoto()); 
            stmt.setString(5, tmpPost.getLink()); 
            
            stmt.setInt(6, tmpPost.getDestinazione());
            
            // Esecuzione query
            int rows = stmt.executeUpdate();
            if(rows == 1)
            System.out.println("Insert ok!");
            
        }catch(SQLException ex){
            Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Post> listaPost(int id){
        
        ArrayList<Post> listPost=new ArrayList<>();
        
        //Utente currentUtente = new Utente(); 
        try{ 
            //percorso del dataBase
            //String dbPath="jdbc:derby://localhost:1527/ammdb";
            //creazione della connessione con il DB
            Connection conn= DriverManager.getConnection(connectionString,"ammdb","ammdb");  

            //Statement stmt=conn.createStatement();
            String sql="select * from Post where " +"id=?";

            PreparedStatement stmt=conn.prepareStatement(sql);

            // Si associano i valori
            stmt.setInt(1, id);

            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while(res.next()) {
                Post currentPost=new Post();
                currentPost.setIdPost(res.getInt("id"));
                currentPost.setIdAutore(res.getInt("id_autore"));
                currentPost.setIdGruppi(res.getInt("id_gruppi"));
                currentPost.setText(res.getString("text"));
                currentPost.setUrlFoto(res.getString("urlFoto"));
                currentPost.setLink(res.getString("linkPost"));
                currentPost.setDestinazione(res.getInt("destinazione"));
                
                listPost.add(currentPost);
            }
            stmt.close();
            conn.close();
            
            for(Post tmp: listPost){
                tmp.setUtentePost(UtenteFactory.getInstance().getUtenteById(tmp.getIdAutore()));
                
            }
            return listPost;
        }catch(SQLException ex){
           //ex.printStackTrace();
           Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
        return listPost;
        
        /*
        for (Post p : this.listaPost) {
            if (p.getDestinazione()== id) {
                l.add(p);
            }
        }
        return l;
        */
    }
    
}
