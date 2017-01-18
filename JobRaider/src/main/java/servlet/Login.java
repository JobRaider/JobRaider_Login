package servlet;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Repository.Repository;



public class Login extends HttpServlet {
	Repository repository = new Repository();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");  
		   
		   
		    PrintWriter out = response.getWriter();    
		    String n=request.getParameter("name");  
		    String p=request.getParameter("pass");
		    System.out.println(n);
		    System.out.println(p);
		          
		    if(Repository.Validate(n, p)){  
		    	out.print("hola " + n + "   " + p) ;
		    
		    
		    }  
		    else{  
		    	out.print("Usuario no Registrado ");
		    			       
		    }  
		          
		    out.close();  
		   }  
		
	
 
	public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
doGet(request, response);

}
}
