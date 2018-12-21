package com.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();  
        
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        
        LoginModel lm = new LoginModel();
        lm.setName(name);
        lm.setPassword(password);
        request.setAttribute("lm",lm); 

        boolean status=lm.validate();  
        
        if(status){  
            RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");  
            rd.forward(request, response);  
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");  
            rd.forward(request, response);  
        }  
      
    }  
	


protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
        throws ServletException, IOException {  
    doPost(req, resp);  
}  
}  
