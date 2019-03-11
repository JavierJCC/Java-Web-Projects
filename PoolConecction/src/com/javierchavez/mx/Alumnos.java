package com.javierchavez.mx;

public class Alumnos {
	private String cedula;
	private int idAlumnos;
	private String Nombres;
	private String Apellidos;
	private String Curso;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getIdAlumnos() {
		return idAlumnos;
	}

	public void setIdAlumnos(int idAlumnos) {
		this.idAlumnos = idAlumnos;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public Alumnos(String cedula, int idAlumnos, String nombres, String apellidos, String curso) {
		this.cedula = cedula;
		this.idAlumnos = idAlumnos;
		Nombres = nombres;
		Apellidos = apellidos;
		Curso = curso;
	}

	public Alumnos(String cedula, String nombres, String apellidos, String curso) {
		super();
		this.cedula = cedula;
		Nombres = nombres;
		Apellidos = apellidos;
		Curso = curso;
	}

	@Override
	public String toString() {
		return "Alumnos [cedula=" + cedula + ", idAlumnos=" + idAlumnos + ", Nombres=" + Nombres + ", Apellidos="
				+ Apellidos + ", Curso=" + Curso + "]";
	}
	
}
