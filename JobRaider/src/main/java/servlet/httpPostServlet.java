package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Repository.Repository;



public class httpPostServlet extends HttpServlet {
	Repository repository = new Repository();
public void doGet(HttpServletRequest request,HttpServletResponse response)
     throws ServletException, IOException {
 response.setContentType("text/html");
String recived_data=" ";
ObjectOutputStream out=new ObjectOutputStream(response.getOutputStream());


 String s1=request.getParameter("name");
String s3=request.getParameter("ape");
 String s2=request.getParameter("pass");
 String s4=request.getParameter("dni");
 System.out.println(s1);
System.out.println(s2);
 System.out.println(s3); 
 System.out.println(s4); 

 
	   repository.InsertUser(s1, s2, s3,s4 ); 
	       out.writeObject("Registrado " + s1);
	    
	  
	    out.close();  
}  

    	
    	
    	 

public void doPost(HttpServletRequest request,HttpServletResponse response)
     throws ServletException, IOException {
 doGet(request, response);
}

}
