package com.javierchavez.mx;

import javax.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ModeloAlumnos {
	private static DataSource origenAlumnos;
	
	public ModeloAlumnos(DataSource origenAlumnos) {
		this.origenAlumnos = origenAlumnos;
	}

	public List<Alumnos> getAlumnos() throws Exception {
		List<Alumnos> Alumnos= new ArrayList<>();
		Connection miConAlumnos=null;
		Statement miStaAlumnos=null;
		ResultSet miRsAlumnos=null;
		/*
		 * 	Establecer la conexion
		 * 	crear sentencia sql
		 * 	ejecutar y recorrer
		 * */
		miConAlumnos=origenAlumnos.getConnection();
		String query="SELECT * FROM ALUMNOS";
		miStaAlumnos=miConAlumnos.createStatement();
		miRsAlumnos = miStaAlumnos.executeQuery(query);
			while(miRsAlumnos.next()){
				int idAlumno=miRsAlumnos.getInt("idAlumnos");
				String cedula=miRsAlumnos.getString("cedula");
				String Nombres=miRsAlumnos.getString("Nombres");
				System.out.println("El nombre es;"+Nombres);
				String Apellidos=miRsAlumnos.getString("Apellidos");
				String Curso=miRsAlumnos.getString("Curso");
				Alumnos.add(new Alumnos(cedula, idAlumno, Nombres, Apellidos, Curso));
			}
		return Alumnos;
	}

	public static void insertaAlumno(Alumnos losAlumnos) {
		// TODO Auto-generated method stub
		Connection miConAlumnos=null;
		PreparedStatement miPreparedStaAlumnos=null;
		/*
		 * 	Establecer la conexion
		 * 	crear sentencia sql
		 * 	ejecutar y recorrer
		 * */
		try {
			
			miConAlumnos=origenAlumnos.getConnection();
			
			String query="INSERT INTO ALUMNOS (idAlumnos, cedula, Nombres, Apellidos, Curso)"+
			"VALUES (NULL,?,?,?,?)";
			
			miPreparedStaAlumnos=miConAlumnos.prepareStatement(query);
			miPreparedStaAlumnos.setString(1, losAlumnos.getCedula());
			miPreparedStaAlumnos.setString(2, losAlumnos.getNombres());
			miPreparedStaAlumnos.setString(3, losAlumnos.getApellidos());
			miPreparedStaAlumnos.setString(4, losAlumnos.getCurso());
			
			miPreparedStaAlumnos.execute();

		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("No se pudo insertar debido a un problema");
		}
		
	}

	public static Alumnos obtieneDatosActualizar(String parameter) {
		// TODO Auto-generated method stub
		System.out.println("Obteniendo datos");
		Connection miConAlumnos=null;
		PreparedStatement miPreparedStaAlumnos=null;
		String sql="SELECT * FROM ALUMNOS WHERE idAlumnos = ?";
		ResultSet miRsAlumnos=null;
		Alumnos losalumnos=null;
		try {
			miConAlumnos=origenAlumnos.getConnection();
			miPreparedStaAlumnos=miConAlumnos.prepareStatement(sql);
			miPreparedStaAlumnos.setString(1, parameter);
			miRsAlumnos=miPreparedStaAlumnos.executeQuery();
			
			while(miRsAlumnos.next()) {
				losalumnos= new Alumnos(miRsAlumnos.getString("cedula"), miRsAlumnos.getInt("idAlumnos"), miRsAlumnos.getString("Nombres"), miRsAlumnos.getString("Apellidos"), miRsAlumnos.getString("Curso"));
				System.out.println("El alumno es: "+ miRsAlumnos.getInt("idAlumnos")+"--"+miRsAlumnos.getString("cedula")+"--"+miRsAlumnos.getString("Nombres")+
						"--"+miRsAlumnos.getString("Apellidos")+"--"+miRsAlumnos.getString("Curso"));
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return losalumnos;
	}

	public static boolean actualizaDatos(Alumnos losAlumnos) {
		// TODO Auto-generated method stub
		Connection miConAlumnos=null;
		PreparedStatement miPreparedStaAlumnos=null;
		String sql="UPDATE ALUMNOS SET cedula = ?, Nombres = ?, Apellidos = ?, Curso = ? WHERE idAlumnos = ?";
		try {
			miConAlumnos=origenAlumnos.getConnection();
			miPreparedStaAlumnos=miConAlumnos.prepareStatement(sql);
			miPreparedStaAlumnos.setString(1, losAlumnos.getCedula());
			miPreparedStaAlumnos.setString(2, losAlumnos.getNombres());
			miPreparedStaAlumnos.setString(3, losAlumnos.getApellidos());
			miPreparedStaAlumnos.setString(4, losAlumnos.getCurso());
			miPreparedStaAlumnos.setInt(5, losAlumnos.getIdAlumnos());
			System.out.println("Listo para actualizar "+ miPreparedStaAlumnos.toString());
			boolean salida=false;
			salida=miPreparedStaAlumnos.execute();
			return salida;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("No se pudo insertar debido a un problema");
		}
		return true;
	}
	

}
