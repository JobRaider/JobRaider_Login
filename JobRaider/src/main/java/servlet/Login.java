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
		 response.setContentType("text/html");  
		   
		    ObjectOutputStream out=new ObjectOutputStream(response.getOutputStream());
		         
		    String n=request.getParameter("name");  
		    String p=request.getParameter("pass");
		    System.out.println(n);
		    System.out.println(p);
		          
		    if(Repository.Validate(n, p)){  
		       out.writeChars("registrado"+ n);
		    
		    }  
		    else{  
		       out.writeChars("Usuario No Registrado");
		    			       
		    }  
		          
		    out.close();  
		   }  
		
	
 
	public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
doGet(request, response);

}
}
