/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sam
 */
public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
				
        response.setContentType("text/html;charset=UTF-8");
        //controllo che l'utente sia gia loggato
                
        HttpSession session = request.getSession(false);
                 
        if(session==null || session.getAttribute("loggedIn") == null ){
            response.sendRedirect("login.html");
        }
        else//sono loggato
        {
            Gruppo gruppoTmp;
            Utente tmp,utentePost;
            Integer idOtherUtente=null;
            Integer idOtherGruppo=null;
  
            /**controllo se è stato cliccato un utente nella SideBarSx**/
            if(request.getParameter("QWERTY")!=null){
                idOtherUtente=Integer.parseInt(request.getParameter("QWERTY"));
                idOtherGruppo=null;
            }// altrimenti controllo se sono in un gruppo
            else if(request.getParameter("GRUPPI")!=null){
                idOtherGruppo=Integer.parseInt(request.getParameter("GRUPPI"));
                idOtherUtente=null;
            }
            
            //controllo se c'e un post
            if(request.getParameter("thereIsPost")!=null)
            {       
                String thereIsPost = request.getParameter("thereIsPost");//flag del post
                String testopost = request.getParameter("testoPost");//testo del post
                String tipoPost = request.getParameter("tipoPost");//se contiene una immagine o un ink
                String urlPost = request.getParameter("urlPost");//url immagine o link
                //Integer idBachecaOtherUtente=idOtherUtente;
                        
                //c'e un post!
                if(thereIsPost.equals("needConfirm"))
                {
                    /*  bisogna impostare :

                        idPost -automatico dal DB;
                        idAutore -
                        idGruppi -
                        text -
                        utente - l'autore del post passato come oggetto
                        urlFoto-
                        link -
                        destinazione -
                    */
                            
                    Post post = new Post();
                    post.setText(testopost);
                    
                    switch(tipoPost){
                        case "imm":
                            post.setUrlFoto(urlPost);
                             post.setLink(null);
                            break;
                        case "link":
                            post.setLink(urlPost);
                            post.setUrlFoto(null);
                            break;                                    
                    }
                    post.setIdAutore((int)session.getAttribute("loggedUserID"));
                            
                            
                    /**controllo la destinazione del post**/
                    if(idOtherUtente!=null){//se la destinazione e' la bacheca di un utente
                        post.setDestinazione(idOtherUtente);
                        post.setIdGruppi(null);
                    }
                    else {//e la destinazione nonn e' la bacheca di un utente
                        if(idOtherGruppo!=null){
                            post.setDestinazione(null);
                            post.setIdGruppi(idOtherGruppo);
                        }
                        else{
                            post.setDestinazione((int)session.getAttribute("loggedUserID"));
                            post.setIdGruppi(null);
                        }
                    }
                    
                    PostFactory.getInstance().addNewPost(post); //aggiunto il post nel DB  
                    request.setAttribute("newpost","confirmed"); //
                    ArrayList<Post> lPost= PostFactory.getInstance().listaPost(idOtherUtente);// lista dei post
                    ArrayList<Utente> lUtenti= UtenteFactory.getInstance().getListUtenti();// lista utenti
                    ArrayList<Utente> utentiDeiPost=new ArrayList<>();
                    
                    tmp=UtenteFactory.getInstance().getUtenteById((int)session.getAttribute("loggedUserID"));//utente loggato
                    request.setAttribute("utenteBachecaAttuale",UtenteFactory.getInstance().getUtenteById(idOtherUtente));
                    request.setAttribute("utente",tmp);  //l'utente logato
                    request.setAttribute("l",lPost);    //lista dei post dell'utente cliccato
                    request.setAttribute("listUt",lUtenti); //'lista di tutti gli utenti'
                    request.setAttribute("QWERTY", request.getParameter("QWERTY"));
                    request.setAttribute("GRUPPI", request.getParameter("GRUPPI"));
                    
                   /** for(Post postApp : lPost){
                        Utente utenteApp=new Utente();
                        utenteApp=UtenteFactory.getInstance().getUtenteById(postApp.getIdAutore());
                        utentiDeiPost.add(utenteApp);
                    }**/
                    
                    //request.setAttribute("utentiDeiPost",utentiDeiPost); //array parallelo a qiello dei post dell utente corrente
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }
                   
            }
            /**controllo se sono nella bacheca di un gruppo o di un utente**/
            if(idOtherUtente!=null )//se sono nella bacheca di un'altro utente
            {
                ArrayList<Post> lPost= PostFactory.getInstance().listaPost(idOtherUtente);//lista dei post nella bacheca dell'utente
                ArrayList<Gruppo> lGruppi= GruppoFactory.getInstance().getListaGruppi();;//lista dei gruppi
                ArrayList<Utente> lUtenti= UtenteFactory.getInstance().getListUtenti();//lista di tutti gli utenti
                tmp=UtenteFactory.getInstance().getUtenteById((int)session.getAttribute("loggedUserID"));//utente loggato

                request.setAttribute("utente",tmp);  //l'utente logato
                request.setAttribute("l",lPost);    //lista dei post in base in quale bacheca ci si trova
                request.setAttribute("listUt",lUtenti); //'lista di tutti gli utenti'
                request.setAttribute("listaGruppi",lGruppi); //'lista di tutti i gruppi
                
                request.setAttribute("QWERTY", request.getParameter("QWERTY"));
                request.setAttribute("GRUPPI", request.getParameter("GRUPPI"));
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);  
            }
            else{
                    if(idOtherGruppo!=null)//sono nella bacheca di un gruppo
                    {
                        ArrayList<Post> lPost= PostFactory.getInstance().listaPost(idOtherGruppo);//lista dei post nella bacheca dell'utente
                        ArrayList<Gruppo> lGruppi= GruppoFactory.getInstance().getListaGruppi();;//lista dei gruppi
                        ArrayList<Utente> lUtenti= UtenteFactory.getInstance().getListUtenti();//lista di tutti gli utenti
                        tmp=UtenteFactory.getInstance().getUtenteById((int)session.getAttribute("loggedUserID"));//utente loggato
                        gruppoTmp=GruppoFactory.getInstance().getGruppoById((int)idOtherGruppo);//utente loggato

                        request.setAttribute("utente",tmp);  //l'utente logato
                        request.setAttribute("l",lPost);    //lista dei post in base in quale bacheca ci si trova
                        request.setAttribute("listUt",lUtenti); //'lista di tutti gli utenti'
                        request.setAttribute("listaGruppi",lGruppi); //'lista di tutti i gruppi
                        request.setAttribute("gruppoAttuale",gruppoTmp); //gruppo sul quale mi trovo
                        
                        request.setAttribute("QWERTY", request.getParameter("QWERTY"));
                        request.setAttribute("GRUPPI", request.getParameter("GRUPPI"));
                        request.getRequestDispatcher("bacheca.jsp").forward(request, response); 
                    }
                    else{//sono nella mia bacheca
                        ArrayList<Post> lPost= PostFactory.getInstance().listaPost((int)session.getAttribute("loggedUserID"));
                        ArrayList<Utente> lUtenti= UtenteFactory.getInstance().getListUtenti();
                        ArrayList<Gruppo> lGruppi= GruppoFactory.getInstance().getListaGruppi();;//lista dei gruppi
                        tmp=UtenteFactory.getInstance().getUtenteById((int)session.getAttribute("loggedUserID"));
                        
                        request.setAttribute("utente",tmp);  
                        request.setAttribute("l",lPost);
                        request.setAttribute("listUt",lUtenti);
                        request.setAttribute("listaGruppi",lGruppi); //'lista di tutti i gruppi
                        
                            
                        request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    }
                }
        }
            
    }
               


    
    
    
    
    
    
    
    
    
    
    

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
