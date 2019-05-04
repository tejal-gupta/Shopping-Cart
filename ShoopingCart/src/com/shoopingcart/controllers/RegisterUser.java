package com.shoopingcart.controllers;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.Driver;/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out1 = response.getWriter(); 
		
		out1.print("hellooooo");
		
		Connection con1=null;
        //Statement stmt1=null;
		String e=request.getParameter("emailid");
		String p=request.getParameter("password");
		String n=request.getParameter("name");
		String ph=request.getParameter("phone");
		String a=request.getParameter("address");
		String d=request.getParameter("dob");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
		}
		catch(ClassNotFoundException cnfe){ 
			cnfe.printStackTrace();
		}
		
		try {
			con1 = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
			 PreparedStatement ps=con1.prepareStatement("insert into test.userdetails values(?,?,?,?,?,?)");  
			 ps.setString(1, e);  
			 ps.setString(2, p);  
			 ps.setString(3, n);  
			 ps.setString(4, ph);  
			 ps.setString(5, a);
			 ps.setString(6, d);
			 
			 
			 int i=ps.executeUpdate();  
			 if(i>0)  
		     {HttpSession session=request.getSession();
	        	session.setAttribute("username", e);
	        	response.sendRedirect("home.jsp");
				 //RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 
             //rd.forward(request,response);
				 }
			 
			 else{
				 out1.print("not reg");
			 }
		}
		
		catch (SQLException e1) {
			e1.printStackTrace();
		}
       
	}

}
