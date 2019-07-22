package com.webApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class PrintEmployeeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{    
		List<Employee> empList=(List<Employee>) request.getAttribute("details");
		 PrintWriter out=response.getWriter();
		  request.setAttribute("list",empList);
		  RequestDispatcher rq=request.getRequestDispatcher("PrintResult.jsp");
			 rq.forward(request, response);
	}
}
