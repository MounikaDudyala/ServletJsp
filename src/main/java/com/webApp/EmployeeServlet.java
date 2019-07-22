package com.webApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		response.setContentType("text/Html");
		ResultSet rs = getResultSet();
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			while(rs.next())
			{
			String name = rs.getString("name");
			int id = rs.getInt("id");
			int managerId = rs.getInt("managerid");
			Employee emp = new Employee(id, name, managerId);
			employeeList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("details", employeeList);
		 RequestDispatcher rd=request.getRequestDispatcher("print");
		 rd.forward(request, response);

	}

	public ResultSet getResultSet() {
		Connection conn = null;
		Statement statement = null;
		String url = "jdbc:mysql://localhost:3306/database2";
		String user = "root";
		String password = "root";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			statement = conn.createStatement();
			String sql = "select * from employee";
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return null;
	}

}
