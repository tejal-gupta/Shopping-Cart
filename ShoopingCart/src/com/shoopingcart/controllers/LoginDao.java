package com.shoopingcart.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.*;
/**
 * Servlet implementation class LoginDao
 */
@WebServlet("/LoginDao")
public class LoginDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDao() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static boolean validate(String e,String p){  
    	boolean status=false;  
    	try{  
    	Class.forName("com.mysql.cj.jdbc.Driver");  
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");  
    	      
    	PreparedStatement ps=con.prepareStatement(  
    	"select * from test.userdetails where email_id=? and password=?");  
    	ps.setString(1,e);  
    	ps.setString(2,p);  
    	      
    	ResultSet rs=ps.executeQuery();  
    	status=rs.next();  
          
    	}catch(Exception exp){System.out.println(exp);}  
    	return status;  
    	}  
    
}
