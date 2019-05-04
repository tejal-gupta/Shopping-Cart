package com.shoopingcart.controllers;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;  
import java.io.PrintWriter;   
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String e=request.getParameter("emailid");  
        String p=request.getParameter("password"); 
              
        if(LoginDao.validate(e, p)){  
        	HttpSession session=request.getSession();
        	session.setAttribute("username", e);
        	response.sendRedirect("home.jsp");
            //RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
            //rd.forward(request,response);  
        }  
        else{  
            out.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);  
        }  
              
        out.close();  
        }  
}
