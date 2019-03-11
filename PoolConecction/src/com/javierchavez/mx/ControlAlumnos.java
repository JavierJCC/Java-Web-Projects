package com.javierchavez.mx;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.*;

/**
 * Servlet implementation class ControlAlumnos
 */
@WebServlet("/ControlAlumnos")
public class ControlAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;
	private ModeloAlumnos modeloAlumnos;
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			InitialContext ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			// nombre del recurso en el context.xml
			ds = (DataSource) env.lookup("jdbc/ecodeup");	
		} catch (NamingException e) {
			e.printStackTrace();
		}
		modeloAlumnos= new ModeloAlumnos(ds);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Leer el parametro por parte de la pagina web
		String elParamatro=request.getParameter("instruccion");
		if(elParamatro == null) {
			elParamatro="Listar";
			}
		
		switch(elParamatro) {
			case "insertaBD":
				System.out.println("Preparando argumentos para la insercion");
				insertaAlumnoBD(request, response);
				break;
			case "Listar":
				obtenerListaAlumnos(request, response);
				break;
			case "Cargar":
				obtenerDatosActializarAlumno(request, response);
				break;
			case "actualizaBD":
				actualizaAlumnoBD(request, response);
				break;
		}
		
		//si no se envia el parametro listas los productos

	}

	private void actualizaAlumnoBD(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Datos a actualizar son: "+request.getParameter("idAlumno"));
		Alumnos losAlumnos = new Alumnos(request.getParameter("cedula"), Integer.parseInt(request.getParameter("idAlumno")), request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("curso"));
		RequestDispatcher midispacher=null;
		if(!ModeloAlumnos.actualizaDatos(losAlumnos)){
			request.setAttribute("ESTADOAlUMNOS", "Se ha actualizado con exito");
			midispacher=request.getRequestDispatcher("/VistaInfoAlertas.jsp");
		}else {
			request.setAttribute("ESTADOAlUMNOS", "Ha ocurrido un problema");
			midispacher=request.getRequestDispatcher("/VistaInfoAlertas.jsp");
		}
		try {
			midispacher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void obtenerDatosActializarAlumno(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Actualizar datos de un alumno con id: "+request.getParameter("CAlumno"));
		Alumnos losAlumnos=null;
		losAlumnos = ModeloAlumnos.obtieneDatosActualizar(request.getParameter("CAlumno"));
		System.out.println("El id es: " +losAlumnos.getIdAlumnos());
		request.setAttribute("ACTUALIZAAlUMNOS", losAlumnos);
		RequestDispatcher midispacher=request.getRequestDispatcher("/Actualizar_Alumno.jsp");
		try {
			midispacher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertaAlumnoBD(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cedula=request.getParameter("cedula");
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String curso=request.getParameter("curso");
		//Creacion del objeto
		Alumnos losAlumnos= new Alumnos(cedula, nombre, apellido, curso);
		System.out.println("Elementos del objeto: "+losAlumnos.toString());
		ModeloAlumnos.insertaAlumno(losAlumnos);
	}

	private void obtenerListaAlumnos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Alumnos> alumnos; 
		System.out.println("..");
		try {
			alumnos=modeloAlumnos.getAlumnos();
			System.out.println("El size es: "+alumnos.size());
			request.setAttribute("LISTAAlUMNOS", alumnos);
			RequestDispatcher midispacher=request.getRequestDispatcher("/ListaAlumnos.jsp");
			midispacher.forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		System.out.println(".c.");
	}

}
