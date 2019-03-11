package com.javierchavez.mx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private DataSource ds;

	/**
	 * @return 
	 * @see HttpServlet#HttpServlet()
	 */
	public void Index() {

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			InitialContext ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			// nombre del recurso en el context.xml
			ds = (DataSource) env.lookup("jdbc/ecodeup");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida=response.getWriter();
		String sql = "SELECT * FROM ALUMNOS";
		try {
			con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			System.out.println("ID | CÉDULA | NOMBRES  | APELLIDOS | CURSO  ");
			while (rset.next()) {				
				System.out.println(rset.getInt(1)+" | "+rset.getString(2)+" | "+rset.getString(3)+" | "+rset.getString(4)+" | "+rset.getString(5));
				salida.println(rset.getInt(1)+" | "+rset.getString(2)+" | "+rset.getString(3)+" | "+rset.getString(4)+" | "+rset.getString(5));
				salida.println("<br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
