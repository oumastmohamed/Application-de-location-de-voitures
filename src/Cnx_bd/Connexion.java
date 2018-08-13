/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cnx_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleDriver;



/**
 *
 * @author YASSINE
 */
public class Connexion {
   private Connection cnx;
   private Statement stat;
   private ResultSet res;
 public static  Connexion cnn=null;
  
    //----------------------------------------------------------------
   private Connexion() throws SQLException {
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    public static Connexion  GetCnx() throws SQLException{
        if(cnn==null)
           return  new Connexion();
        else
        return cnn;    
    }
    //-----------------------------------------------------------------
    public void Connecter(String login,String pw) throws SQLException{
        setCnx(DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE",login,pw));
        System.out.println("vous ete connecter");
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public ResultSet getRes() {
        return res;
    }

    public Statement getStat() {
        return stat;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    public void setStat(Statement stat) {
        this.stat = stat;
    }
    
    

   
    
   
   
}
